package com.science.bamboorattan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.science.bamboorattan.listener.OnItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.List;

/**
 * Created by Admin on 2017/6/27.
 */

public class UAdapter<T> extends UltimateViewAdapter {

    protected List<T> mData;
    protected int layoutId = -1;
    protected int headerId = -1;
    protected boolean bp;
    protected OnItemClickListener mOnItemClickListener;


    public UAdapter(List<T> data) {
        this.mData = data;
    }

    public UAdapter(List<T> data, int layoutId) {
        this.mData = data;
        this.layoutId = layoutId;
    }

    public UAdapter(List<T> data, int layoutId, int headerId) {
        this.mData = data;
        this.layoutId = layoutId;
        this.headerId = headerId;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder newFooterHolder(View view) {
        return new UltimateRecyclerviewViewHolder<>(view);
    }

    @Override
    public RecyclerView.ViewHolder newHeaderHolder(View view) {
        return new UltimateRecyclerviewViewHolder<>(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        if (layoutId == -1) {
            return null;
        }
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new UltimateRecyclerviewViewHolder(v);
    }

    @Override
    public int getAdapterItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public long generateHeaderId(int position) {
        return -1;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder == null) {
            return;
        }
        //变量index设置为final的原因，可将变量index设为全局变量作为对比
        final int index = (hasHeaderView() ? position - 1 : position);
        if (hasHeaderView()) {
            bp = position <= getAdapterItemCount() && position > 0 && position < getItemCount();
        } else {
            bp = position < getItemCount() && position < getAdapterItemCount();
        }

        if (bp) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        if (index < 0 || index >= mData.size()) {
                            return;
                        }
                        mOnItemClickListener.onItemClick((ViewGroup) v.getParent(), v, mData.get
                                (index), index);
                    }
                }
            });
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        if (headerId == -1) {
            return null;
        }
        View view = LayoutInflater.from(parent.getContext())
                .inflate(headerId, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    public void setOnDragStartListener(OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;
    }

    /**
     * @param item     要插入的数据
     * @param position 要插入的位置
     */
    public void insert(T item, int position) {
        insertInternal(mData, item, position);
    }

    /**
     * @param current 要插入的数据
     */
    public void insert(List<T> current) {
        insertInternal(current, mData);
    }

    public void remove(int position) {
        removeInternal(mData, position);
    }

    public void clear() {
        clearInternal(mData);
    }
}
