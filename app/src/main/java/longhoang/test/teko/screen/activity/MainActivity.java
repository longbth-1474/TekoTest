package longhoang.test.teko.screen.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import longhoang.test.teko.R;
import longhoang.test.teko.core.BaseFragmentActivity;
import longhoang.test.teko.databinding.ActivityMainBinding;
import longhoang.test.teko.screen.fragment.screen_search.SearchFragment;

public class MainActivity extends BaseFragmentActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeFragment(SearchFragment.newInstance());
    }

    public void addFragment(Fragment frg) {
        super.addFragment(frg, R.id.main_container);
    }

    public void changeFragment(Fragment fragment) {
        super.changeFragment(R.id.main_container, fragment);
    }
}
