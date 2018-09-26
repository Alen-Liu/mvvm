package com.example.alen.mvvmtest.app;

import com.example.alen.mvvmtest.annotation.App;
import com.example.alen.mvvmtest.annotation.PerActivity;
import com.example.alen.mvvmtest.module.food.FoodActivity;
import com.example.alen.mvvmtest.module.food.FoodActivityModule;
import com.example.alen.mvvmtest.module.main.MainActivity;
import com.example.alen.mvvmtest.module.main.MainActivityModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author 刘伦
 * @date 2018/9/21
 */
@Module
abstract class BindActivityModule {
    @Binds
    @App
    abstract android.app.Application application(MyApplication app);

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();
    @PerActivity
    @ContributesAndroidInjector(modules = FoodActivityModule.class)
    abstract FoodActivity foodActivityInjector();
}
