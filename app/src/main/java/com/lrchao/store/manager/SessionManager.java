package com.lrchao.store.manager;

import com.lrchao.store.constants.PreferencesKey;
import com.lrchao.store.database.DBManager;
import com.lrchao.store.model.SessionModel;
import com.lrchao.store.model.user.AccountModel;
import com.lrchao.store.util.PreferencesUtils;
import com.orhanobut.logger.Logger;

/**
 * Description: Session的管理
 *
 * @author liuranchao
 * @date 16/1/12 上午11:06
 */
public class SessionManager {

    private static SessionManager sInstance;

    /**
     * Session 对象
     */
    private SessionModel mSessionModel;

    public SessionModel getSessionModel() {
        return mSessionModel;
    }

    private SessionManager(){
        mSessionModel = new SessionModel();
    }

    public static SessionManager get(){
        synchronized (SessionManager.class) {
            if (sInstance == null) {
                sInstance = new SessionManager();
            }
        }
        return sInstance;
    }

    /**
     * 初始化
     */
    public void init() {
        boolean isLogin = PreferencesUtils.get().getBoolean(PreferencesKey.PREFERENCE_KEY_IS_LOGIN, false);
        getSessionModel().setIsLogin(isLogin);

        long userId = PreferencesUtils.get().getLong(PreferencesKey.PREFERENCE_KEY_USER_ID, 0l);
        AccountModel accountModel = DBManager.get().getAccountDao().load(userId);
        if (accountModel != null) {
            getSessionModel().setAccessToken(accountModel.getAccess_token());
        }
        Logger.d("accountModel=" + accountModel);
    }


}
