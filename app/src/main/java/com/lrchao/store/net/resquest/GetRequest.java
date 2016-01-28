package com.lrchao.store.net.resquest;


import com.lrchao.store.util.MapUtils;

import java.util.Map;

/**
 * Description: Get请求的基类
 *
 * @author liuranchao
 * @date 16/1/6 下午4:46
 */
public class GetRequest extends RequestBase {

    @Override
    public String getRealUrl() {
        return getUrl() + MapUtils.getUrlParams(getParams());
    }

    @Override
    public Map<String, String> getRealParams() {
        return null;
    }
}
