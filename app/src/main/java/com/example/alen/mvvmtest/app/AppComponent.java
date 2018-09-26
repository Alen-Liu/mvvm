package com.example.alen.mvvmtest.app;

import com.example.alen.mvvmtest.annotation.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author 刘伦
 * @date 2018/9/21
 */

@App
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class,
        AndroidInjectionModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication app);

        AppComponent build();
    }
}
