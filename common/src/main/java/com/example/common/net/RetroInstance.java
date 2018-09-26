package com.example.common.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alen on 2018/2/27.
 *
 *
 * Retrofit  实体类   单例
 */

public class RetroInstance {
    private static Retrofit retrofit = null;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
            OkHttpClient okHttpClient = new OkHttpClient();
            OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.addInterceptor(new RequestInterceptor());
            builder.retryOnConnectionFailure(true);
            retrofit = new Retrofit.Builder().client(okHttpClient)
                    .baseUrl(NetConstants.BASE_NET_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(builder.build())
                    .build();
        }
        return retrofit;
    }
}
