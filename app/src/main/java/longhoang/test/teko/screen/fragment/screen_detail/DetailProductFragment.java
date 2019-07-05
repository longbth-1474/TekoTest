package longhoang.test.teko.screen.fragment.screen_detail;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.List;

import longhoang.test.teko.R;
import longhoang.test.teko.core.BaseFragment;
import longhoang.test.teko.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.test.teko.data.model.api.Image;
import longhoang.test.teko.data.model.api.detail.ProductDetail;
import longhoang.test.teko.data.model.api.suggest_item.ItemSuggest;
import longhoang.test.teko.databinding.FragmentDetailProductBinding;
import longhoang.test.teko.screen.activity.MainActivity;
import longhoang.test.teko.screen.fragment.screen_image.SlideFragment;
import longhoang.test.teko.utils.AppConstants;
import longhoang.test.teko.utils.CommonUtils;

public class DetailProductFragment extends BaseFragment<FragmentDetailProductBinding, DetailViewModel>
        implements DetailListener, SlideAdapter.ClickSliderListener {

    private String sku;
    private MainActivity mainActivity;
    private SingleTypeAdapter<ItemSuggest> suggestAdapter;

    public static DetailProductFragment newInstance(String sku) {
        Bundle args = new Bundle();
        args.putString(AppConstants.SKU, sku);
        DetailProductFragment fragment = new DetailProductFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail_product;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null) return;
        sku = getArguments().getString(AppConstants.SKU);
        initData();
        initListener();
        initObserver();
        initSuggestView();
    }

    private void initSuggestView() {
        suggestAdapter = new SingleTypeAdapter<>(getContext(), R.layout.item_suggest);
        getViewDataBinding().recyclerItemSuggest.setAdapter(suggestAdapter);
    }

    private void initInfoView(ProductDetail productDetail) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), productDetail);
        getViewDataBinding().viewPagerInfo.setAdapter(viewPagerAdapter);
        getViewDataBinding().tabLayout.setupWithViewPager(getViewDataBinding().viewPagerInfo);
    }

    private void initSlideImage(List<Image> images) {
        SlideAdapter slideAdapter = new SlideAdapter(images, this);
        getViewDataBinding().viewpager.setAdapter(slideAdapter);
        getViewDataBinding().indicator.setViewPager(getViewDataBinding().viewpager);

    }

    private void initObserver() {
        getViewModel().productDetailMutableLiveData.observe(this,
                productDetail -> {
                    getViewDataBinding().setDetailProduct(productDetail);
                    initSlideImage(productDetail.getResult().getProduct().getImages());
                    initInfoView(productDetail);
                });
        getViewModel().suggestList.observe(this, itemSuggests
                -> suggestAdapter.set(itemSuggests));
    }

    private void initListener() {
        getViewDataBinding().setListener(this);
    }

    private void initData() {
        getViewModel().fetchDetailProduct(sku);
        getViewModel().dummyDataSuggest();
    }

    @Override
    public void addItemInCart(DetailViewModel detailViewModel) {
        if (getViewModel().numberItemInCart.getValue() == null) return;
        int number = Integer.parseInt(getViewModel().numberItemInCart.getValue()) + 1;
        getViewModel().numberItemInCart.postValue(String.valueOf(number));
        getViewModel().totalPrice.postValue(CommonUtils.convertPrice(number * 10000));

    }

    @Override
    public void deleteItemInCart(DetailViewModel detailViewModel) {
        if (getViewModel().numberItemInCart.getValue() == null) return;
        int number = Integer.parseInt(getViewModel().numberItemInCart.getValue());
        if (number > 0) {
            number--;
            getViewModel().numberItemInCart.postValue(String.valueOf(number));
            getViewModel().totalPrice.postValue(CommonUtils.convertPrice(number * 10000));
        }
    }

    @Override
    public void submitCart() {

    }

    @Override
    public void showCart() {

    }

    @Override
    public void onClickBack() {
        if (getFragmentManager() == null) return;
        getFragmentManager().popBackStack();
    }

    @Override
    public void onClickSlider(List<Image> sliders, int position) {
        mainActivity.addFragment(SlideFragment.newInstance(sliders, position));
    }
}
