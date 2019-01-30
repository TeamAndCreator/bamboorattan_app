package com.science.bamboorattan.frame.activity.mo.adapter;

import android.content.Context;

import com.science.bamboorattan.R;
import com.science.bamboorattan.adapter.RecyclerViewAdapter;
import com.science.bamboorattan.adapter.ViewHolder;
import com.science.bamboorattan.frame.activity.mo.bean.CatalogBean;

/**
 * @author Admin
 * @date 2017/4/7
 */

public class CatalogAdapter extends RecyclerViewAdapter<CatalogBean> {


    public CatalogAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, CatalogBean catalogBean) {
        if (catalogBean == null) {
            return;
        }
        holder.setText(R.id.tv_title, catalogBean.getCatalogName());
        if (catalogBean.isSelected()) {
            holder.setVisible(R.id.iv_checked, true);
        }

    }
}
