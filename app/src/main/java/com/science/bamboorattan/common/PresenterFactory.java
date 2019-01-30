package com.science.bamboorattan.common;

import com.science.androidbase.mvp.IPresenter;
import com.science.androidbase.mvp.IView;
import com.science.bamboorattan.frame.presenter.Presenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by administrator on 21/6/16.
 */
public class PresenterFactory {
    //Volatile是轻量级的synchronized
    private static volatile PresenterFactory singleton = null;
    private Map<IView, IPresenter> mPresenterMap = null;

    private PresenterFactory() {
        this.mPresenterMap = new HashMap<>();
    }

    public static PresenterFactory getInstance() {
        if (singleton == null) {
            synchronized (PresenterFactory.class) {
                if (singleton == null) {
                    singleton = new PresenterFactory();
                }
            }
        }
        return singleton;
    }

    private void putPresenter(IView v, IPresenter p) {
        mPresenterMap.put(v, p);
    }

    public IPresenter createPresenter(IView v) {
        IPresenter presenter = mPresenterMap.get(v);
        if (presenter == null) {
            presenter = new Presenter(v);
            putPresenter(v, presenter);
        }
        return presenter;
    }

    public void remove(IView v) {
        if (mPresenterMap.containsKey(v)) {
            IPresenter mPresenter = mPresenterMap.get(v);
            mPresenterMap.remove(v);
            mPresenter.detachView();
            mPresenter.detachContext();
            mPresenter.detachHandler();
            mPresenter.cancelByTag(v);
        }
    }
}