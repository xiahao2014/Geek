package com.xiahao.geek.di.module;

import com.xiahao.geek.ui.gank.fragment.GankMainFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiahao on 2017/3/19.
 */
@Module
public class PageModule {

    @Provides
    @Singleton
    GankMainFragment provideGankMain() {
        return new GankMainFragment();
    }
}
