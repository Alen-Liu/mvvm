package com.example.alen.mvvmtest.module.food.api.bean;

import com.example.common.net.BaseResultBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/21
 */

public class FoodTypeResultBean extends BaseResultBean{

    @SerializedName("result")
    private List<FoodCategoryItem> result;

    public List<FoodCategoryItem> getResult() {
        return result;
    }

    public void setResult(List<FoodCategoryItem> result) {
        this.result = result;
    }
}
