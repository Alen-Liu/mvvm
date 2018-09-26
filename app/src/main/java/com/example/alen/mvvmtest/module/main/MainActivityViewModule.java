package com.example.alen.mvvmtest.module.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.alen.mvvmtest.module.main.bean.FunctionBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘伦
 * @date 2018/9/21
 */

public class MainActivityViewModule extends ViewModel {
    private MainActivityRepository repository;

    public MainActivityViewModule(MainActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(repository != null) {
            repository.release();
        }
    }

    public List<FunctionBean> initFunctionList() {
        return repository.initFunctionList();
    }
}
