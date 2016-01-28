package com.lrchao.store.manager;

import com.lrchao.store.model.user.UserModel;

/**
 * Description: 当前用户的管理
 *
 * @author liuranchao
 * @date 15/12/22 下午3:04
 */
public class UserManager {

    private static UserManager sInstance;

    private UserModel mUserModel;

    private UserManager() {
        mUserModel = new UserModel();
    }

    public static UserManager get() {
        synchronized (UserManager.sInstance) {
            if (sInstance == null) {
                sInstance = new UserManager();
            }
        }
        return sInstance;
    }

    public UserModel getUserModel() {
        return mUserModel;
    }
}
