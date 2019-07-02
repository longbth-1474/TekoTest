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

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import longhoang.test.teko.data.TekoRepository;
import longhoang.test.teko.utils.rx.SchedulerProvider;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public abstract class BaseViewModel extends ViewModel {
    public MutableLiveData<String> toastMessages = new MutableLiveData();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData();
    public MutableLiveData<Boolean> showProgressDialog = new MutableLiveData();
    @Inject
    protected TekoRepository repository;

    @Inject
    protected SchedulerProvider schedulerProvider;
    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public void setIsLoading(boolean load) {
        isLoading.postValue(load);
    }

    protected void showToast(String messages) {
        toastMessages.setValue(messages);
    }

    protected void showProgressDialog(boolean isShow) {
        showProgressDialog.postValue(isShow);
    }
}
