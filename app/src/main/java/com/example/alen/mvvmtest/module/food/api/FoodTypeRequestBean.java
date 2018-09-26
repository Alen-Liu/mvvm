package com.example.alen.mvvmtest.module.food.api;

import com.example.common.net.BaseRequestBean;

/**
 * @author 刘伦
 * @date 2018/9/21
 */
@Deprecated
public class FoodTypeRequestBean extends BaseRequestBean{
    private int parentid;

    public FoodTypeRequestBean(int parentid) {
        this.parentid = parentid;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }
}
