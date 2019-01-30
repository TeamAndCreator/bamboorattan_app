package com.science.androidbase.mvp;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

//在MVP模式中,IView层代表了视图逻辑的抽象
public interface IView<T> {

    void  onSuccess(String result, final int page,final T actionType);

    void onFailure(String error, final int page,final T actionType);
}
