package com.lrchao.store.util;

import android.content.SharedPreferences;

import com.lrchao.store.App;


/**
 * Description: SharedPreferences 工具类
 *
 * @author liuranchao
 * @date 16/1/12 上午11:25
 */
public class PreferencesUtils {

    private static final String PREFS_NAME = "DefaultPrefsFile";

    private static PreferencesUtils sInstance;

    private SharedPreferences mSettings;

    private SharedPreferences.Editor mEditor;

    private PreferencesUtils(){
        mSettings = App.get().getSharedPreferences(PREFS_NAME, App.get().MODE_PRIVATE);
        mEditor = mSettings.edit();
    }

    public static PreferencesUtils get(){
        synchronized (PreferencesUtils.class) {
            if (sInstance == null) {
                sInstance = new PreferencesUtils();
            }
        }
        return sInstance;
    }


    public void putString(String key, String value) {
        mEditor.putString(key, value);
        commit();
    }

    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        commit();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mSettings.getBoolean(key, defaultValue);
    }

    public void putInt(String key, int value) {
        mEditor.putInt(key, value);
        commit();
    }

    public void putLong(String key, long value) {
        mEditor.putLong(key, value);
        commit();
    }

    public long getLong(String key, long defaultValue) {
        return mSettings.getLong(key, defaultValue);
    }



    private void commit(){
        mEditor.commit();
    }

}
