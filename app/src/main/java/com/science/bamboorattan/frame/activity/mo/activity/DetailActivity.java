package com.science.bamboorattan.frame.activity.mo.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.science.bamboorattan.R;
import com.science.bamboorattan.bean.SpecListBean;
import com.science.bamboorattan.frame.activity.ABaseActivity;

public class DetailActivity extends ABaseActivity {


    private Toolbar mTooblBar;
    private TextView mTitleTv;
    private TextView mTvDetail;
    private SpecListBean mBean;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initData() {
        setSupportActionBar(mTooblBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        mTitleTv.setText("竹种详情");
        mTvDetail.setText("中文名称：" + mBean.getSpecNameCh() + "\n" + "所属竹属：" + mBean.getGenusName
                () + "\n" + "英文名称：" + mBean.getSpecNameEn() + "\n" + "拉丁名称：" + mBean
                .getSpecNameLd() + "\n" + "种别名：" + mBean.getSpecNameOth() + "\n" + "国内分布：" +
                mBean.getSpecDomestic() + "\n" + "国外分布：" + mBean.getSpecForeign() + "\n" + "种描述："
                + mBean.getSpecDesc());
    }

    @Override
    protected void initEvent() {
        mTooblBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    @Override
    protected void getExtraParams() {
        mBean = (SpecListBean) getIntent().getSerializableExtra("bean");
    }

    @Override
    protected void initView() {
        mTooblBar = findViewById(R.id.toolbar);
        mTitleTv = findViewById(R.id.toolbar_title_mid);
        mTvDetail = findViewById(R.id.tv_detail);
    }

    @Override
    public void onSuccess(String result, int page, Integer actionType) {

    }
}
