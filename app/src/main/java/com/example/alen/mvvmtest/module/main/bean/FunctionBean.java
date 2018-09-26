package com.example.alen.mvvmtest.module.main.bean;

/**
 * @author 刘伦
 * @date 2018/9/17
 *
 * 功能条  实体
 */

public class FunctionBean {
    public static final int FUNCTION_TYPE_EVENT = 1;
    public static final int FUNCTION_TYPE_FOOD = 2;

    /**标题*/
    private String mTitle;
    /**类型*/
    private int mType;

    public FunctionBean( int mType, String mTitle) {
        this.mTitle = mTitle;
        this.mType = mType;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }
}
