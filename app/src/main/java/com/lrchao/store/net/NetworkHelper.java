package com.lrchao.store.net;


import com.lrchao.store.exception.InitializationException;
import com.lrchao.store.net.resquest.PostRequest;
import com.lrchao.store.net.resquest.RequestBase;
import com.lrchao.store.util.LogUtils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description: 网络层的帮助类
 * 只负责调用volley
 *
 * @author liuranchao
 * @date 15/11/23 上午9:43
 */
public class NetworkHelper {

    private static NetworkHelper sInstance;

    /**
     *
     */
    private OkHttpClient mOkHttpClient;

    private NetworkHelper() {
        mOkHttpClient = new OkHttpClient();
    }

    public static NetworkHelper getInstance() {
        synchronized (NetworkHelper.class) {
            if (sInstance == null) {
                sInstance = new NetworkHelper();
            }
        }
        return sInstance;
    }

    //================================================
    // 实际调用OKHttp库
    //================================================

    /**
     * get方法
     */
    public void realCall(RequestBase requestBase, ResponseStatus responseStatus) {

        if (requestBase == null || responseStatus == null) {
            throw new InitializationException("RequestBase or responseStatus must be not null");
        }

        try {
            Request.Builder builder = new Request.Builder();
            // 设置url
            builder.url(requestBase.getRealUrl());
            // 设置body
            if (requestBase instanceof PostRequest) {
                PostRequest postRequest = (PostRequest) requestBase;
                builder.post(postRequest.getRequestBody());
            }

            Request request = builder.build();

            Response response = mOkHttpClient.newCall(request).execute();

            responseStatus.onResponseSuccess(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
