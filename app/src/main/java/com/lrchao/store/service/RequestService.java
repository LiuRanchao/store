package com.lrchao.store.service;

import android.app.IntentService;
import android.content.Intent;

import com.lrchao.store.App;
import com.lrchao.store.constants.BundleKey;
import com.lrchao.store.request_handler.RequestHandler;
import com.lrchao.store.request_handler.movie.MovieInTheatersRH;
import com.lrchao.store.util.LogUtils;

import java.util.logging.Logger;


/**
 * Description: 发起网络请求的Service
 *
 * @author liuranchao
 * @date 16/1/26 上午11:21
 */
public class RequestService extends IntentService{

    /**
     * Movie
     */
    public static final int ACTION_DOUBAN_MOVIE_IN_THEATERS = 1; // 豆瓣的movie正在上映的影片接口

    /**
     * RequestHandler
     */
    private RequestHandler mRequestHandler;

    public RequestService() {
        super("RequestService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        int action = intent.getIntExtra(BundleKey.INTENT_EXTRA_REQUEST_ACTION, 0);

        switch (action) {
            case ACTION_DOUBAN_MOVIE_IN_THEATERS:
                mRequestHandler = new MovieInTheatersRH();
                break;
            default:
                break;
        }


        LogUtils.D("action=" + action);

        if (mRequestHandler != null) {
            mRequestHandler.execute();
        }
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
