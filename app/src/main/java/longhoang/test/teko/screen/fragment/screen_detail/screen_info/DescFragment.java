package longhoang.test.teko.screen.fragment.screen_detail.screen_info;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import longhoang.test.teko.R;
import longhoang.test.teko.core.BaseFragment;
import longhoang.test.teko.data.model.api.detail.SeoInfo;
import longhoang.test.teko.databinding.FragmentDescBinding;
import longhoang.test.teko.screen.activity.MainActivity;
import longhoang.test.teko.screen.fragment.screen_detail.screen_detail_desc_info.DetailDescFragment;

public class DescFragment extends BaseFragment<FragmentDescBinding, DescViewModel> {

    private static final String SEO_INFO = "SEO_INFO";
    private SeoInfo seoInfo;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    public static DescFragment newInstance(SeoInfo seoInfo) {
        Bundle args = new Bundle();
        args.putParcelable(SEO_INFO, seoInfo);
        DescFragment fragment = new DescFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_desc;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        getViewDataBinding().setSeoInfo(seoInfo);
        initView();
        initListener();
    }

    private void initListener() {
        getViewDataBinding().showMore.setOnClickListener(v ->
                mainActivity.addFragment(DetailDescFragment.newInstance(seoInfo.getDescription())));
    }

    private void initView() {
        String html = seoInfo.getShortDescription();
        setTextDesc(html);
    }

    private void setTextDesc(String textDesc) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getViewDataBinding().textView.setText(Html.fromHtml(textDesc, Html.FROM_HTML_MODE_COMPACT));
        } else {
            getViewDataBinding().textView.setText(Html.fromHtml(textDesc));
        }
    }

    private void getData() {
        if (getArguments() == null) return;
        seoInfo = getArguments().getParcelable(SEO_INFO);
    }
}
