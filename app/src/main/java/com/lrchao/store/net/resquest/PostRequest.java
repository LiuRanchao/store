package com.lrchao.store.net.resquest;

import com.lrchao.store.util.MapUtils;

import java.util.Map;

/**
 * Description: Post的请求
 *
 * @author liuranchao
 * @date 15/12/22 下午2:44
 */
public class PostRequest extends RequestBase {

    @Override
    public String getRealUrl() {
        return getUrl();
    }

    @Override
    public Map<String, String> getRealParams() {
        return MapUtils.convert(getParams());
    }
}
