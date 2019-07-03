package longhoang.test.teko.screen.fragment.screen_detail;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import longhoang.test.teko.R;
import longhoang.test.teko.core.BaseFragment;
import longhoang.test.teko.databinding.FragmentDetailProductBinding;
import longhoang.test.teko.utils.AppConstants;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailProductFragment extends BaseFragment<FragmentDetailProductBinding, DetailViewModel> {

    private String sku;


    public static DetailProductFragment newInstance(String sku) {
        Bundle args = new Bundle();
        args.putString(AppConstants.SKU, sku);
        DetailProductFragment fragment = new DetailProductFragment();
        fragment.setArguments(args);
        return fragment;
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
    }

    private void initData() {

    }
}
