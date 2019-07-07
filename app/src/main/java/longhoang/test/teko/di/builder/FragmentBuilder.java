package longhoang.test.teko.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import longhoang.test.teko.screen.fragment.screen_detail.DetailProductFragment;
import longhoang.test.teko.screen.fragment.screen_detail.screen_info.DescFragment;
import longhoang.test.teko.screen.fragment.screen_detail.screen_info.InfoFragment;
import longhoang.test.teko.screen.fragment.screen_image.SlideFragment;
import longhoang.test.teko.screen.fragment.screen_search.SearchFragment;

@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract SearchFragment provideSearchFragment();
    @ContributesAndroidInjector
    abstract DetailProductFragment provideDetailProductFragment();
    @ContributesAndroidInjector
    abstract SlideFragment provideSlideFragment();
    @ContributesAndroidInjector
    abstract DescFragment provideDescFragment();
    @ContributesAndroidInjector
    abstract InfoFragment provideInfoFragment();
}
