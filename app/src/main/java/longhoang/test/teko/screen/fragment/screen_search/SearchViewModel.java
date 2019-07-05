package longhoang.test.teko.screen.fragment.screen_search;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import longhoang.test.teko.core.BaseViewModel;
import longhoang.test.teko.data.model.api.Product;

public class SearchViewModel extends BaseViewModel {

    public MutableLiveData<List<Product>> mProductLiveData = new MutableLiveData<>();

    @Inject
    public SearchViewModel() {
    }

    public void fetchProductList(String query) {
        getCompositeDisposable().add(repository
                .getSearchProduct("pv_online", "", "", "cp01")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(disposable -> showProgressDialog(true))
                .doAfterTerminate(() -> showProgressDialog(false))
                .subscribe(productSearch -> {
                            if (productSearch.getResult().getProducts().size() > 0) {
                                mProductLiveData.postValue(productSearch.getResult().getProducts());
                            }
                        },
                        throwable -> showToast("Không có kết quả tìm kiếm"))
        );
    }
}
