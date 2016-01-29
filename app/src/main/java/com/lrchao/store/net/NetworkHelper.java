package com.lrchao.store.net;


import com.lrchao.store.net.response.ResponseBase;
import com.lrchao.store.net.resquest.RequestBase;

import java.io.IOException;
import java.util.Map;

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

    private RequestBase mRequestBase;

    /**
     * @param requestBase
     * @param responseBase
     */
    public void call(RequestBase requestBase, ResponseBase responseBase) {

    }


    //================================================
    // Get Method
    //================================================

    /**
     * get方法
     */
    public void get(RequestBase requestBase, ResponseBase responseBase) {

        try {

            Request.Builder builder = new Request.Builder();
            builder.url(requestBase.getRealUrl());

            Request request = builder.build();

            Response response = mOkHttpClient.newCall(request).execute();

            String responseStr = response.body().string();

            responseBase.translateResponse(responseStr);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //================================================
    // Post Method
    //================================================

    /**
     * post方法
     */
    public void postString(final String url, final Map<String, String> params) {

    }

//    private void onResponseSuccess(Object object) {
//        LogUtils.JSON(String.valueOf(object));
//
//        if (mOnResponseListener != null) {
//            mOnResponseListener.onResponseSuccess(object);
//        }
//    }

//    private void onResponseError(int code, String message) {
//        LogUtils.E("onResponseError=code=" + code + " message=" + message);
//        if (mOnResponseListener != null) {
//            mOnResponseListener.onResponseError(code, message);
//        }
//    }


}
