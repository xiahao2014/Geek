package com.xiahao.geek.presenter;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.xiahao.geek.base.RxPresenter;
import com.xiahao.geek.mode.http.RetrofitHelper;
import com.xiahao.geek.presenter.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by xiahao on 2017/3/25.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    private RetrofitHelper retrofitHelper;

    @Inject
    public MainPresenter(RetrofitHelper retrofitHelper) {
        this.retrofitHelper = retrofitHelper;

    }

    @Override
    public void checkVersion(String currentVersion) {

    }

    @Override
    public void checkPermissions(RxPermissions rxPermissions) {

    }
}
