package com.xiahao.geek.presenter;

import com.xiahao.geek.app.Constants;
import com.xiahao.geek.base.RxPresenter;
import com.xiahao.geek.mode.bean.remote.GankItemBean;
import com.xiahao.geek.mode.bean.response.GankHttpResponse;
import com.xiahao.geek.mode.http.RetrofitHelper;
import com.xiahao.geek.presenter.contract.TechContract;
import com.xiahao.geek.ui.gank.fragment.GankMainFragment;
import com.xiahao.geek.util.RxUtil;
import com.xiahao.geek.weight.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;


/**
 * Created by xiahao on 2017/3/25.
 */

public class TechPresenter extends RxPresenter<TechContract.View> implements TechContract.Presenter {

    private RetrofitHelper mRetrofitHelper;
    private static final int NUM_OF_PAGE = 20;

    private int currentPage = 1;
    private String queryStr = null;
    private String currentTech = GankMainFragment.tabTitle[0];
    private int currentType = Constants.TYPE_ANDROID;

    @Inject
    public TechPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getGankData(String tech, int type) {
        queryStr = null;
        currentPage = 1;
        currentTech = tech;
        currentType = type;
        Subscription rxSubscription = mRetrofitHelper.fetchTechList(tech, NUM_OF_PAGE, currentPage)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribe(new CommonSubscriber<List<GankItemBean>>(mView) {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {
                        mView.showContent(gankItemBeen);
                    }
                });
        addSubscrebe(rxSubscription);

    }

    @Override
    public void getMoreGankData(String tech) {

    }
}
