package longhoang.test.teko.data;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import longhoang.test.teko.data.local.db.TekoDBHelper;
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
}