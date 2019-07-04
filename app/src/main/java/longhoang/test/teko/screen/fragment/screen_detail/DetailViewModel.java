package longhoang.test.teko.screen.fragment.screen_detail;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import longhoang.test.teko.core.BaseViewModel;
import longhoang.test.teko.data.model.api.detail.ProductDetail;

public class DetailViewModel extends BaseViewModel {

    private static final String TAG = "detail_product";
    public MutableLiveData<String> numberItemInCart = new MutableLiveData<>();
    public MutableLiveData<String> totalPrice = new MutableLiveData<>();
    public MutableLiveData<ProductDetail> productDetailMutableLiveData = new MutableLiveData<>();

    @Inject
    public DetailViewModel() {
        numberItemInCart.postValue("0");
        totalPrice.postValue("0 vnd");
    }

    public void fetchDetailProduct(String sku) {
        getCompositeDisposable().add(repository
                .getDetailProduct(sku)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(disposable -> showProgressDialog(true))
                .doAfterTerminate(() -> showProgressDialog(false))
                .subscribe(productDetail -> {
                            productDetailMutableLiveData.postValue(productDetail);
                        },
                        throwable -> showToast("Không có kết quả tìm kiếm"))
        );
    }
}
