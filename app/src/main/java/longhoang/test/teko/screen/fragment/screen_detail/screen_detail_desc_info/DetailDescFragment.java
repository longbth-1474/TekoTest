package longhoang.test.teko.screen.fragment.screen_detail.screen_detail_desc_info;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import longhoang.test.teko.R;

public class DetailDescFragment extends Fragment {


    private static final String DETAIL_DESC = "DETAIL_DESC";
    private WebView webview;
    private String decs;
    private ImageView imageBack;

    public static DetailDescFragment newInstance(String detail) {
        Bundle args = new Bundle();
        args.putString(DETAIL_DESC, detail);
        DetailDescFragment fragment = new DetailDescFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_desc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webview = view.findViewById(R.id.webview_info);
        imageBack = view.findViewById(R.id.ic_back);
        getData();
        initWebView();
        initListener();
    }

    private void initListener() {
        imageBack.setOnClickListener(v -> {
            if (getFragmentManager() == null) return;
            getFragmentManager().popBackStack();
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadDataWithBaseURL("", decs,
                "text/html", "UTF-8", "");
    }

    private void getData() {
        if (getArguments() == null) return;
        decs = getArguments().getString(DETAIL_DESC);
    }
}
