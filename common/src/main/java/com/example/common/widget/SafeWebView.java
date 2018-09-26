package com.example.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;
/**
 * @author 刘伦
 * @date 2018/9/20
 */

public class SafeWebView extends WebView {
    public SafeWebView(Context context) {
        super(context);
        makeWebViewSafe();
    }

    public SafeWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        makeWebViewSafe();
    }

    public SafeWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        makeWebViewSafe();
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public SafeWebView(Context context, AttributeSet attrs, int defStyle,
                       boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
        makeWebViewSafe();
    }

    @SuppressWarnings("deprecation")
    private void makeWebViewSafe() {
        removeSearchBoxJavaBridgeInterface();
        getSettings().setAllowFileAccess(false);
        getSettings().setSavePassword(false);
    }

    @SuppressLint("NewApi")
    private void removeSearchBoxJavaBridgeInterface() {
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 17) {
            removeJavascriptInterface("searchBoxJavaBridge_");
        }
    }

    @SuppressLint("JavascriptInterface")
    @Override
    public void addJavascriptInterface(Object object, String name) {
        // API 17以下版本暂时不允许使用addJavascriptInterface方法，防止系统调用造成注入漏洞。
        if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(object, name);
        }
    }
}
