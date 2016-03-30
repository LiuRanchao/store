package com.lrchao.store.net;

/**
 * Description: 请求的过程
 *
 * @author liuranchao
 * @date 16/1/31 下午1:43
 */
public interface RequestProcess {

    /**
     * 请求开始
     */
    void onRequestBegin();

    /**
     * 请求结束
     */
    void onRequestEnd();
}
