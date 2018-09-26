package com.example.alen.mvvmtest.module.event;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.alen.mvvmtest.MyBaseActivity;
import com.example.alen.mvvmtest.R;
import com.example.alen.mvvmtest.event.EventCenterManager;
import com.example.alen.mvvmtest.event.EventConstant;
import com.example.common.widget.CommonToast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 刘伦
 * @date 2018/9/17
 * 测试EventCenterManager
 *
 * 不用 dagger+mvvm的框架，就不要继承 MyBaseActivity
 */

public class EventActivity extends AppCompatActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, EventActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.m_tv_send_message)
    public void onViewClicked() {
        /*发送消息*/
        EventCenterManager.synSendEvent(new EventCenterManager.EventMessage(EventConstant.EVENT_TYPE_UPDATE_MESSAGE));
        CommonToast.showShort(R.string.str_event_page_message_send_toast);

        //关闭页面
        this.finish();
    }
}
