package com.xiahao.geek.di.component;

import android.app.Activity;

import com.xiahao.geek.di.module.FragmentModule;
import com.xiahao.geek.di.scope.FragmentScope;
import com.xiahao.geek.ui.gank.fragment.GankMainFragment;
import com.xiahao.geek.ui.gank.fragment.TechFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(GankMainFragment gankMainFragment);

    void inject(TechFragment techFragment);
}
