package com.science.bamboorattan.frame.activity.mo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.science.bamboorattan.R;
import com.science.bamboorattan.adapter.RecyclerViewAdapter;
import com.science.bamboorattan.adapter.ViewHolder;
import com.science.bamboorattan.frame.activity.mo.bean.CatalogBean;

/**
 * @author Admin
 * @date 2017/4/7
 */

public class OptionAdapter extends RecyclerViewAdapter<CatalogBean> {

    private View mCurrent;

    public OptionAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, CatalogBean catalogBean) {
        if (catalogBean == null) {
            return;
        }
        if (holder.getLayoutPosition() == 0) {
            mCurrent = holder.getConvertView();
            setFocusView(mCurrent);
        }
        holder.setText(R.id.tv_title, catalogBean.getCatalogName());

    }

    private void setFocusView(View view) {
        if (view == null) {
            return;
        }
        view.setBackgroundResource(R.drawable.data_flow_item_focus_bg);
        ((TextView) view.findViewById(R.id.tv_price)).setTextColor(mCurrent
                .getResources()
                .getColor(R.color.white));
        ((TextView) view.findViewById(R.id.tv_title)).setTextColor(mCurrent
                .getResources()
                .getColor(R.color.white));
    }

    private void resetView() {
        if (mCurrent == null) {
            return;
        }
        mCurrent.setBackgroundResource(R.drawable.data_flow_item_normal_bg);
        ((TextView) mCurrent.findViewById(R.id.tv_price)).setTextColor
                (mContext.getResources()
                        .getColor(R.color.data_flow_item_price_text_color));
        ((TextView) mCurrent.findViewById(R.id.tv_title)).setTextColor
                (mCurrent.getResources().getColor(R.color.user_account_color));
    }

    @Override
    protected void setOnListener(final ViewGroup parent, final ViewHolder viewHolder, int
            viewType) {

        if (isClickEnabled(viewType)) {
            viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        int position = getPosition(viewHolder);
                        resetView();
                        setFocusView(v);
                        mCurrent = v;
                        mOnItemClickListener.onItemClick(parent, v, mDatas.get(position), position);
                    }
                }
            });

            viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mOnItemClickListener != null) {
                        int position = getPosition(viewHolder);
                        return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get
                                (position), position);
                    }
                    return false;
                }
            });
        }

        if (isFoucusEnabled(viewType)) {
            viewHolder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (mOnItemFocusChangeListener != null) {
                        int position = getPosition(viewHolder);
                        mOnItemFocusChangeListener.onItemFocusChanged(parent, v, mDatas.get
                                (position), position, hasFocus);
                    }
                }
            });
        }
    }
}
