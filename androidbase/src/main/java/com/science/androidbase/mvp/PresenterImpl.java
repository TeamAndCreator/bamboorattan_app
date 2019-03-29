package com.science.androidbase.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * Created by Administrator on 2016/6/20.
 */
abstract class PresenterImpl implements IPresenter {

    private Reference<IView> mView = null;//数据请求结果回调
    private Reference<Context> mContext = null;//异步数据请求
    protected Handler mHandler = new Handler(Looper.getMainLooper());

    public PresenterImpl(IView view) {
        attachView(view);
        if (view instanceof Activity) {
            attachContext((Context) view);
        }

        if (view instanceof Fragment) {
            attachContext(((Fragment) view).getContext());
        }
    }

    @Override
    final public void attachContext(@NonNull Context context) {

        mContext = new SoftReference<>(context);
    }

    @Override
    final public boolean isContextAttached() {

        return mContext != null && mContext.get() != null;
    }

    @Override
    final public Context getContext() {
        if (mContext == null) {
            return null;
        }
        return mContext.get();
    }

    @Override
    final public void detachContext() {
        if (mContext != null) {
            mContext.clear();
            mContext = null;
        }
    }

    @Override
    final public void attachView(@NonNull IView view) {
        mView = new SoftReference<>(view);
    }

    @Override
    final public boolean isViewAttached() {

        return mView != null && mView.get() != null;
    }


    @Override
    final public IView getView() {
        if (mView == null) {
            return null;
        }
        return mView.get();
    }

    @Override
    final public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }

    @Override
    final public void detachHandler() {
        if (mHandler != null) {
            mHandler = null;
        }
    }

    final protected boolean isViewDestroyed() {
        return !(isViewAttached() && isContextAttached());
    }
}
