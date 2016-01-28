package com.lrchao.store.ui.fragment;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;

import com.lrchao.store.R;
import com.lrchao.store.ui.widget.CustomWebChromeClient;
import com.lrchao.store.ui.widget.CustomWebViewClient;
import com.lrchao.store.ui.widget.WebViewProgressBar;
import com.lrchao.store.util.LogUtils;
import com.lrchao.store.util.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Description: Fragment的基类
 *
 * @author liuranchao
 * @date 15/11/23 下午2:16
 */
public abstract class BaseWebViewFragment extends BaseNetworkFragment implements CustomWebViewClient.OnPageLoadListener, CustomWebViewClient.OnOverrideUrlListener {


    @Bind(R.id.web_view)
    WebView mWebView;

    @Bind(R.id.pb_loading)
    WebViewProgressBar mProgressBar;

    /**
     * WebViewClient
     */
    private CustomWebViewClient mWebViewClient;

    /**
     * WebViewChromeClient
     */
    private CustomWebChromeClient mWebChromeClient;

    /**
     * 要拦截的Url集合
     */
    private List<String> mInterceptUrlList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_webview;
    }

    @Override
    protected void initView(View mainView) {

        mWebViewClient = new CustomWebViewClient();
        mWebViewClient.setOnPageLoadListener(this);

        setInterceptUrl(mInterceptUrlList);
        mWebViewClient.setOnOverrideUrlListener(this);

        mWebChromeClient = new CustomWebChromeClient();

        mWebView.setWebViewClient(mWebViewClient);
        mWebView.setWebChromeClient(mWebChromeClient);
    }

    /**
     * 加载url
     * @param url url
     * @param paramMap  参数
     */
    protected void loadUrl(String url, HashMap<String, Object> paramMap) {

        String paramsStr = MapUtils.getUrlParams(paramMap);
        String finalUrl = url + paramsStr;

        LogUtils.D("finalUrl=" + finalUrl);
        mWebView.loadUrl(finalUrl);
    }


    /**
     * 设置要拦截的重定向的url集合
     *
     * @param urlList
     */
    protected void setInterceptUrl(List<String> urlList) {

    }

    @Override
    public void onDestroyView() {
        mProgressBar.stop();
        super.onDestroyView();
    }

    @Override
    public void onPageLoadFinish() {
        mProgressBar.startToFinish();
    }

    @Override
    public void onPageLoadStart() {
        mProgressBar.startAutoLoad();
    }


    @Override
    public boolean onInterceptUrl(String url) {

        boolean isIntercept = false;
        if (mInterceptUrlList.size() > 0 && !TextUtils.isEmpty(url)) {

            // 如果包含，则进行拦截
            for (String interceptKey : mInterceptUrlList) {
                if (url.contains(interceptKey)) {
                    isIntercept = true;
                    onInterceptedUrlListener(interceptKey, url);
                    break;
                }
            }
        }
        return isIntercept;
    }

    /**
     * 检测到拦截关心的URL后调用
     * @param interceptKeyword 拦截的keyword
     * @param redirectedUrl 被拦截的URL
     */
    protected void onInterceptedUrlListener(String interceptKeyword, String redirectedUrl) {

    }
}
