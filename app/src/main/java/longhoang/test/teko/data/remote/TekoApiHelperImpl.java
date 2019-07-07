package longhoang.test.teko.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import longhoang.test.teko.data.model.api.ProductSearch;
import longhoang.test.teko.data.model.api.detail.ProductDetail;
import longhoang.test.teko.utils.AppConstants;

@Singleton
public class TekoApiHelperImpl implements TekoApiHelper {
    @Inject
    public TekoApiHelperImpl() {
    }

    @Override
    public Single<ProductSearch> getSearchProduct(String channel, String visitorId, String q, String terminal) {
        return Rx2AndroidNetworking.get(TekoApiEndPoint.ENDPOINT_TEKO_SEARCH)
                .addPathParameter(AppConstants.CHANNEL, channel)
                .addPathParameter(AppConstants.VISITOR_ID, visitorId)
                .addPathParameter(AppConstants.QUERY, q)
                .addPathParameter(AppConstants.TERMINAL, terminal)
                .build().getObjectSingle(ProductSearch.class);
    }

    @Override
    public Single<ProductDetail> getDetailProduct(String sku) {
        return Rx2AndroidNetworking.get(TekoApiEndPoint.ENDPOINT_TEKO_DETAIL)
                .addPathParameter(AppConstants.SKU, sku)
                .build().getObjectSingle(ProductDetail.class);
    }
}
