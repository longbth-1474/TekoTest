package longhoang.test.teko.screen.fragment.screen_detail;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

import longhoang.test.teko.R;
import longhoang.test.teko.data.model.api.Image;

public class SlideAdapter extends PagerAdapter {
    private List<Image> sliders;
    private ClickSliderListener mClickSliderListener;

    public SlideAdapter(List<Image> sliders, ClickSliderListener clickSliderListener) {
        this.sliders = sliders;
        this.mClickSliderListener = clickSliderListener;
    }

    @Override
    public int getCount() {
        return sliders != null ? sliders.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup view, int position, @NonNull Object object) {
        view.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, final int position) {
        PhotoView imageView = new PhotoView(view.getContext());
        imageView.setOnClickListener(v -> mClickSliderListener.onClickSlider(sliders, position));
        String image = sliders.get(position).getUrl();
        Glide.with(view.getContext()).load(image).placeholder(R.drawable.default_image).into(imageView);
        view.addView(imageView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return imageView;
    }

    public interface ClickSliderListener {
        void onClickSlider(List<Image> sliders, int position);
    }

}
