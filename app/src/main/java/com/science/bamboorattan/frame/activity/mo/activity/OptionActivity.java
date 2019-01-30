package com.science.bamboorattan.frame.activity.mo.activity;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.science.bamboorattan.R;
import com.science.bamboorattan.frame.activity.ABaseActivity;
import com.science.bamboorattan.frame.activity.mo.adapter.OptionAdapter;
import com.science.bamboorattan.frame.activity.mo.bean.CatalogBean;
import com.science.bamboorattan.frame.activity.mo.util.Table;
import com.science.bamboorattan.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class OptionActivity extends ABaseActivity {

    private RecyclerView mRecyclerview;
    private Toolbar mTooblBar;
    private TextView mTitleTv;
    private AppCompatButton mNextBtn;
    private OptionAdapter mAdapter;
    private List<CatalogBean> mSelection = new ArrayList<>();
    private int mType;
    private Table mCatalog;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_option;
    }

    @Override
    protected void initData() {
        setSupportActionBar(mTooblBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        if (mType == 0) {
            mTitleTv.setText("形态信息采集");
            mCatalog = Table.UNDERSTEM;
        } else {
            mTitleTv.setText("材性信息采集");
            mCatalog = Table.STRUCTURE;
        }
        getCatalogList();
        mAdapter = new OptionAdapter(this, R.layout.item_option);
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager
                .VERTICAL, false));
//        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager
//                .VERTICAL, false));
        mAdapter.add(0, mSelection.size(), mSelection);
    }


    private void getCatalogList() {
        mSelection.clear();
        if (mType == 1) {
            mSelection.add(new CatalogBean().setCatalogName("结构性质表添加").setTable(Table.STRUCTURE));
            mSelection.add(new CatalogBean().setCatalogName("物理性质表添加").setTable(Table.PHYSICS));
            mSelection.add(new CatalogBean().setCatalogName("化学性质表添加").setTable(Table.CHEMISTRY));
            mSelection.add(new CatalogBean().setCatalogName("力学性质表添加").setTable(Table.MECHANICS));
            mSelection.add(new CatalogBean().setCatalogName("导管形态表添加").setTable(Table
                    .CATHETERMORPHOLOGY));
            mSelection.add(new CatalogBean().setCatalogName("维管束形态表添加").setTable(Table
                    .VASCULARBUNDLEMORPHOLOGY));
            mSelection.add(new CatalogBean().setCatalogName("组织比量表添加").setTable(Table
                    .TISSUEPROPORTION));
            mSelection.add(new CatalogBean().setCatalogName("纤维形态表添加").setTable(Table
                    .FIBERMORPHOLOGY));
        } else {
            mSelection.add(new CatalogBean().setCatalogName("地下茎表添加").setTable(Table.UNDERSTEM));
            mSelection.add(new CatalogBean().setCatalogName("竹秆表添加").setTable(Table.CULM));
            mSelection.add(new CatalogBean().setCatalogName("竹叶表添加").setTable(Table.LEAF));
            mSelection.add(new CatalogBean().setCatalogName("箨环表添加").setTable(Table.SHEATHNODE));
            mSelection.add(new CatalogBean().setCatalogName("箨鞘表添加").setTable(Table.SHEATH));
            mSelection.add(new CatalogBean().setCatalogName("箨耳表添加").setTable(Table.SHEATHEAR));
            mSelection.add(new CatalogBean().setCatalogName("箨舌表添加").setTable(Table.SHEATHTONGUE));
            mSelection.add(new CatalogBean().setCatalogName("箨片表添加").setTable(Table.SHEATHSHELL));
            mSelection.add(new CatalogBean().setCatalogName("花果形态表添加").setTable(Table.FLOWERFRUIT));
        }
    }

    @Override
    protected void getExtraParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        mType = intent.getIntExtra("type", 0);
    }

    @Override
    protected void initEvent() {
        mTooblBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                if (o instanceof CatalogBean) {
                    mCatalog = ((CatalogBean) o).getTable();
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCatalog == null) {
                    return;
                }
                Intent intent = new Intent(OptionActivity.this, BambooInfoCollectActivity.class);
                intent.putExtra("catalog", mCatalog);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        mTooblBar = findViewById(R.id.toolbar);
        mTitleTv = findViewById(R.id.toolbar_title_mid);
        mRecyclerview = findViewById(R.id.recyclerview);
        mNextBtn = findViewById(R.id.btn_next);
    }

    @Override
    public void onSuccess(String result, int page, Integer actionType) {

    }

}
