package com.example.alen.mvvmtest.module.food.api.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author 刘伦
 * @date 2018/9/26
 */

public class FoodStepsItem {

    @SerializedName("img")
    private String img;
    @SerializedName("step")
    private String step;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
