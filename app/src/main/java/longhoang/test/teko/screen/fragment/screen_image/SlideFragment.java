package longhoang.test.teko.screen.fragment.screen_image;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import longhoang.test.teko.R;
import longhoang.test.teko.core.BaseFragment;
import longhoang.test.teko.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.test.teko.data.model.api.Image;
import longhoang.test.teko.databinding.FragmentSlideBinding;
import longhoang.test.teko.databinding.ItemImageBinding;
import longhoang.test.teko.screen.fragment.screen_detail.SlideAdapter;

public class SlideFragment extends BaseFragment<FragmentSlideBinding, SlideViewModel>
        implements SlideAdapter.ClickSliderListener, ViewPager.OnPageChangeListener, SlideListener {

    private static final String BUNDLE_STRING_IMAGE = "BUNDLE_STRING_IMAGE";
    private static final String BUNDLE_INT_POSITION = "BUNDLE_INT_POSITION";
    private int position;
    private List<Image> mListImage;
    private SingleTypeAdapter<Image> adapter;
    private int rowIndex;

    public static SlideFragment newInstance(List<Image> sliders, int position) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(BUNDLE_STRING_IMAGE, (ArrayList<Image>) sliders);
        args.putInt(BUNDLE_INT_POSITION, position);
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_slide;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initListener();
        initRecyclerView();
        initSlide();
    }

    private void initListener() {
        getViewDataBinding().setListener(this);
        getViewDataBinding().viewpager.setOnPageChangeListener(this);
    }

    private void initRecyclerView() {
        adapter = new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_image);
        adapter.set(mListImage);
        getViewDataBinding().recyclerImage.setAdapter(adapter);
        adapter.setDecorator((holder, position, viewType) -> {
            ItemImageBinding binding = (ItemImageBinding) holder.getBinding();
            binding.frameShow.setOnClickListener(v -> {
                rowIndex = position;
                getViewDataBinding().viewpager.setCurrentItem(position);
                adapter.notifyDataSetChanged();
            });
            binding.frame.setBackgroundResource(rowIndex == position ?
                    R.drawable.custom_image : R.drawable.custom_image_unselected);
        });
    }

    private void initSlide() {
        SlideAdapter slideAdapter = new SlideAdapter(mListImage, this);
        getViewDataBinding().viewpager.setAdapter(slideAdapter);
        getViewDataBinding().viewpager.setCurrentItem(position);
    }

    private void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        mListImage = bundle.getParcelableArrayList(BUNDLE_STRING_IMAGE);
        position = bundle.getInt(BUNDLE_INT_POSITION);
        rowIndex = position;
    }

    @Override
    public void onClickSlider(List<Image> sliders, int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        rowIndex = position;
        adapter.notifyDataSetChanged();
        getViewDataBinding().recyclerImage.scrollToPosition(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClickBack() {
        popFragment(this);
    }
}
