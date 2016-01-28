package com.lrchao.store.data_provider.login;

import com.lrchao.store.constants.Constants;
import com.lrchao.store.constants.PreferencesKey;
import com.lrchao.store.data_provider.NetworkDataProvider;
import com.lrchao.store.database.DBManager;
import com.lrchao.store.manager.SessionManager;
import com.lrchao.store.model.user.AccountModel;
import com.lrchao.store.net.resquest.RequestMethod;
import com.lrchao.store.util.LogUtils;
import com.lrchao.store.util.PreferencesUtils;

import java.util.Map;

/**
 * Description: 登录的数据提供者
 *
 * @author liuranchao
 * @date 15/11/23 上午10:49
 */
public class LoginDataProvider extends NetworkDataProvider {

    /**
     * authorization Code
     */
    private String mAuthorizationCode;

    public void setAuthorizationCode(String authorizationCode) {
        mAuthorizationCode = authorizationCode;
    }

    @Override
    protected void bindParams(Map<String, Object> params) {
        params.put(Constants.PARAM_CLIENT_ID, Constants.API_KEY);
        params.put(Constants.PARAM_CLIENT_SECRET, Constants.SECRET);
        params.put(Constants.PARAM_REDIRECT_URI, Constants.CALLBACK_ADDRESS);
        params.put(Constants.PARAM_GRANT_TYPE, Constants.AUTHORIZATION_CODE);
        params.put(Constants.RESPONSE_TYPE_CODE, mAuthorizationCode);
    }

    @Override
    protected String initUrl() {
        return Constants.URL_TOKEN;
    }

    @Override
    protected int getRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    protected void onResponse(Object object) {
        LogUtils.E("object" + object);
        AccountModel accountModel = (AccountModel) object;

        DBManager.get().getAccountDao().insert(accountModel);
        SessionManager.get().getSessionModel().setIsLogin(true);
        SessionManager.get().getSessionModel().setAccessToken(accountModel.getAccess_token());

        // 写入缓存
        PreferencesUtils.get().putBoolean(PreferencesKey.PREFERENCE_KEY_IS_LOGIN, true);
        PreferencesUtils.get().putLong(PreferencesKey.PREFERENCE_KEY_USER_ID, accountModel.getDouban_user_id());

    }

    @Override
    protected Class getJSONResponseClass() {
        return AccountModel.class;
    }
}
