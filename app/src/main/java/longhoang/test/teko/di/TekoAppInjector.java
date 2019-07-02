package longhoang.test.teko.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;
import longhoang.test.teko.TekoTestApp;
import longhoang.test.teko.di.component.DaggerAppComponent;

public class TekoAppInjector {
    private TekoAppInjector() {
    }

    public static void init(TekoTestApp app) {
        DaggerAppComponent.builder().application(app)
            .build().inject(app);
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                handleActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }

    private static void handleActivity(Activity activity) {
        if (activity instanceof Injectable) {
            AndroidInjection.inject(activity);
        }
        if (activity instanceof HasSupportFragmentInjector) {
            ((FragmentActivity) activity).getSupportFragmentManager()
                .registerFragmentLifecycleCallbacks(
                    new FragmentManager.FragmentLifecycleCallbacks() {
                        @Override
                        public void onFragmentCreated(FragmentManager fm, Fragment f,
                                                      Bundle savedInstanceState) {
                            if (f instanceof Injectable) {
                                AndroidSupportInjection.inject(f);
                            }
                        }
                    }
                    , true
                );
        }
    }
}

