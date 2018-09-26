package com.example.alen.mvvmtest.module.food.api;


import com.example.alen.mvvmtest.module.food.api.bean.FoodResultBean;
import com.example.alen.mvvmtest.module.food.api.bean.FoodTypeResultBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
 * @author 刘伦
 * @date 2018/9/21
 */

public interface FoodApi {

    @POST("/cook/category")
    Observable<FoodTypeResultBean> getFoodType();

    /** 参数大于3 最好用body*/
    @POST("/cook/index")
    @FormUrlEncoded
    Observable<FoodResultBean> getFoodIndex(@Field("cid")int cid, @Field("pn")String pn, @Field("rn")String rn);
}
