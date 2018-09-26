package com.example.alen.mvvmtest.module.food.api.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author 刘伦
 * @date 2018/9/21
 */

public class FoodTypeItem {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("parentId")
    private String parentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
