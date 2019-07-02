/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */
package longhoang.test.teko.core;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import longhoang.test.teko.BR;
import longhoang.test.teko.di.Injectable;
import longhoang.test.teko.utils.CommonUtils;
import longhoang.test.teko.utils.NetworkUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
    extends AppCompatActivity
    implements BaseFragment.Callback, Injectable {
    private final Observer<String> showToastObs = msg -> {
        // Update the UI, in this case, a TextView.
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    };
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    // TODO
    // this can probably depend on isLoading variable of BaseViewModel,
    // since its going to be common for all the activities
    private ProgressDialog mProgressDialog;
    private final Observer<Boolean> showProgressObs = o -> {
        if (o) {
            showLoading();
        } else {
            hideLoading();
        }
    };
    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    protected int getBindingVariable() {
        return BR.viewModel;
    }

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public V getViewModel() {
        return mViewModel;
    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
            checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    //    public void openActivityOnTokenExpire() {
//        startActivity(LoginActivity.newIntent(this));
//        finish();
//    }
    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        String name;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O_MR1) {
            name =
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]
                    .getTypeName();
        } else {
            name = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[1].toString().replace("class ", "");
        }
        try {
            this.mViewModel =
                ViewModelProviders.of(this, viewModelFactory).get((Class<V>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (!mViewDataBinding.setVariable(getBindingVariable(), mViewModel)) {
            throw new IllegalArgumentException("You should add 'viewModel' variable");
        }
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
        mViewModel.toastMessages.observe(this, showToastObs);
        mViewModel.showProgressDialog.observe(this, showProgressObs);
    }

    protected void changeFragment(int layoutId, Fragment fragment) {
        changeFragment(layoutId, fragment, fragment.getClass().getSimpleName());
    }

    protected void changeFragment(int layoutId, Fragment fragment, String tagFragmentName) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        Fragment currentFragment = mFragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }
        Fragment fragmentTemp = mFragmentManager.findFragmentByTag(tagFragmentName);
        if (fragmentTemp == null) {
            fragmentTemp = fragment;
            fragmentTransaction.add(layoutId, fragmentTemp, tagFragmentName);
        } else {
            fragmentTransaction.show(fragmentTemp);
        }
        fragmentTransaction.setPrimaryNavigationFragment(fragmentTemp);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNowAllowingStateLoss();
    }

    public void replaceFragment(Fragment frg, int layoutId) {
        replaceFragment(frg, layoutId, frg.getClass().getSimpleName());
    }

    public void replaceFragment(Fragment frg, int layoutId, String TAG) {
        getSupportFragmentManager().beginTransaction().replace(layoutId, frg, TAG).commit();
    }

    public void addFragmentWithoutBackStack(Fragment frg, int layoutId, String TAG) {
        getSupportFragmentManager().beginTransaction().add(layoutId, frg, TAG).commit();
    }

    public void addFragmentWithoutBackStack(Fragment frg, int layoutId) {
        addFragmentWithoutBackStack(frg, layoutId, frg.getClass().getSimpleName());
    }

    public void addFragment(Fragment frg, int layoutId) {
        addFragment(frg, layoutId, frg.getClass().getSimpleName());
    }

    public void addFragment(Fragment frg, int layoutId, String TAG) {
        getSupportFragmentManager().beginTransaction().add(layoutId, frg, TAG).addToBackStack(TAG)
            .commit();
    }
}

