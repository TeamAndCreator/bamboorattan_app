package com.science.bamboorattan.listener;

import android.view.View;
import android.view.ViewGroup;

public interface OnItemClickListener<T>
{
    /**
     * @param parent p
     * @param view v
     * @param t t
     * @param position p
     */
    void onItemClick(ViewGroup parent, View view, T t, int position);

    /**
     * @param parent p
     * @param view v
     * @param t t
     * @param position p
     * @return b
     */
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}