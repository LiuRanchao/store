package com.lrchao.store;

import android.app.Application;

import com.lrchao.store.manager.SessionManager;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;

/**
 * Description: Application
 *
 * @author liuranchao
 * @date 15/11/7 下午10:01
 */
public class App extends Application {

    private static final String TAG = "DouBanReadPro";

    private static App sMyApplication;

    public static App get() {
        return sMyApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApplication = this;
        initData();

    }

    /**
     * 初始化控件
     */
    private void initData() {
        Logger.init(TAG).methodOffset(1).methodCount(1);
        ButterKnife.setDebug(BuildConfig.DEBUG);
        SessionManager.get().init();

    }

}
