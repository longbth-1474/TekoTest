package longhoang.test.teko.data.remote;

import io.reactivex.Single;
import longhoang.test.teko.data.model.api.ProductSearch;
import longhoang.test.teko.data.model.api.detail.ProductDetail;

public interface TekoApiHelper {
    Single<ProductSearch> getSearchProduct(String channel, String visitorId, String q, String terminal);

    Single<ProductDetail> getDetailProduct(String sku);
}
