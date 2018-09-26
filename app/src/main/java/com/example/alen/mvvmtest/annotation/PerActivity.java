package com.example.alen.mvvmtest.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author 刘伦
 * @date 2018/9/21
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
