package longhoang.test.teko.data;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import longhoang.test.teko.data.local.db.TekoDBHelper;
import longhoang.test.teko.data.model.api.ProductSearch;
import longhoang.test.teko.data.model.api.detail.ProductDetail;
import longhoang.test.teko.data.remote.TekoApiHelper;
import longhoang.test.teko.utils.ConfigManager;

@Singleton
public class TekoRepositoryImpl implements TekoRepository {
    private final Gson mGson;
    private final ConfigManager mConfig;
    private TekoDBHelper mDbHelper;
    private Context mContext;
    private TekoApiHelper mApiHelper;

    @Inject
    public TekoRepositoryImpl(Context context, TekoDBHelper dbHelper, TekoApiHelper apiHelper,
                              Gson gson, ConfigManager config) {
        mContext = context;
        mDbHelper = dbHelper;
        mApiHelper = apiHelper;
        mGson = gson;
        mConfig = config;
    }

    @Override
    public Single<ProductSearch> getSearchProduct(String channel, String visitorId, String q, String terminal) {
        return mApiHelper.getSearchProduct(channel, visitorId, q, terminal);
    }

    @Override
    public Single<ProductDetail> getDetailProduct(String sku) {
        return mApiHelper.getDetailProduct(sku);
    }
}
