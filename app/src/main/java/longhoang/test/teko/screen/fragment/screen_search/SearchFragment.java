package longhoang.test.teko.screen.fragment.screen_search;


import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;

import longhoang.test.teko.R;
import longhoang.test.teko.core.BaseFragment;
import longhoang.test.teko.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.test.teko.data.model.api.Product;
import longhoang.test.teko.databinding.FragmentSearchBinding;
import longhoang.test.teko.screen.activity.MainActivity;
import longhoang.test.teko.screen.fragment.screen_detail.DetailProductFragment;

public class SearchFragment extends BaseFragment<FragmentSearchBinding, SearchViewModel> implements SearchNavigator, TextWatcher {

    private SingleTypeAdapter<Product> adapter;
    private MainActivity mMainActivity;
    private static final int WAITING_TIME = 1000;
    private String mSearchKey;

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initListener();
        initObserver();
    }

    private void initListener() {
        getViewDataBinding().editSearch.addTextChangedListener(this);
        getViewDataBinding().editSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                initData();
                return true;
            }
            return false;
        });
    }

    private void initObserver() {
        getViewModel().mProductLiveData.observe(this, productList -> adapter.set(productList));
    }

    private void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_product);
        getViewDataBinding().recyclerViewProduct.setAdapter(adapter);
        adapter.setPresenter(this);
    }

    private void initData() {
        getViewModel().fetchProductList(mSearchKey);
    }

    @Override
    public void onClickProductListener(Product product) {
        mMainActivity.addFragment(DetailProductFragment.newInstance(product.getSku()));
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        mSearchKey = getViewDataBinding().editSearch.toString().trim();
        if (!mSearchKey.isEmpty()) {
//            getViewModel().showHistory.postValue(false);
            mCountDownTimer.start();
        } else {
//            getViewModel().showHistory.postValue(true);
        }
    }

    private CountDownTimer mCountDownTimer = new CountDownTimer(WAITING_TIME, WAITING_TIME) {
        public void onTick(long millisUntilFinished) {
        }

        public void onFinish() {
            hideKeyboard();
            initData();
        }
    };

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
