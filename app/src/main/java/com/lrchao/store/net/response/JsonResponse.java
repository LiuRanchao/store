package com.lrchao.store.net.response;

import com.google.gson.Gson;
import com.lrchao.store.model.JsonModel;

/**
 * Description: Json的response
 *
 * @author liuranchao
 * @date 15/12/22 下午2:47
 */
public class JsonResponse implements ResponseBase {

    /**
     * 需要转换的类型
     */
    private Class mClazz;

    public void setClazz(Class clazz) {
        mClazz = clazz;
    }

    @Override
    public Object translateResponse(Object response) {
        String responseResult = (String) response;
        Gson gson = new Gson();
        JsonModel model = (JsonModel) gson.fromJson(responseResult, mClazz);
        return model;
    }

}
