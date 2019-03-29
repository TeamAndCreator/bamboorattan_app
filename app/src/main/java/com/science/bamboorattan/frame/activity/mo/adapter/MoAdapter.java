package com.science.bamboorattan.frame.activity.mo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.science.bamboorattan.R;
import com.science.bamboorattan.adapter.UAdapter;
import com.science.bamboorattan.bean.SpecListBean;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

import java.util.List;

/**
 * author: Administrator
 * date: 2017/2/23 002310:47.
 * email:looper@126.com
 */

public class MoAdapter extends UAdapter<SpecListBean> {

    public MoAdapter(List<SpecListBean> data, int layoutId) {
        super(data, layoutId);
    }

    @Override
    public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new MeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        super.onBindViewHolder(holder, position);
        if (bp && holder instanceof MeViewHolder) {
            SpecListBean content = mData.get((hasHeaderView() ? position - 1 : position));
            if (content == null) {
                return;
            }
            MeViewHolder viewHolder = (MeViewHolder) holder;
            viewHolder.tvTitle.setText(content.getSpecNameCh());
        }
    }


    private class MeViewHolder extends UltimateRecyclerviewViewHolder {

        public TextView tvTitle;
        public TextView tvValue;
        public View line;
        public View space;

        public MeViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvValue = (TextView) itemView.findViewById(R.id.tv_value);
            line = itemView.findViewById(R.id.line);
            space = itemView.findViewById(R.id.space);
        }
    }
}
