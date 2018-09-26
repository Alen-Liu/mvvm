package com.example.common.widget;

import android.widget.Toast;
import com.example.common.CommonContext;

/**
 * @author 刘伦
 * @date 2018/9/18
 *
 * 通用Toast
 */

public class CommonToast {
    private static Toast mToast;

    public static void showShort(String str){
        if(mToast == null) {
            mToast = Toast.makeText(CommonContext.getAppContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(str);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showShort(int resId){
        if(mToast == null) {
            mToast = Toast.makeText(CommonContext.getAppContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(CommonContext.getAppContext().getResources().getString(resId));
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showLong(String str){
        if(mToast == null) {
            mToast = Toast.makeText(CommonContext.getAppContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(str);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showLong(int resId){
        if(mToast == null) {
            mToast = Toast.makeText(CommonContext.getAppContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(CommonContext.getAppContext().getResources().getString(resId));
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }
}
