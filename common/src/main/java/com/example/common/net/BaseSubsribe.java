package com.example.common.net;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Alen on 2018/2/27.
 * 观察者  来管理网络请求开始结束，成功与失败
 */

public abstract class BaseSubsribe<T> implements Subscriber<T> {
    private static final String TAG = "BaseSubsribe";

    @Override
    public void onSubscribe(Subscription s) {
        Log.i(TAG, "onSubscribe");
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "response" + t.toString());

        onSuccess(t);
    }

    public abstract void onSuccess(T result);

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Log.i(TAG, "onError" + e.getMessage());

    }

}
