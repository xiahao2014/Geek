package com.xiahao.geek.ui.gank.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiahao.geek.R;
import com.xiahao.geek.app.Constants;
import com.xiahao.geek.base.BaseFragment;
import com.xiahao.geek.mode.bean.remote.GankItemBean;
import com.xiahao.geek.presenter.TechPresenter;
import com.xiahao.geek.presenter.contract.TechContract;
import com.xiahao.geek.ui.gank.adapter.TechAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiahao on 2017/3/25.
 */

public class TechFragment extends BaseFragment<TechPresenter> implements TechContract.View {


    @BindView(R.id.rv_tech_content)
    RecyclerView mRvTechContent;


    TechAdapter mAdapter;
    List<GankItemBean> mList ;
    String tech;
    int type;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tech;
    }

    @Override
    protected void initEventAndData() {
//        for (int i = 0; i < 20; i++) {
//            mList.add("ABCDEFG" + i);
//        }
        mList = new ArrayList<>();
        tech = getArguments().getString(Constants.IT_GANK_TYPE);
        type = getArguments().getInt(Constants.IT_GANK_TYPE_CODE);
        mRvTechContent.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new TechAdapter(mContext, mList, tech);
        mPresenter.getGankData(tech, type);
        mRvTechContent.setAdapter(mAdapter);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent(List<GankItemBean> list) {

        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void showMoreContent(List<GankItemBean> mList) {

    }
}
