package com.science.bamboorattan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.science.bamboorattan.listener.OnItemClickListener;
import com.science.bamboorattan.listener.OnItemFocusChangeListener;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    //click listener
    protected OnItemClickListener mOnItemClickListener;
    //focus listener
    protected OnItemFocusChangeListener mOnItemFocusChangeListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemFocusChangeListener(OnItemFocusChangeListener onItemFocusChangeListener) {

        this.mOnItemFocusChangeListener = onItemFocusChangeListener;
    }

    //重载构造方法
    public RecyclerViewAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    //重载构造方法
    public RecyclerViewAdapter(Context context, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
    }

    // 定义对外开放的添加数据的方法
    public void add(int positionStart, int itemCount,
                    List<T> datas) {
        if (datas == null) {
            return;
        }
        if (mDatas == null) {
            mDatas = datas;
        }
        notifyItemRangeInserted(positionStart, itemCount);
    }

    // 定义对外开放的更新数据的方法
    public void update(int positionStart, int itemCount) {
        notifyItemRangeChanged(positionStart, itemCount);
    }

    // 定义对外开发的删除数据的方法
    public void remove(int positionStart, int itemCount) {
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId, -1);
        setOnListener(parent, viewHolder, viewType);
        return viewHolder;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isClickEnabled(int viewType) {
        return true;
    }

    protected boolean isFoucusEnabled(int viewType) {
        return true;
    }


    protected void setOnListener(final ViewGroup parent, final ViewHolder viewHolder, int
            viewType) {
        if (isClickEnabled(viewType)) {
            viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        int position = getPosition(viewHolder);
                        if (position < mDatas.size() && position >= 0) {
                            mOnItemClickListener.onItemClick(parent, v, mDatas.get(position),
                                    position);
                        }
                    }
                }
            });

            viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mOnItemClickListener != null) {
                        int position = getPosition(viewHolder);
                        if (position < mDatas.size() && position >= 0) {
                            return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get
                                    (position), position);
                        }
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
                        if (position < mDatas.size() && position >= 0) {
                            mOnItemFocusChangeListener.onItemFocusChanged(parent, v, mDatas.get
                                    (position), position, hasFocus);
                        }
                    }
                }
            });
        }


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return (mDatas == null ? 0 : mDatas.size());
    }
}
