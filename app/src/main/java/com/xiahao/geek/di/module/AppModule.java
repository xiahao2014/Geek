package com.xiahao.geek.di.module;


import com.xiahao.geek.app.App;
import com.xiahao.geek.mode.http.RetrofitHelper;
import com.xiahao.geek.mode.http.api.GankApis;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper(GankApis gankApiService) {
        return new RetrofitHelper(gankApiService);
    }

}
