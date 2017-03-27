package com.xiahao.geek.mode.http;

import com.xiahao.geek.mode.bean.remote.GankItemBean;
import com.xiahao.geek.mode.bean.response.GankHttpResponse;
import com.xiahao.geek.mode.http.api.GankApis;

import java.util.List;

import rx.Observable;

/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper {

    private GankApis mGankApiService;


    public RetrofitHelper(GankApis gankApiService) {
        this.mGankApiService = gankApiService;
    }


    public Observable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
        return mGankApiService.getTechList(tech, num, page);
    }

    public Observable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
        return mGankApiService.getGirlList(num, page);
    }

    public Observable<GankHttpResponse<List<GankItemBean>>> fetchRadom(int num) {
        return mGankApiService.getRandomGirl(num);
    }
}
