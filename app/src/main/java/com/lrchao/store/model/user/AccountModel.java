package com.lrchao.store.model.user;

import com.lrchao.store.model.JsonModel;

/**
 * Description: 账号模型
 *
 * @author liuranchao
 * @date 15/12/22 下午3:09
 */
public class AccountModel extends JsonModel {

    /**
     * access token
     */
    private String access_token;

    /**
     * 用户名
     */
    private String douban_user_name;

    /**
     * 刷新的token
     */
    private String refresh_token;

    /**
     * 用户ID
     */
    private long douban_user_id;

    /**
     * 超时时长
     */
    private long expires_in;

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getDouban_user_name() {
        return douban_user_name;
    }

    public void setDouban_user_name(String douban_user_name) {
        this.douban_user_name = douban_user_name;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getDouban_user_id() {
        return douban_user_id;
    }

    public void setDouban_user_id(long douban_user_id) {
        this.douban_user_id = douban_user_id;
    }

    @Override
    public void clear() {

    }
}
