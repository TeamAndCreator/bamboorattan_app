package com.science.androidbase.mvp;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2016/6/20.
 */

//在MVP模式中，IPresenter代表业务逻辑的抽象，有多种具体的实现，方便进行单元测试
public interface IPresenter {

    void attachView(@NonNull IView view);
    void attachContext(@NonNull Context context);
    IView getView();
    Context getContext();
    boolean isViewAttached();
    boolean isContextAttached();
    void detachView();
    void detachContext();
    void detachHandler();
    void cancelByTag(IView view);
    void execute(@NonNull Task task);
}