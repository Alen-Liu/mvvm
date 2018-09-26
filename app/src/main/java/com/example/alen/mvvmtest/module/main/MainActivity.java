package com.example.alen.mvvmtest.module.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.alen.mvvmtest.MyBaseActivity;
import com.example.alen.mvvmtest.R;
import com.example.alen.mvvmtest.event.EventCenterManager;
import com.example.alen.mvvmtest.event.EventConstant;
import com.example.alen.mvvmtest.module.event.EventActivity;
import com.example.alen.mvvmtest.module.food.FoodActivity;
import com.example.alen.mvvmtest.module.main.adapter.FunctionAdapter;
import com.example.alen.mvvmtest.module.main.bean.FunctionBean;
import com.example.common.widget.CommonDialog;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 刘伦
 * @date 2018/9/17
 * 主页面
 */

public class MainActivity extends MyBaseActivity implements EventCenterManager.OnHandleEventListener {

    @BindView(R.id.m_rv_main_func_list)
    RecyclerView mRvMainFuncList;

    Unbinder mUnbinder;
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @Inject
    FunctionAdapter mAdapter;

    @Inject
    MainActivityViewModule viewMoule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);

        initView();
        initData();

        //注册事件监听
        EventCenterManager.addEventListener(EventConstant.EVENT_TYPE_UPDATE_MESSAGE, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        //接触监听
        EventCenterManager.deleteEventListener(EventConstant.EVENT_TYPE_UPDATE_MESSAGE, this);
    }

    private void initView() {
        mAdapter.setListener(bean -> doClick(bean));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvMainFuncList.setLayoutManager(layoutManager);
        mRvMainFuncList.setAdapter(mAdapter);
    }

    private void initData() {
        mAdapter.setList(viewMoule.initFunctionList());
    }

    /**
     * 事件点击监听
     *
     * @param bean 功能实体
     */
    private void doClick(FunctionBean bean) {
        switch (bean.getType()) {
            case FunctionBean.FUNCTION_TYPE_EVENT:
                EventActivity.launch(this);
                break;
            case FunctionBean.FUNCTION_TYPE_FOOD:
                FoodActivity.launch(this);
                break;
            default:
                break;
        }
    }

    /**
     * 事件监听器
     *
     * @param eventMessage
     */
    @Override
    public void onHandleEvent(EventCenterManager.EventMessage eventMessage) {
        if (eventMessage.mEvent == EventConstant.EVENT_TYPE_UPDATE_MESSAGE) {
            mTvTitle.setText(R.string.main_title_message_received);
        }
    }

    /**
     * 连续按两次返回键退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            CommonDialog dialog = new CommonDialog(this);
            dialog.setmContent(getResources().getString(R.string.str_main_exit_process_alert));
            dialog.setOnPositiveButtonClickListener(()->{
                finish();
                System.exit(0);
            });
            dialog.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
