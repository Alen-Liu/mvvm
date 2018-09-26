package com.example.alen.mvvmtest.module.food.api.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/26
 */

public class FoodItem {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("tags")
    private String tags;
    @SerializedName("imtro")
    private String imtro;
    @SerializedName("ingredients")
    private String ingredients;
    @SerializedName("burden")
    private String burden;
    @SerializedName("albums")
    private List<String> albums;
    @SerializedName("steps")
    private List<FoodStepsItem> steps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getImtro() {
        return imtro;
    }

    public void setImtro(String imtro) {
        this.imtro = imtro;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getBurden() {
        return burden;
    }

    public void setBurden(String burden) {
        this.burden = burden;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    public List<FoodStepsItem> getSteps() {
        return steps;
    }

    public void setSteps(List<FoodStepsItem> steps) {
        this.steps = steps;
    }


}
