package com.example.alen.mvvmtest.app;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;
import com.example.alen.mvvmtest.event.EventCenterManager;
import com.example.common.CommonContext;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;

/**
 * @author 刘伦
 * @date 2018/9/17
 *
 * 1.首先使用multiDex打包，防止方法数超过64k
 * 2.依赖BaseActivity 和 BaseFragment
 * 3.关于代码规范： 最好下载阿里的代码检查工具。另外注意 非公有的变量前面要加上小写m， 静态变量前面加上小写s
 * 4. 基本事件传递使用自定义的  EventCenterManager
 * 5. 使用ButterKnife加载布局控件,注意它在非app module下面的使用需要R2
 * 6. 使用lambda 精简代码
 * 7. Retorfit + Rxjava + Dagger2 + lifecycle + Gson
 * 8. 使用Glide加载图片，在Adapter里面使用的时候需要注意错位问题
 * 9. 通用Toast，通用Dialog，通用ClearEdit，通用Loading； 通用工具最好放在common包里面，防止功能代码分module之后，循环依赖
 * 10. 通用WebView   SafeWebView.java （也可以使用腾讯的TBS）
 * 11. 带下拉刷新和上滑加载的RecyclerView
 * 12. 尽量使用 ConstraintLayout 进行页面布局
 * 13. 添加leak检查，检查内存泄漏
 * 14. 开发阶段就对debug开启混淆，这样会更全面的排查 混淆对代码的影响。避免深路径的混淆对功能的影响
 * 15. 屏幕适配:https://github.com/JessYanCoding/AndroidAutoSize
 * 16. https://github.com/Blankj/AndroidUtilCode 使用通用Utils， 防止重复造轮子
 * 项目收尾阶段需要：
 * 1. 考虑卡顿和过度绘制问题
 * 2. 使用lint检查代码
 * 3. 清理无用的代码
 * 4. 进行操作埋点和异常上报
 * 5. 加固
 * 6. 热更新
 * 接下来需要考量：
 * 3. 单元测试
 * 7. 上传到maven
 */

public class MyApplication extends MultiDexApplication implements HasActivityInjector, HasServiceInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceInjector;

    public static Context mContext;

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        // 初始化common的包
        CommonContext.setAppContext(this);
        //通用的Utils
        Utils.init(this);
        // 初始化监听
        EventCenterManager.initEventCenterManager();
        // 注册component
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        //注册Leak
        if (LeakCanary.isInAnalyzerProcess(this)) {
            //这个进程专门给LeakCanary来作内存分析的，不要在这里做初始化app的事情
            return;
        }
        refWatcher = LeakCanary.install(this);

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }


    @Override
    public AndroidInjector<Service> serviceInjector() {
        return dispatchingServiceInjector;
    }
}
