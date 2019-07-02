package longhoang.test.teko.di.builder;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import longhoang.test.teko.MainActivity;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {FragmentBuilder.class})
    abstract MainActivity bindMainActivity();
}
