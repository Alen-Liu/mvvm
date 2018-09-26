package com.example.alen.mvvmtest.module.food.api.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/21
 */

public class FoodCategoryItem {
    @SerializedName("parentId")
    private String parentId;
    @SerializedName("name")
    private String name;
    @SerializedName("list")
    private List<FoodTypeItem> list;
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodTypeItem> getList() {
        return list;
    }

    public void setList(List<FoodTypeItem> list) {
        this.list = list;
    }
}
