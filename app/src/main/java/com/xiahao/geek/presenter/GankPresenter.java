package com.xiahao.geek.presenter;

import com.xiahao.geek.base.RxPresenter;
import com.xiahao.geek.mode.bean.remote.GankItemBean;
import com.xiahao.geek.mode.bean.response.GankHttpResponse;
import com.xiahao.geek.mode.http.RetrofitHelper;
import com.xiahao.geek.presenter.contract.GankContract;
import com.xiahao.geek.util.RxUtil;
import com.xiahao.geek.weight.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by xiahao on 2017/3/25.
 */

public class GankPresenter extends RxPresenter<GankContract.View> implements GankContract.Presenter {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public GankPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getGirlImage() {

        Subscription rxSubscription = mRetrofitHelper.fetchRadom(4)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribe(new CommonSubscriber<List<GankItemBean>>(mView, "加载封面失败") {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBean) {
                        mView.showGirlImage(gankItemBean);
                    }
                });
        addSubscrebe(rxSubscription);

    }
}
