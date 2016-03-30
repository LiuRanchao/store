package com.lrchao.store.net.response;

import com.google.gson.Gson;
import com.lrchao.store.model.BaseModel;
import com.lrchao.store.model.JsonModel;

/**
 * Description: Json的response
 * 有解析失败的可能，因此也要返回失败的
 * @author liuranchao
 * @date 15/12/22 下午2:47
 */
public class JsonResponseParser implements ResponseParser {

    /**
     * 需要转换的类型
     */
    private Class mClazz;

    public JsonResponseParser(Class clazz) {
        mClazz = clazz;
    }

    @Override
    public Object parse(String responseStr) {
        Gson gson = new Gson();
        BaseModel model = (BaseModel) gson.fromJson(responseStr, mClazz);
        return model;
    }

}
