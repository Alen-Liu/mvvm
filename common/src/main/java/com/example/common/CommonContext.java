package com.example.common;

import android.content.Context;

/**
 * @author 刘伦
 * @date 2018/9/20
 */

public class CommonContext {
    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void setAppContext(Context appContext) {
        sAppContext = appContext;
    }
}
