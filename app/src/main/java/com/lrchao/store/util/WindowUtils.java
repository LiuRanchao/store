package com.lrchao.store.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.lrchao.store.R;

/**
 * Description: Window相关的工具类
 *
 * @author liuranchao
 * @date 16/1/30 上午11:18
 */
public class WindowUtils {

    /**
     * 修改状态栏的颜色
     *
     * @param context    Activity
     * @param colorResId color的资源ID
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarColor(Activity context, int colorResId) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.setStatusBarColor(context.getResources().getColor(R.color.colorPrimaryDarkRed, null));
            } else {
                window.setStatusBarColor(context.getResources().getColor(colorResId));
            }
        }
    }
}
