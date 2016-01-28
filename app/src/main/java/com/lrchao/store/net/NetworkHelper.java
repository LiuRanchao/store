package com.lrchao.store.net;


import com.lrchao.store.net.response.OnResponseListener;
import com.lrchao.store.util.LogUtils;

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

    /**
     * Response
     */
    private OnResponseListener mOnResponseListener;

    /**
     * 请求队列
     */
    //private RequestQueue mRequestQueue;

    private OkHttpClient mClient;

    public void setOnResponseListener(OnResponseListener onResponseListener) {
        mOnResponseListener = onResponseListener;
    }

    /**
     * 构造函数
     */
    public NetworkHelper() {
        mClient = new OkHttpClient();
        //mRequestQueue = Volley.newRequestQueue(App.get());
    }

    /**
     * get方法
     */
    public void get(final String url) {

        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = mClient.newCall(request).execute();
            response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        VolleyGetRequest stringRequest = new VolleyGetRequest(Request.Method.GET, url,
//                new Response.Listener() {
//                    @Override
//                    public void onResponse(Object response) {
//                        LogUtils.JSON(String.valueOf(response));
//                    }
//
//
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                onResponseError(error.networkResponse.statusCode, error.getMessage());
//            }
//        });
//        mRequestQueue.add(stringRequest);
    }

    /**
     * post方法
     */
    public void postString(final String url, final Map<String, String> params) {
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        onResponseSuccess(response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                onResponseError(error.networkResponse.statusCode, error.getMessage());
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() {
//                return params;
//            }
//        };
//        mRequestQueue.add(stringRequest);
    }

    private void onResponseSuccess(Object object) {
        LogUtils.JSON(String.valueOf(object));

        if (mOnResponseListener != null) {
            mOnResponseListener.onResponseSuccess(object);
        }
    }

    private void onResponseError(int code, String message) {
        LogUtils.E("onResponseError=code=" + code + " message=" + message);
        if (mOnResponseListener != null) {
            mOnResponseListener.onResponseError(code, message);
        }
    }


}
