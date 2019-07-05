package longhoang.test.teko.screen.fragment.screen_detail.screen_info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import longhoang.test.teko.R;

public class ComparePriceFragment extends Fragment {


    public static ComparePriceFragment newInstance() {
        Bundle args = new Bundle();
        ComparePriceFragment fragment = new ComparePriceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compare_price, container, false);
    }

}
