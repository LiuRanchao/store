package com.lrchao.store.net.response;

/**
 * Description: 响应的基类
 *
 * @author liuranchao
 * @date 15/12/22 上午10:49
 */
public interface ResponseBase {

    /**
     * 将返回值转换成对应的数据
     * @param response  Object
     */
    Object translateResponse(Object response);

}
