package com.science.bamboorattan.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.science.bamboorattan.R;
import com.science.bamboorattan.bean.KeyValueBean;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

import java.util.List;

/**
 * author: Administrator
 * date: 2017/2/23 002310:47.
 * email:looper@126.com
 */

public class MeAdapter extends UAdapter<KeyValueBean> {

    public MeAdapter(List<KeyValueBean> data, int layoutId) {
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
            KeyValueBean content = mData.get((hasHeaderView() ? position - 1 : position));
            if (content == null) {
                return;
            }
            MeViewHolder viewHolder = (MeViewHolder) holder;
            viewHolder.tvTitle.setText(content.getTitle());
            viewHolder.tvValue.setText(content.getValue());
            switch (content.getTitle()) {
                case "清除缓存":
                    viewHolder.line.setVisibility(View.VISIBLE);
                    break;
                case "关于我们":
                    viewHolder.line.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        }
    }

    private void setVisibility(MeViewHolder holder, boolean visibility) {
        if (!visibility) {
            holder.line.setVisibility(View.GONE);
            holder.space.setVisibility(View.VISIBLE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
            holder.space.setVisibility(View.GONE);
        }
        holder.tvValue.setVisibility(View.GONE);
    }

    private void setCompoundDrawables(MeViewHolder holder, int drawableId) {
        Resources resources = holder.getContext().getResources();
        Drawable mDrawable = resources.getDrawable(drawableId);
        if (mDrawable != null) {
            mDrawable.setBounds(0, 0, mDrawable.getMinimumWidth(),
                    mDrawable.getMinimumHeight());
            holder.tvTitle.setCompoundDrawablePadding(15);
            holder.tvTitle.setCompoundDrawables(mDrawable, null, null, null);
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
