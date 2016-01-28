package com.lrchao.store.util;

import com.orhanobut.logger.Logger;

/**
 * Description: Log的工具类
 *
 * @author liuranchao
 * @date 15/11/7 下午10:13
 */
public class LogUtils {

    /**
     * Log是否开启
     */
    private static final boolean IS_OPEN_LOG = true;


    public static void D(String tag, String message) {
        if (IS_OPEN_LOG) {
            Logger.t(tag);
            Logger.d(message);
        }
    }

    public static void D(String message) {
        if (IS_OPEN_LOG) {
            Logger.d(message);
        }
    }

    public static void I(String message) {
        if (IS_OPEN_LOG) {
            Logger.i(message);
        }
    }

    public static void I(String tag, String message) {
        if (IS_OPEN_LOG) {
            Logger.t(tag);
            Logger.i(message);
        }
    }

    public static void E(String message) {
        if (IS_OPEN_LOG) {
            Logger.e(message);
        }
    }

    public static void E(String tag, String message) {
        if (IS_OPEN_LOG) {
            Logger.t(tag);
            Logger.e(message);
        }
    }

    public static void JSON(String message) {
        if (IS_OPEN_LOG) {
            Logger.json(message);
        }
    }

    public static void JSON(String tag, String message) {
        if (IS_OPEN_LOG) {
            Logger.t(tag);
            Logger.json(message);
        }
    }

}
