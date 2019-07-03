package longhoang.test.teko.data.remote;

import io.reactivex.Single;
import longhoang.test.teko.data.model.api.ProductSearch;

public interface TekoApiHelper {
    Single<ProductSearch> getSearchProduct(String channel, String visitorId, String q, String terminal);
    Single<ProductDetail> getSearchProduct(String channel, String visitorId, String q, String terminal);
}
