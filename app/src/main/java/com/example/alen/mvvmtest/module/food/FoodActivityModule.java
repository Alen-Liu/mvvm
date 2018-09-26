package com.example.alen.mvvmtest.module.food;

import com.example.alen.mvvmtest.annotation.PerActivity;
import com.example.alen.mvvmtest.module.food.api.FoodApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author 刘伦
 * @date 2018/9/25
 */
@Module
public class FoodActivityModule {
    @Provides
    @PerActivity
    FoodActivityRepository provideFoodRepository(FoodApi foodApi) {
        return new FoodActivityRepository(foodApi);
    }

    @Provides
    public FoodApi provideFoodApi(Retrofit restAdapter) {
        return restAdapter.create(FoodApi.class);
    }
    @Provides
    @PerActivity
    FoodActivityViewModule provideFoodVieweModel(FoodActivityRepository r) {
        return new FoodActivityViewModule(r);
    }
}
