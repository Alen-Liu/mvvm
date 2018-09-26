package com.example.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author 刘伦
 * @date 2018/9/18
 * 通用dialog
 */

public class CommonDialog extends Dialog {
    @BindView(R2.id.tv_dialog_title)
    TextView tvDialogTitle;
    @BindView(R2.id.divider_line)
    View dividerLine;
    @BindView(R2.id.tv_content)
    TextView tvContent;
    @BindView(R2.id.tv_cancel)
    TextView tvCancel;
    @BindView(R2.id.tv_confirm)
    TextView tvConfirm;
    private Unbinder mUnBinder;

    private OnPositiveButtonClickListener mPositiveOnClickListener;

    public CommonDialog(@NonNull Context context) {
        super(context, R.style.common_dialog_style);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_common_dialog, null);
        mUnBinder = ButterKnife.bind(this, view);
        setContentView(view);

    }

    public void setmContent(String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        this.tvContent.setText(content);
    }

    public void setmTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            return;
        }
        this.tvDialogTitle.setText(title);
    }

    public void setOnPositiveButtonClickListener(OnPositiveButtonClickListener positiveButtonClickListener) {
        this.mPositiveOnClickListener = positiveButtonClickListener;
    }

    @OnClick(R2.id.tv_confirm)
    public void onConfirmClick() {
        if (mPositiveOnClickListener != null) {
            mPositiveOnClickListener.onPositiveListener();
        }
    }

    @OnClick(R2.id.tv_cancel)
    public void onCancelClick() {
        dismiss();
    }

    public interface OnPositiveButtonClickListener {
        void onPositiveListener();
    }

    @Override
    public void dismiss() {
        super.dismiss();

    }
}

