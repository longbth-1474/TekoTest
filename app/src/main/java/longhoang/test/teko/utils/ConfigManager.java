package longhoang.test.teko.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ConfigManager {
    Context activity;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private boolean autoCommit = true;

    public ConfigManager(Context activity) {
        this.autoCommit = true;
        this.activity = activity;
        pref = PreferenceManager.getDefaultSharedPreferences(activity);
        editor = pref.edit();
    }

    public ConfigManager(Activity activity, boolean autoCommit) {
        this.autoCommit = autoCommit;
        this.activity = activity;
        pref = PreferenceManager.getDefaultSharedPreferences(activity);
        editor = pref.edit();
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        if (autoCommit) {
            commit();
        }
    }

    public String getString(String key, String defaultValue) {
        return pref.getString(key, defaultValue);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        if (autoCommit) {
            commit();
        }
    }

    public int getInt(String key, int defaultValue) {
        return pref.getInt(key, defaultValue);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        if (autoCommit) {
            commit();
        }
    }

    public long getLong(String key, long defaultValue) {
        return pref.getLong(key, defaultValue);
    }

    public void commit() {
        editor.commit();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return pref.getBoolean(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        if (autoCommit) {
            commit();
        }
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }
}
