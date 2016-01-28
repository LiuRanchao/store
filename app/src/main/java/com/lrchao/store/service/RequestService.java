package com.lrchao.store.service;

import android.app.IntentService;
import android.content.Intent;

import com.lrchao.store.App;
import com.lrchao.store.constants.BundleKey;


/**
 * Description: 发起网络请求的Service
 *
 * @author liuranchao
 * @date 16/1/26 上午11:21
 */
public class RequestService extends IntentService{


    public RequestService() {
        super("RequestService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {


    }

    /**
     * 获取启动service的intent
     *
     * @param action request action
     * @return Intent
     */
    public static Intent newStartIntent(int action) {
        Intent newIntent = new Intent(App.get(), RequestService.class);
        newIntent.putExtra(BundleKey.INTENT_EXTRA_REQUEST_ACTION, action);
        return newIntent;
    }
}
