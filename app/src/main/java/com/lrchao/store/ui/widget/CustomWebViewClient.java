package com.lrchao.store.ui.widget;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lrchao.store.util.LogUtils;


/**
 * Description: WebViewClient封装
 *
 * @author liuranchao
 * @date 15/11/23 下午2:59
 */
public class CustomWebViewClient extends WebViewClient {

    private static final String TAG = "MyWebViewClient";

    /**
     * 加载情况监听
     */
    private OnPageLoadListener mOnPageLoadListener;

    /**
     * 重定向监听
     */
    private OnOverrideUrlListener mOnOverrideUrlListener;

    /**
     * 禁止弹出外部浏览器
     *
     * @param view WebView
     * @param url  地址
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {


        boolean isIntercept= false;
        if (mOnOverrideUrlListener != null) {
            isIntercept = mOnOverrideUrlListener.onInterceptUrl(url);
        }

        LogUtils.D(TAG, "shouldOverrideUrlLoading=" + url + " isIntercept=" + isIntercept);
        if (!isIntercept) {
            view.loadUrl(url);
        }
        return true;
    }


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        LogUtils.D(TAG, "onPageStarted()");
        if (mOnPageLoadListener != null) {
            mOnPageLoadListener.onPageLoadStart();
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        LogUtils.D(TAG, "onPageFinished()");
        if (mOnPageLoadListener != null) {
            mOnPageLoadListener.onPageLoadFinish();
        }
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);

        LogUtils.E(TAG, "onReceivedError=request=" + request.toString() + " error=" + error.toString());
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        LogUtils.E(TAG, "onReceivedError=errorCode=" + errorCode + " description=" + description + " failingUrl=" + failingUrl);
    }

    /**
     * 页面加载监听
     */
    public interface OnPageLoadListener {

        /**
         * 加载完成，包括失败
         */
        void onPageLoadFinish();

        void onPageLoadStart();
    }

    public void setOnPageLoadListener(OnPageLoadListener onPageLoadListener) {
        mOnPageLoadListener = onPageLoadListener;
    }


    /**
     * Url重定向监听
     */
    public interface OnOverrideUrlListener {
        /**
         * 在loadUrl前调用
         *
         * @param url 重定向的地址
         * @return true:拦截不让加载 false：不拦截可以
         */
        boolean onInterceptUrl(String url);
    }

    public void setOnOverrideUrlListener(OnOverrideUrlListener onOverrideUrlListener) {
        mOnOverrideUrlListener = onOverrideUrlListener;
    }


}
