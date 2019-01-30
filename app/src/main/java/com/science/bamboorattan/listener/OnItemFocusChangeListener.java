package com.science.bamboorattan.listener;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/25.
 * @param <T>
 */
public interface OnItemFocusChangeListener<T> {

    /**1. 接口类中的方法和属性不要加任何修饰符（public 也不要加），保持代码的简洁性，并加上有效的Javadoc注释。
     * 2. 尽量不要在接口里定义变量，如果一定要定义变量，肯定是与接口方法，并且是整个应用的基础变量。
     * 3. 所有的抽象方法(包括接口中的方法)必须用Javadoc注释、除了返回值、参数、异常说明外，还必须指出该方法做了什么事情，实现什么功能
     * @param parent p
     * @param view v
     * @param t t
     * @param position p
     * @param hasFocus h
     */
    void onItemFocusChanged(ViewGroup parent, View view, T t, int position, boolean hasFocus);

}
