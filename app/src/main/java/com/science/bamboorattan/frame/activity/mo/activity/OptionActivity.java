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
            mTitleTv.setText("竹形态信息采集");
            mCatalog = Table.UNDERSTEM;
        } else if (mType ==1){
            mTitleTv.setText("竹材性信息采集");
            mCatalog = Table.STRUCTURE;
        } else if (mType == 2) {
            mTitleTv.setText("藤形态信息采集");
            mCatalog = Table.TUNDERSTEM;
        }else{
            mTitleTv.setText("藤材性信息采集");
            mCatalog = Table.TSTRUCTURE;
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
            mSelection.add(new CatalogBean().setCatalogName("结构性质").setTable(Table.STRUCTURE));
            mSelection.add(new CatalogBean().setCatalogName("物理性质").setTable(Table.PHYSICS));
            mSelection.add(new CatalogBean().setCatalogName("化学性质").setTable(Table.CHEMISTRY));
            mSelection.add(new CatalogBean().setCatalogName("力学性质").setTable(Table.MECHANICS));
            mSelection.add(new CatalogBean().setCatalogName("导管形态").setTable(Table
                    .CATHETERMORPHOLOGY));
            mSelection.add(new CatalogBean().setCatalogName("维管束形态").setTable(Table
                    .VASCULARBUNDLEMORPHOLOGY));
            mSelection.add(new CatalogBean().setCatalogName("组织比量").setTable(Table
                    .TISSUEPROPORTION));
            mSelection.add(new CatalogBean().setCatalogName("纤维形态").setTable(Table
                    .FIBERMORPHOLOGY));
        } else if (mType == 0){
            mSelection.add(new CatalogBean().setCatalogName("地下茎").setTable(Table.UNDERSTEM));
            mSelection.add(new CatalogBean().setCatalogName("竹秆信息").setTable(Table.CULM));
            mSelection.add(new CatalogBean().setCatalogName("竹叶信息").setTable(Table.LEAF));
            mSelection.add(new CatalogBean().setCatalogName("箨环信息").setTable(Table.SHEATHNODE));
            mSelection.add(new CatalogBean().setCatalogName("箨鞘信息").setTable(Table.SHEATH));
            mSelection.add(new CatalogBean().setCatalogName("箨耳信息").setTable(Table.SHEATHEAR));
            mSelection.add(new CatalogBean().setCatalogName("箨舌信息").setTable(Table.SHEATHTONGUE));
            mSelection.add(new CatalogBean().setCatalogName("箨片信息").setTable(Table.SHEATHSHELL));
            mSelection.add(new CatalogBean().setCatalogName("花果形态信息").setTable(Table.FLOWERFRUIT));
        }else if (mType == 3) {
            mSelection.add(new CatalogBean().setCatalogName("藤结构性质").setTable(Table.TSTRUCTURE));
            mSelection.add(new CatalogBean().setCatalogName("藤物理性质").setTable(Table.TPHYSICS));
            mSelection.add(new CatalogBean().setCatalogName("藤化学性质").setTable(Table.TCHEMISTRY));
            mSelection.add(new CatalogBean().setCatalogName("藤力学性质").setTable(Table.TMECHANICS));
            mSelection.add(new CatalogBean().setCatalogName("藤导管形态").setTable(Table
                    .TCATHETERMORPHOLOGY));
            mSelection.add(new CatalogBean().setCatalogName("藤维管束形态").setTable(Table
                    .TVASCULARBUNDLEMORPHOLOGY));
            mSelection.add(new CatalogBean().setCatalogName("藤组织比量").setTable(Table
                    .TTISSUEPROPORTION));
            mSelection.add(new CatalogBean().setCatalogName("藤纤维形态").setTable(Table
                    .TFIBERMORPHOLOGY));
        }else if (mType ==2){
            mSelection.add(new CatalogBean().setCatalogName("藤地下茎").setTable(Table.TUNDERSTEM));
            mSelection.add(new CatalogBean().setCatalogName("藤秆信息").setTable(Table.TCULM));
            mSelection.add(new CatalogBean().setCatalogName("藤叶信息").setTable(Table.TLEAF));
            mSelection.add(new CatalogBean().setCatalogName("藤箨环信息").setTable(Table.TSHEATHNODE));
            mSelection.add(new CatalogBean().setCatalogName("藤箨鞘信息").setTable(Table.TSHEATH));
            mSelection.add(new CatalogBean().setCatalogName("藤箨耳信息").setTable(Table.TSHEATHEAR));
            mSelection.add(new CatalogBean().setCatalogName("藤箨舌信息").setTable(Table.TSHEATHTONGUE));
            mSelection.add(new CatalogBean().setCatalogName("藤箨片信息").setTable(Table.TSHEATHSHELL));
            mSelection.add(new CatalogBean().setCatalogName("藤花果形态信息").setTable(Table.TFLOWERFRUIT));
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

    @Override
    public void initPermission() {

    }

}
