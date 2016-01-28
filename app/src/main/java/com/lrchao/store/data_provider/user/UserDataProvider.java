package com.lrchao.store.data_provider.user;


import com.lrchao.store.constants.Constants;
import com.lrchao.store.data_provider.NetworkDataProvider;

import java.util.Map;

/**
 * Description: 用户信息的DataProvider
 *
 * @author liuranchao
 * @date 15/12/24 下午5:29
 */
public class UserDataProvider extends NetworkDataProvider {
    @Override
    protected String initUrl() {
        return Constants.API_HOST + Constants.API_USER_ME;
    }

    @Override
    protected int getRequestMethod() {
        return 0;
    }


    @Override
    protected void bindParams(Map<String, Object> params) {

    }

    @Override
    protected void onResponse(Object object) {

    }


}
