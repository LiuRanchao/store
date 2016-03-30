package com.lrchao.store.ui.fragment;

import android.text.TextUtils;
import android.view.View;

import com.lrchao.store.constants.Constants;
import com.lrchao.store.data_provider.NetworkDataProvider;
import com.lrchao.store.data_provider.login.LoginDataProvider;
import com.lrchao.store.util.LogUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Description: 登录的Fragment
 *
 * @author liuranchao
 * @date 15/11/8 上午1:29
 */
public class LoginFragment extends BaseWebViewFragment {

    /**
     * URL前缀
     */
    private LoginDataProvider mProvider;

    @Override
    protected void initView(View mainView) {
        super.initView(mainView);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Constants.PARAM_CLIENT_ID, Constants.API_KEY);
        paramMap.put(Constants.PARAM_REDIRECT_URI, Constants.CALLBACK_ADDRESS);
        paramMap.put(Constants.PARAM_RESPONSE_TYPE, Constants.RESPONSE_TYPE_CODE);
        loadUrl(Constants.URL_AUTH, paramMap);
    }


    @Override
    protected void setInterceptUrl(List<String> urlList) {
        urlList.add(Constants.CALLBACK_ADDRESS);
    }

    @Override
    protected void onInterceptedUrlListener(String interceptKeyword, String redirectedUrl) {
        LogUtils.D("onInterceptedUrlListener=" + redirectedUrl);
        if (!TextUtils.isEmpty(redirectedUrl)) {
            if (Constants.CALLBACK_ADDRESS.equals(interceptKeyword)) {
                // 拦截授权成功
                parseAuthorizationSuccess(redirectedUrl);
            }
        }
    }

    /**
     * 解析授权成功处理,解析出authorization_code的值
     * http://doubanread.com/callback?code=bbd742b070e24aed
     */
    private void parseAuthorizationSuccess(String url) {

        String authorizationCode = "";
        // 得到参数字符串?code=bbd742b070e24aed
        String paramsStr = url.replace(Constants.CALLBACK_ADDRESS, "");
        String paramKey = "?code=";
        if (paramsStr.contains(paramKey)) {
            authorizationCode = paramsStr.replace(paramKey, "");
        }

        if (!TextUtils.isEmpty(authorizationCode)) {
            mProvider.setAuthorizationCode(authorizationCode);
            mProvider.load();
        }
    }

//    @Override
//    protected NetworkDataProvider initDataProvider() {
//        mProvider = new LoginDataProvider();
//        return mProvider;
//    }
}
