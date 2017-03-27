package com.xiahao.geek.presenter.contract;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.xiahao.geek.base.BasePresenter;
import com.xiahao.geek.base.BaseView;

/**
 * Created by xiahao on 2017/3/25.
 */

public interface MainContract {

    interface View extends BaseView {

        void showUpdateDialog(String versionContent);

        void startDownloadService();
    }

    interface Presenter extends BasePresenter<View> {

        void checkVersion(String currentVersion);

        void checkPermissions(RxPermissions rxPermissions);
    }
}
