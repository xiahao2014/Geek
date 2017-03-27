package com.xiahao.geek.presenter.contract;

import com.xiahao.geek.base.BasePresenter;
import com.xiahao.geek.base.BaseView;
import com.xiahao.geek.mode.bean.remote.GankItemBean;

import java.util.List;

/**
 * Created by xiahao on 2017/3/25.
 */

public interface TechContract {

    interface View extends BaseView {

        void showContent(List<GankItemBean> mList);

        void showMoreContent(List<GankItemBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getGankData(String tech, int type);

        void getMoreGankData(String tech);

    }
}
