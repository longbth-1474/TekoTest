package longhoang.test.teko.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import longhoang.test.teko.R;
import longhoang.test.teko.data.TekoRepository;
import longhoang.test.teko.data.TekoRepositoryImpl;
import longhoang.test.teko.data.local.db.TekoDBHelper;
import longhoang.test.teko.data.local.db.TekoDBHelperImpl;
import longhoang.test.teko.data.local.db.TekoDatabase;
import longhoang.test.teko.data.remote.TekoApiHelper;
import longhoang.test.teko.data.remote.TekoApiHelperImpl;
import longhoang.test.teko.di.ApiInfo;
import longhoang.test.teko.di.DatabaseInfo;
import longhoang.test.teko.di.builder.ViewModelModule;
import longhoang.test.teko.utils.AppConstants;
import longhoang.test.teko.utils.ConfigManager;
import longhoang.test.teko.utils.rx.AppSchedulerProvider;
import longhoang.test.teko.utils.rx.SchedulerProvider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
@Module(includes = {ViewModelModule.class})
public class AppModule {
    @Provides
    @Singleton
    TekoApiHelper provideBAnkApiHelper(TekoApiHelperImpl apiHelper) {
        return apiHelper;
    }

    @Provides
    @Singleton
    TekoDBHelper provideBAnkDBHelper(TekoDBHelperImpl dbHelper) {
        return dbHelper;
    }

    @Provides
    @Singleton
    TekoRepository provideBAnkRepository(TekoRepositoryImpl repository) {
        return repository;
    }

    //API KEY
    @Provides
    @ApiInfo
    String provideApiKey() {
        return "";
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    TekoDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, TekoDatabase.class, dbName)
            .fallbackToDestructiveMigration()
            .build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    ConfigManager provideConfigManager(Context ctx) {
        return new ConfigManager(ctx);
    }
}
