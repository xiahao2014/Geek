package com.xiahao.geek.ui.gank.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiahao.geek.R;
import com.xiahao.geek.mode.bean.remote.GankItemBean;
import com.xiahao.geek.ui.gank.fragment.GankMainFragment;
import com.xiahao.geek.util.DateUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiahao on 2017/3/25.
 */

public class TechAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<GankItemBean> mList;
    private String tech;
    private LayoutInflater inflater;

    public TechAdapter(Context mContext, List<GankItemBean> mList, String tech) {
        inflater = LayoutInflater.from(mContext);
        this.mList = mList;
        this.tech = tech;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_tech, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (tech.equals(GankMainFragment.tabTitle[0])) {

            ((ViewHolder) holder).mIvTechIcon.setImageResource(R.mipmap.ic_android);

        } else if (tech.equals(GankMainFragment.tabTitle[1])) {

            ((ViewHolder) holder).mIvTechIcon.setImageResource(R.mipmap.ic_ios);

        } else if (tech.equals(GankMainFragment.tabTitle[2])) {

            ((ViewHolder) holder).mIvTechIcon.setImageResource(R.mipmap.ic_web);

        }

        ((ViewHolder) holder).mTvTechTitle.setText(mList.get(position).getDesc());
        ((ViewHolder) holder).mTvTechAuthor.setText(mList.get(position).getWho());
        ((ViewHolder) holder).mTvTechTime.setText(DateUtil.formatDateTime(DateUtil.subStandardTime(mList.get(position).getPublishedAt()), true));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_tech_icon)
        ImageView mIvTechIcon;
        @BindView(R.id.tv_tech_title)
        TextView mTvTechTitle;
        @BindView(R.id.tv_tech_author)
        TextView mTvTechAuthor;
        @BindView(R.id.tv_tech_time)
        TextView mTvTechTime;
        @BindView(R.id.cv_tech_content)
        CardView mCvTechContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
