package com.xiahao.geek.di.component;

import android.app.Activity;

import com.xiahao.geek.ui.main.MainActivity;
import com.xiahao.geek.di.module.ActivityModule;
import com.xiahao.geek.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mainActivity);

}
