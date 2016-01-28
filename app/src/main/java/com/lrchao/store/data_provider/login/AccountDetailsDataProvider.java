package com.lrchao.store.data_provider.login;


import com.lrchao.store.data_provider.NetworkDataProvider;

import java.util.Map;

/**
 * Description: TODO
 *
 * @author liuranchao
 * @date 15/12/23 下午2:40
 */
public class AccountDetailsDataProvider extends NetworkDataProvider {


    @Override
    protected String initUrl() {
        return null;
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
