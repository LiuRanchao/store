package com.lrchao.store.request_handler;

import com.lrchao.store.exception.InitializationException;
import com.lrchao.store.net.NetworkHelper;
import com.lrchao.store.net.ResponseStatus;
import com.lrchao.store.net.response.JsonResponseParser;
import com.lrchao.store.net.response.ResponseParser;
import com.lrchao.store.net.resquest.GetRequest;
import com.lrchao.store.net.resquest.PostRequest;
import com.lrchao.store.net.resquest.RequestBase;
import com.lrchao.store.net.resquest.RequestMethod;
import com.lrchao.store.util.LogUtils;

/**
 * Description: 请求执行者的基类
 *
 * @author liuranchao
 * @date 16/1/29 下午3:32
 */
public abstract class RequestHandler implements ResponseStatus {

    /**
     *
     */
    private ResponseParser mResponseBase;

    /**
     * 设置请求的方式
     */
    protected abstract int bindRequestMethod();

    /**
     * 设置请求的URL
     */
    protected abstract String bindRequestURL();

    /**
     * 执行操作
     */
    public void execute() {

        bindRequest();
        bindResponse();
        NetworkHelper.getInstance().realCall(bindRequest(), this);
    }

    /**
     * 绑定请求
     */
    private RequestBase bindRequest() {

        RequestBase requestBase;

        switch (bindRequestMethod()) {
            case RequestMethod.GET:
                requestBase = new GetRequest();
                break;
            case RequestMethod.POST:
                requestBase = new PostRequest();
                break;
            default:
                throw new InitializationException("request method not set");
        }

        requestBase.setUrl(bindRequestURL());
        return requestBase;
    }



    /**
     * 绑定response
     */
    private void bindResponse() {

        if (getJsonClass() != null) {
            mResponseBase = new JsonResponseParser(getJsonClass());
        }
    }

    /**
     *
     * @return JSON转换成的对象
     */
    protected Class getJsonClass() {
        return null;
    }

    /**
     * 返回给子类解析后的数据
     * @param obj Object
     */
    protected void onSuccess(Object obj) {

    }


    @Override
    public void onResponseSuccess(String responseStr) {
        LogUtils.E("onResponseSuccess=" + responseStr);
        if (mResponseBase != null) {
            onSuccess(mResponseBase.parse(responseStr));
        }
    }

    @Override
    public void onResponseError(int errorCode, String message) {
        LogUtils.E("onResponseError=" + errorCode + message);
    }
}
