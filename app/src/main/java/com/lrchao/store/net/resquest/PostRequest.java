package com.lrchao.store.net.resquest;

import com.google.gson.Gson;
import com.lrchao.store.util.LogUtils;
import com.lrchao.store.util.MapUtils;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Description: Post的请求
 *
 * @author liuranchao
 * @date 15/12/22 下午2:44
 */
public class PostRequest extends RequestBase {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    @Override
    public String getRealUrl() {
        return getUrl();
    }

    @Override
    public Map<String, String> getRealParams() {
        return MapUtils.convert(getParams());
    }

    public RequestBody getRequestBody() {

        Gson gson = new Gson();
        String jsonBody = gson.toJson(getRealParams());
        LogUtils.JSON("json body=" + jsonBody);
        return RequestBody.create(JSON, jsonBody);
    }
}
