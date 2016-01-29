package com.lrchao.store.request_handler;

import com.lrchao.store.exception.InitializationException;
import com.lrchao.store.net.NetworkHelper;
import com.lrchao.store.net.resquest.GetRequest;
import com.lrchao.store.net.resquest.PostRequest;
import com.lrchao.store.net.resquest.RequestBase;
import com.lrchao.store.net.resquest.RequestMethod;

import java.util.Map;

/**
 * Description: 请求执行者的基类
 *
 * @author liuranchao
 * @date 16/1/29 下午3:32
 */
public abstract class RequestHandler {

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
        NetworkHelper.getInstance().call(bindRequest(), null);
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
     *
     */
    private void bindResponse() {

    }









}
