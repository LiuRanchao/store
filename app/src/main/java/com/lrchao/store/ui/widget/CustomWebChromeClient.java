package com.lrchao.store.ui.widget;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.lrchao.store.util.LogUtils;


/**
 * Description: 封装的WebChromeClient
 *
 * @author liuranchao
 * @date 15/11/23 下午3:42
 */
public class CustomWebChromeClient extends WebChromeClient {

    private static final String TAG = "MyWebChromeClient";

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        LogUtils.D(TAG, "newProgress=" + newProgress);
    }


}
