package com.example.alen.mvvmtest.module.main;

import com.example.alen.mvvmtest.annotation.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author 刘伦
 * @date 2018/9/21
 */
@Module
public class MainActivityModule {

    @Provides
    @PerActivity
    MainActivityRepository provideMainRepository() {
        return new MainActivityRepository();
    }

    @Provides
    @PerActivity
    MainActivityViewModule provideMainVieweModel(MainActivityRepository r) {
        return new MainActivityViewModule(r);
    }
}
