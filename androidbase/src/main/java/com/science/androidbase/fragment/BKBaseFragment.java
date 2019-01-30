package com.science.androidbase.fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public abstract class BKBaseFragment extends BaseFragment {

    private Unbinder unbinder;

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this, mRootView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
