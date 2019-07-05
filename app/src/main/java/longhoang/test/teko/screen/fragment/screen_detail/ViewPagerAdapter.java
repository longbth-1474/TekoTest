package longhoang.test.teko.screen.fragment.screen_detail;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import longhoang.test.teko.data.model.api.detail.ProductDetail;
import longhoang.test.teko.screen.fragment.screen_detail.screen_info.ComparePriceFragment;
import longhoang.test.teko.screen.fragment.screen_detail.screen_info.DescFragment;
import longhoang.test.teko.screen.fragment.screen_detail.screen_info.InfoFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ProductDetail productDetail;

    ViewPagerAdapter(FragmentManager fm, ProductDetail productDetail) {
        super(fm);
        this.productDetail = productDetail;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = DescFragment.newInstance(productDetail.getResult().getProduct().getSeoInfo());
        } else if (position == 1) {
            fragment = InfoFragment.newInstance(productDetail.getResult().getProduct().getAttributeGroups());
        } else if (position == 2) {
            fragment = ComparePriceFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Mô tả sản phẩm";
        } else if (position == 1) {
            title = "Thông số kỹ thuật";
        } else if (position == 2) {
            title = "So sánh giá";
        }
        return title;
    }
}