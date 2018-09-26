package com.example.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.common.R;


/**
 * @author 刘伦
 * @date 2018/9/18
 *
 * 通用 Loading框
 */
public class LoadingDialog extends Dialog {
    public TextView mMessageText;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.style_loading_dialog);
        init(context);
    }

    private void init(Context context) {
        // 加载布局
        setContentView(R.layout.layout_loading_dialog);
        // 设置Dialog参数
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);

        //点外部不消失
        setCanceledOnTouchOutside(false);
    }
}
