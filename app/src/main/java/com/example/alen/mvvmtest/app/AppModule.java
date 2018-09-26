package com.example.alen.mvvmtest.app;

import com.example.alen.mvvmtest.module.food.api.FoodApi;
import com.example.common.net.RetroInstance;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author 刘伦
 * @date 2018/9/21
 * 提供需要注入的类
 */
@Module(includes = {BindActivityModule.class, BindServiceModule.class})
class AppModule {
    @Provides
    public Retrofit provideRestroAdapter() {
        return RetroInstance.getInstance();
    }
}
