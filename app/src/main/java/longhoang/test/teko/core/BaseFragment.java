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

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import longhoang.test.teko.BR;
import longhoang.test.teko.di.Injectable;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel>
    extends Fragment implements Injectable {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private BaseActivity mActivity;
    private final Observer<String> showToastObs = msg -> {
        // Update the UI, in this case, a TextView.
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    };
    private final Observer<Boolean> showProgressObs = o -> {
        if (o) {
            mActivity.showLoading();
        } else {
            mActivity.hideLoading();
        }
    };
    private View mRootView;
    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public int getBindingVariable() {
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getParentFragment() != null) {
            onAttachToParentFragment(getParentFragment());
        }
    }

    protected void onAttachToParentFragment(Fragment parentFragment) {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    public boolean isNetworkConnected() {
        return mActivity != null && mActivity.isNetworkConnected();
    }

    public interface Callback {
        void onFragmentAttached();
        void onFragmentDetached(String tag);
    }

    public void replaceFragment(Fragment frg, int layoutId) {
        replaceFragment(frg, layoutId, frg.getClass().getSimpleName());
    }

    public void replaceFragment(Fragment frg, int layoutId, String TAG) {
        getChildFragmentManager().beginTransaction().replace(layoutId, frg, TAG)
            .commit();
    }

    public void addFragmentWithoutBackStack(Fragment frg, int layoutId,
                                            String TAG) {
        String tag = frg.getClass().getSimpleName();
        getChildFragmentManager().beginTransaction().add(layoutId, frg, TAG).commit();
    }

    public void addFragmentWithoutBackStack(Fragment frg, int layoutId) {
        addFragmentWithoutBackStack(frg, layoutId, frg.getClass().getSimpleName());
    }

    public void addFragment(Fragment frg, int layoutId) {
        addFragment(frg, layoutId, frg.getClass().getSimpleName());
    }

    public void addFragment(Fragment frg, int layoutId, String TAG) {
        getChildFragmentManager().beginTransaction().add(layoutId, frg, TAG)
            .addToBackStack(TAG)
            .commit();
    }

    public void popFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.popBackStack(fragment.getClass().getSimpleName(),
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}
