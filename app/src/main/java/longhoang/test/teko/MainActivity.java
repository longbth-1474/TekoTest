package longhoang.test.teko;

import longhoang.test.teko.core.BaseFragmentActivity;
import longhoang.test.teko.databinding.ActivityMainBinding;

public class MainActivity extends BaseFragmentActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
