package com.example.alen.mvvmtest.module.main;

import com.example.alen.mvvmtest.BaseRepository;
import com.example.alen.mvvmtest.module.main.bean.FunctionBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/21
 */

public class MainActivityRepository extends BaseRepository {

    @Override
    public void release() {

    }

    public List<FunctionBean> initFunctionList() {
        List<FunctionBean> data = new ArrayList<>();
        data.add(new FunctionBean(FunctionBean.FUNCTION_TYPE_EVENT, "消息测试"));
        data.add(new FunctionBean(FunctionBean.FUNCTION_TYPE_FOOD, "菜谱大全"));
        return data;
    }
}
