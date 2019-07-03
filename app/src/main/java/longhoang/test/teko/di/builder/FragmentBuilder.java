package longhoang.test.teko.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import longhoang.test.teko.screen.fragment.screen_detail.DetailProductFragment;
import longhoang.test.teko.screen.fragment.screen_search.SearchFragment;

@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract SearchFragment provideSearchFragment();
    @ContributesAndroidInjector
    abstract DetailProductFragment provideDetailProductFragment();
}
