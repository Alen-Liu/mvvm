package com.example.alen.mvvmtest.module.food.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

import com.example.alen.mvvmtest.module.food.api.bean.FoodItem;

import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/26
 * 食物列表DiffUtil 类
 */

public class FoodItemDiffCallBack extends DiffUtil.Callback{
    private List<FoodItem> mOldList;
    private List<FoodItem> mNewList;

    public FoodItemDiffCallBack(List<FoodItem> mOldList, List<FoodItem> mNewList) {
        this.mOldList = mOldList;
        this.mNewList = mNewList;
    }

    @Override
    public int getOldListSize() {
        return mOldList == null ? 0 : mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList == null ? 0 : mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        String oldId = mOldList.get(oldItemPosition).getId();
        String newId = mNewList.get(newItemPosition).getId();
        return TextUtils.equals(oldId, newId);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        FoodItem oldItem = mOldList.get(oldItemPosition);
        FoodItem newItem = mNewList.get(newItemPosition);
        return TextUtils.equals(oldItem.getTitle(), newItem.getTitle());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        FoodItem oldItem = mOldList.get(oldItemPosition);
        FoodItem newItem = mNewList.get(newItemPosition);
        Bundle diffBundle = new Bundle();
        if(!TextUtils.equals(oldItem.getTitle(), newItem.getTitle())){
            diffBundle.putString("titile", newItem.getTitle());
        }
        return diffBundle;
    }
}
