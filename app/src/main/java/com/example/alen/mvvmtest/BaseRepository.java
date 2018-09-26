package com.example.alen.mvvmtest;

import android.support.annotation.Nullable;

import io.reactivex.disposables.Disposable;

/**
 * @author 刘伦
 * @date 2018/9/21
 */

public abstract class BaseRepository {
    /**
     * 释放资源
     */
    public abstract void release();

    protected void checkAndDispose(@Nullable Disposable... disposables) {
        for (Disposable disposable : disposables) {
            if (disposable != null && !disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
