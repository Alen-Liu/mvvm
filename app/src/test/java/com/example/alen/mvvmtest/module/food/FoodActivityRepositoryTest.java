package com.example.alen.mvvmtest.module.food;

import android.content.Context;

import com.example.alen.mvvmtest.module.food.api.FoodApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;

import dagger.Provides;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

/**
 * @author 刘伦
 * @date 2018/10/12
 */
@RunWith(MockitoJUnitRunner.class)
public class FoodActivityRepositoryTest {
    @Mock
    Context mMockContext;
    FoodActivityRepository repository;
    @Before
    public void createRepositroy(){
    }
    @Test
    public void requestTypeList() throws Exception {

    }

    @Test
    public void getFoodList() throws Exception {
    }

    @Test
    public void getFoodByType() throws Exception {
    }

}