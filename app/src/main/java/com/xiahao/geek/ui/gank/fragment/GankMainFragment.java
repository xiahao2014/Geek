package com.xiahao.geek.ui.gank.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.xiahao.geek.R;
import com.xiahao.geek.app.Constants;
import com.xiahao.geek.base.BaseFragment;
import com.xiahao.geek.common.ImageLoader;
import com.xiahao.geek.mode.bean.remote.GankItemBean;
import com.xiahao.geek.presenter.GankPresenter;
import com.xiahao.geek.presenter.contract.GankContract;
import com.xiahao.geek.ui.gank.adapter.GankMainAdapter;
import com.xiahao.geek.weight.CoordinatorTabLayout;
import com.xiahao.geek.weight.intefrace.LoadHeaderImagesListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiahao on 2017/3/19.
 */

public class GankMainFragment extends BaseFragment<GankPresenter> implements GankContract.View {

    @BindView(R.id.vp_gank_main)
    ViewPager mViewPager;
    @BindView(R.id.coordinatortablayout)
    CoordinatorTabLayout mCoordinatortablayout;
    public static String[] tabTitle = new String[]{"Android", "iOS", "前端", "福利"};
    List<Fragment> fragments = new ArrayList<Fragment>();
    private int[] mImageArray, mColorArray;
    GankMainAdapter mAdapter;
    private List<GankItemBean> mGankItemBeen;

    TechFragment androidFragment;
    TechFragment iOSFragment;
    TechFragment webFragment;
    TechFragment girlFragment;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_main;
    }

    @Override
    protected void initEventAndData() {

        androidFragment = new TechFragment();
        iOSFragment = new TechFragment();
        webFragment = new TechFragment();
        girlFragment = new TechFragment();

        Bundle androidBundle = new Bundle();
        androidBundle.putString(Constants.IT_GANK_TYPE, tabTitle[0]);
        androidBundle.putInt(Constants.IT_GANK_TYPE_CODE, Constants.TYPE_ANDROID);
        androidFragment.setArguments(androidBundle);

        Bundle iosdBundle = new Bundle();
        iosdBundle.putString(Constants.IT_GANK_TYPE, tabTitle[1]);
        iosdBundle.putInt(Constants.IT_GANK_TYPE_CODE, Constants.TYPE_IOS);
        iOSFragment.setArguments(iosdBundle);

        Bundle webBundle = new Bundle();
        webBundle.putString(Constants.IT_GANK_TYPE, tabTitle[2]);
        webBundle.putInt(Constants.IT_GANK_TYPE_CODE, Constants.TYPE_WEB);
        webFragment.setArguments(webBundle);

        Bundle girlBundle = new Bundle();
        girlBundle.putString(Constants.IT_GANK_TYPE, tabTitle[3]);
        girlBundle.putInt(Constants.IT_GANK_TYPE_CODE, Constants.TYPE_GIRL);
        girlFragment.setArguments(girlBundle);

        fragments.add(androidFragment);
        fragments.add(iOSFragment);
        fragments.add(webFragment);
        fragments.add(girlFragment);
        mAdapter = new GankMainAdapter(getChildFragmentManager(), fragments, tabTitle);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(mAdapter);


        mImageArray = new int[]{
                R.mipmap.bg_android,
                R.mipmap.bg_ios,
                R.mipmap.bg_js,
                R.mipmap.bg_other};
        mColorArray = new int[]{
                R.color.android_bg,
                R.color.ios_bg,
                R.color.web_bg,
                R.color.girl_bg};
        mCoordinatortablayout.setTitle("干货集中营")
                .setBackEnable(false)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager).setLoadHeaderImagesListener(new LoadHeaderImagesListener() {
            @Override
            public void loadHeaderImages(ImageView imageView, TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        loadImages(imageView, mGankItemBeen.get(0).getUrl());
                        break;
                    case 1:
                        loadImages(imageView, mGankItemBeen.get(1).getUrl());
                        break;
                    case 2:
                        loadImages(imageView, mGankItemBeen.get(2).getUrl());
                        break;
                    case 3:
                        loadImages(imageView, mGankItemBeen.get(3).getUrl());
                        break;
                    default:
                        break;
                }
            }


        });
        mPresenter.getGirlImage();
    }

    private void loadImages(ImageView imageView, String url) {
        ImageLoader.load(mContext, url, imageView);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showGirlImage(List<GankItemBean> gankItemBean) {
        loadImages(mCoordinatortablayout.getImageView(), gankItemBean.get(0).getUrl());
        mGankItemBeen = gankItemBean;
    }
}
