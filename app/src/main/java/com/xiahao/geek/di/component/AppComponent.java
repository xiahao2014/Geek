package com.xiahao.geek.di.component;


import com.xiahao.geek.app.App;
import com.xiahao.geek.di.module.AppModule;
import com.xiahao.geek.di.module.HttpModule;
import com.xiahao.geek.di.module.PageModule;
import com.xiahao.geek.mode.http.RetrofitHelper;
import com.xiahao.geek.ui.gank.fragment.GankMainFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, PageModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    GankMainFragment gankMainFragment();
}
