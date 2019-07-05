package longhoang.test.teko.core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import longhoang.test.teko.BR;
import longhoang.test.teko.R;
import longhoang.test.teko.di.Injectable;

public abstract class BaseDialogFragment<T extends ViewDataBinding, V extends BaseViewModel>
    extends DialogFragment implements Injectable {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private BaseActivity mActivity;
    private View mRootView;
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
        setHasOptionsMenu(false);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.colorPickerStyle);
    }

    @Override
    public void onStart() {
        super.onStart();
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
//
//    public void openActivityOnTokenExpire() {
//        if (mActivity != null) {
//            mActivity.openActivityOnTokenExpire();
//        }
//    }

    public interface Callback {
        void onFragmentAttached();
        void onFragmentDetached(String tag);
    }
}