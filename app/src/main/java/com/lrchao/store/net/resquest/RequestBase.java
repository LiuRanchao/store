package com.lrchao.store.net.resquest;

import java.util.Map;

/**
 * Description: 请求的基类
 *
 * @author liuranchao
 * @date 15/11/8 下午3:38
 */
public abstract class RequestBase {

    /**
     * 请求地址
     */
    private String mUrl;

    /**
     * 参数
     */
    private Map<String, Object> mParams;


    public void setUrl(String url) {
        mUrl = url;
    }

    public void setParams(Map<String, Object> params) {
        mParams = params;
    }

    public String getUrl() {
        return mUrl;
    }

    public Map<String, Object> getParams() {
        return mParams;
    }

    /**
     * 获取真正的url
     */
    public abstract String getRealUrl ();

    /**
     * 获取真正的参数
     */
    public abstract Map<String, String> getRealParams();
}
