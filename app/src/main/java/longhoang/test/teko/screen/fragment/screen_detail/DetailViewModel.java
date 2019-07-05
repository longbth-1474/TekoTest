package longhoang.test.teko.screen.fragment.screen_detail;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import longhoang.test.teko.R;
import longhoang.test.teko.TekoTestApp;
import longhoang.test.teko.core.BaseViewModel;
import longhoang.test.teko.data.model.api.detail.ProductDetail;
import longhoang.test.teko.data.model.api.suggest_item.ItemSuggest;

public class DetailViewModel extends BaseViewModel {

    public MutableLiveData<String> numberItemInCart = new MutableLiveData<>();
    public MutableLiveData<String> totalPrice = new MutableLiveData<>();
    MutableLiveData<ProductDetail> productDetailMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<ItemSuggest>> suggestList = new MutableLiveData<>();
    private TekoTestApp tekoTestApp;

    @Inject
    public DetailViewModel(Application application) {
        tekoTestApp = (TekoTestApp) application;
        numberItemInCart.postValue("0");
        totalPrice.postValue("0 đ");
    }

    void fetchDetailProduct(String sku) {
        getCompositeDisposable().add(repository
                .getDetailProduct(sku)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(disposable -> showProgressDialog(true))
                .doAfterTerminate(() -> showProgressDialog(false))
                .subscribe(productDetail -> productDetailMutableLiveData.postValue(productDetail),
                        throwable -> showToast(tekoTestApp.getString(R.string.no_data_search)))
        );
    }

    void dummyDataSuggest() {
        List<ItemSuggest> itemSuggestList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemSuggest itemSuggest = new ItemSuggest(
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTecToEnNDc0wcqKL5R5G1WhhgMYQRu2k2arPbT6SLoidbWLHuB-Q",
                    "Màn hình LCD HKC 31.5\" M32A7Q",
                    "8790000", "10970000", "-20%");
            itemSuggestList.add(itemSuggest);
        }
        suggestList.postValue(itemSuggestList);
    }
}
