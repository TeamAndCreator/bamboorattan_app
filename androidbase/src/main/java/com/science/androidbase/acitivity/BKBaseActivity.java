package com.science.androidbase.acitivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: Administrator
 * date: 2017/2/20 002010:08.
 * email:looper@126.com
 */

public abstract class BKBaseActivity extends BaseActivity {

    private Unbinder unbinder;
    /**
     * 将initView()方法声明为final,不允许子类对该方法进行覆写已防止子类未调用super.initView()方法对view控件进行绑定
     */
    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
