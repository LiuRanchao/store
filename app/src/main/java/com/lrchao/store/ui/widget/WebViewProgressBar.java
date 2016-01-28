package com.lrchao.store.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

/**
 * Description: 自定义水平的Progress,应用与WebView，自定加载
 *
 * @author liuranchao
 * @date 15/11/23 下午3:58
 */
public class WebViewProgressBar extends ProgressBar {

    private static final String TAG = "WebViewProgressBar";
    /**
     * message what value
     */
    private static final int MSG_WHAT_AUTO_LOAD = 1; // 自动加载
    private static final int MSG_WHAT_STOP = 2; // 立刻停止加载
    private static final int MSG_WHAT_LOAD_FINISH = 3; //收到页面加载完成的通知，迅速走完进度条
    private MyHandler mMyHandler;

    public WebViewProgressBar(Context context) {
        super(context);
        initView();
    }

    public WebViewProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mMyHandler = new MyHandler(this);

    }

    /**
     * 开始自动加载
     */
    public void startAutoLoad() {
        mMyHandler.sendEmptyMessage(MSG_WHAT_AUTO_LOAD);
    }

    /**
     * 开始开始匀速直接加载结束
     */
    public void startToFinish() {
        mMyHandler.sendEmptyMessage(MSG_WHAT_LOAD_FINISH);
    }

    /**
     * 停止加载进度
     */
    public void stop() {
        mMyHandler.sendEmptyMessage(MSG_WHAT_STOP);
    }


    private static final class MyHandler extends Handler {

        /**
         * 速率
         */
        private static final int FPS_ONE = 50; //0－60
        private static final int FPS_TWO = 200; //60-80
        private static final int FPS_FINAL = 5; //80-100

        /**
         * 更换速率的点
         */
        private static final int END_PERCENT_ONE = 60; //第一个速度结束的百分比
        private static final int END_PERCENT_TWO = 80; // 第二阶段结束的点
        private final WeakReference<WebViewProgressBar> mWebViewProgressBarWeakReference;
        /**
         * 实际进度
         */
        private int mProgressValue = 0;
        /**
         * 是否停止自动
         */
        private boolean mStopAuto = false;

        public MyHandler(WebViewProgressBar webViewProgressBar) {
            mWebViewProgressBarWeakReference = new WeakReference<>(webViewProgressBar);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            WebViewProgressBar progressBar = mWebViewProgressBarWeakReference.get();

            if (progressBar == null) {
                return;
            }

            switch (msg.what) {
                case MSG_WHAT_AUTO_LOAD:

                    if (mStopAuto) {
                        return;
                    }

                    progressBar.setProgress(mProgressValue);

                    mProgressValue++;

                    if (mProgressValue <= END_PERCENT_ONE) {

                        sendEmptyMessageDelayed(MSG_WHAT_AUTO_LOAD, FPS_ONE);

                    } else if (mProgressValue <= END_PERCENT_TWO) {

                        sendEmptyMessageDelayed(MSG_WHAT_AUTO_LOAD, FPS_TWO);

                    }
                    // 大于END_PERCENT_TWO 则停止自动加载

                    break;

                case MSG_WHAT_STOP:

                    mStopAuto = true;
                    mProgressValue = 100;
                    break;

                case MSG_WHAT_LOAD_FINISH:

                    // 停止自动的
                    mStopAuto = true;

                    if (mProgressValue <= 100) {

                        progressBar.setProgress(mProgressValue);

                        mProgressValue++;

                        sendEmptyMessageDelayed(MSG_WHAT_LOAD_FINISH, FPS_FINAL);
                    } else {
                        // 如果到100，则消失
                        progressBar.setVisibility(View.GONE);
                    }
                    break;

                default:
                    break;
            }
        }

    }


}
