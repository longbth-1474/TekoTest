package longhoang.test.teko.screen.fragment.screen_search;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import longhoang.test.teko.R;
import longhoang.test.teko.TekoTestApp;
import longhoang.test.teko.core.BaseViewModel;
import longhoang.test.teko.data.model.api.Product;

public class SearchViewModel extends BaseViewModel {

    MutableLiveData<List<Product>> mProductLiveData = new MutableLiveData<>();
    private TekoTestApp tekoTestApp;
    public MutableLiveData<Boolean> noData = new MutableLiveData<>();

    @Inject
    public SearchViewModel(Application application) {
        tekoTestApp = (TekoTestApp) application;
        noData.postValue(true);
    }

    void fetchProductList(String query) {
        getCompositeDisposable().add(repository
                .getSearchProduct("pv_online", "", "", "cp01")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(disposable -> showProgressDialog(true))
                .doAfterTerminate(() -> showProgressDialog(false))
                .subscribe(productSearch -> {
                            if (productSearch.getResult().getProducts().size() > 0) {
                                noData.postValue(false);
                                mProductLiveData.postValue(productSearch.getResult().getProducts());
                            }
                        },
                        throwable -> showToast(tekoTestApp.getString(R.string.no_data_search)))
        );
    }
}
