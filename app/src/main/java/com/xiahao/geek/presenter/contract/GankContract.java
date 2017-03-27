package com.xiahao.geek.presenter.contract;

import com.xiahao.geek.base.BasePresenter;
import com.xiahao.geek.base.BaseView;
import com.xiahao.geek.mode.bean.remote.GankItemBean;

import java.util.List;

/**
 * Created by xiahao on 2017/3/25.
 */

public interface GankContract {

    interface View extends BaseView {

        void showGirlImage(List<GankItemBean> gankItemBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getGirlImage();
    }
}
