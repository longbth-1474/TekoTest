/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */
package longhoang.test.teko.core;

import javax.inject.Inject;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public abstract class BaseFragmentActivity<T extends ViewDataBinding, V extends BaseViewModel>
    extends BaseActivity<T, V> implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onBackPressed() {
        onBack(getSupportFragmentManager());
    }

    private void onBack(FragmentManager frgm) {
        for (Fragment frg : frgm.getFragments()) {
            if (frg.isVisible()) {
                if (frg.getChildFragmentManager().getFragments().size() > 0) {
                    onBack(frg.getChildFragmentManager());
                    return;
                } else {
                    if (frg.getChildFragmentManager().getBackStackEntryCount() > 0) {
                        frg.getChildFragmentManager().popBackStackImmediate();
                        return;
                    } else {
                        if (frgm.getBackStackEntryCount() > 1) {
                            frgm.popBackStack();
                            return;
                        } else {
                            onBack();
                            return;
                        }
                    }
                }
            }
        }
        onBack();
    }
    public void onBack(){
        super.onBackPressed();
    }
}

