package com.example.alen.mvvmtest.module.food;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.alen.mvvmtest.module.food.adapter.FoodTypeListBean;
import com.example.alen.mvvmtest.module.food.api.bean.FoodItem;

import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/25
 */

public class FoodActivityViewModule  extends ViewModel {
    private FoodActivityRepository repository;

    public FoodActivityViewModule(FoodActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(repository != null) {
            repository.release();
        }
    }

    public LiveData<List<FoodTypeListBean>> requestTypeList() {
        return repository.requestTypeList();
    }

    /**
     * 获取当前的食物列表
     * @return 列表数据
     */
    public List<FoodItem> getFoodList() {
        return repository.getFoodList();
    }

    public LiveData<Boolean> getFoodByType(int selectedCId, boolean isRefresh) {
        return repository.getFoodByType(selectedCId, isRefresh);
    }
}
