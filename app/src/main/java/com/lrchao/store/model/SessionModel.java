package com.lrchao.store.model;

/**
 * Description: Session对象
 *
 * @author liuranchao
 * @date 16/1/12 上午11:09
 */
public class SessionModel implements BaseModel{

    /**
     * 是否已经登录
     */
    private boolean mIsLogin;

    /**
     * Access token
     */
    private String mAccessToken;

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    public boolean isLogin() {
        return mIsLogin;
    }

    public void setIsLogin(boolean isLogin) {
        mIsLogin = isLogin;
    }

    @Override
    public void clear() {

    }
}
