package com.lrchao.store.net.response;

/**
 * Description: 请求响应回调接口
 *
 * @author liuranchao
 * @date 16/1/6 下午4:00
 */
public interface OnResponseListener {

    /**
     * 请求成功回调
     * @param object 对象
     */
    void onResponseSuccess(Object object);

    /**
     * 请求失败
     * @param errorCode http response code
     * @param message http response message
     */
    void onResponseError(int errorCode, String message);
}
