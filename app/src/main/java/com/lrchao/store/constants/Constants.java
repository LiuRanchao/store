package com.lrchao.store.constants;

/**
 * Description: 定义公用的常量
 *
 * @author liuranchao
 * @date 15/12/23 下午2:44
 */
public class Constants {

    /**
     * 登录相关的常量
     */
    public static final String PARAM_CLIENT_ID = "client_id";
    public static final String API_KEY = "09fe2c22c4f9604f1dfa84684eec20ed";
    public static final String URL_AUTH = "https://www.douban.com/service/auth2/auth";
    public static final String URL_TOKEN = "https://www.douban.com/service/auth2/token";

    public static final String PARAM_REDIRECT_URI = "redirect_uri";
    public static final String CALLBACK_ADDRESS = "http://doubanread.com/callback";

    public static final String PARAM_RESPONSE_TYPE = "response_type";
    public static final String RESPONSE_TYPE_CODE = "code";

    public static final String PARAM_CLIENT_SECRET = "client_secret";
    public static final String SECRET = "daee2e81300b4c21";

    public static final String PARAM_GRANT_TYPE = "grant_type";
    public static final String AUTHORIZATION_CODE = "authorization_code";


    public static final String API_HOST = "https://api.douban.com/";

    public static final String API_USER_ME = "v2/user/~me";
}
