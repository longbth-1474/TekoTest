package longhoang.test.teko.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import longhoang.test.teko.TekoTestApp;
import longhoang.test.teko.di.builder.ActivityBuilder;
import longhoang.test.teko.di.module.AppModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    void inject(TekoTestApp app);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application app);
        AppComponent build();
    }
}
