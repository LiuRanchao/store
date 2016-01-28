package com.lrchao.store.data_provider;


import com.lrchao.store.net.NetworkHelper;
import com.lrchao.store.net.response.JsonResponse;
import com.lrchao.store.net.response.OnResponseListener;
import com.lrchao.store.net.response.ResponseBase;
import com.lrchao.store.net.response.ResponseType;
import com.lrchao.store.net.resquest.GetRequest;
import com.lrchao.store.net.resquest.PostRequest;
import com.lrchao.store.net.resquest.RequestBase;
import com.lrchao.store.net.resquest.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 网络数据提供者
 *
 * @author liuranchao
 * @date 15/11/23 上午10:46
 */
public abstract class NetworkDataProvider implements BaseDataProvider, OnResponseListener {

    /**
     * VolleyHelper实际发请求对象
     */
    private NetworkHelper mVolleyHelper;

    /**
     * 请求对象
     */
    public RequestBase mRequest;

    /**
     * 参数
     */
    private Map<String, Object> mParams;

    /**
     * 响应对象
     */
    protected ResponseBase mResponse;

    /**
     * 设置URL
     */
    protected abstract String initUrl();

    /**
     * 设置请求方式
     *
     * @see RequestMethod
     */
    protected abstract int getRequestMethod();

    /**
     * 设置参数
     *
     * @param params 参数
     */
    protected abstract void bindParams(Map<String, Object> params);

    /**
     * 返回的回调
     *
     * @param object 返回的数据
     *               如果是JSON格式则返回JSONObject
     *               如果是字符串下则返回string
     */
    protected abstract void onResponse(Object object);

    /**
     * 返回response的类型，默认JSON
     */
    protected int getResponseType() {
        return ResponseType.JSON;
    }

    protected Class getJSONResponseClass() {
        return Object.class;
    }

    /**
     * 设置
     */
    private void setJsonResponseClass() {
        JsonResponse jsonResponse = (JsonResponse) mResponse;
        jsonResponse.setClazz(getJSONResponseClass());
    }


    public NetworkDataProvider() {
        mVolleyHelper = new NetworkHelper();
        mVolleyHelper.setOnResponseListener(this);

        // 初始化request
        initRequest(getRequestMethod());
        initResponse();
    }

    /**
     * 初始化response
     */
    private void initResponse() {
        switch (getResponseType()) {
            case ResponseType.JSON:
            default:
                mResponse = new JsonResponse();
                setJsonResponseClass();
                break;
        }
    }


    /**
     * 设置请求的数据
     */
    private void bindRequest() {
        mParams = new HashMap<>();
        mRequest.setUrl(initUrl());
        bindParams(mParams);
        mRequest.setParams(mParams);
    }

    @Override
    public void load() {

        bindRequest();

        String realUrl = mRequest.getRealUrl();

        if (getRequestMethod() == RequestMethod.POST) {
            mVolleyHelper.postString(realUrl, mRequest.getRealParams());
        } else {
            mVolleyHelper.get(realUrl);
        }
    }


    /**
     * 初始化request对象
     */
    protected void initRequest(int requestMethod) {
        switch (requestMethod) {
            case RequestMethod.POST:
                mRequest = new PostRequest();
                break;
            case RequestMethod.GET:
                mRequest = new GetRequest();
            default:
                break;
        }
    }


    @Override
    public void onResponseSuccess(Object object) {
        Object responseObj = mResponse.translateResponse(object);
        onResponse(responseObj);
    }

    @Override
    public void onResponseError(int errorCode, String message) {

    }
}
