package longhoang.test.teko.data.local.db;

import javax.inject.Inject;

public class TekoDBHelperImpl implements TekoDBHelper {
    private final TekoDatabase mAppDatabase;

    @Inject
    public TekoDBHelperImpl(TekoDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }
}
