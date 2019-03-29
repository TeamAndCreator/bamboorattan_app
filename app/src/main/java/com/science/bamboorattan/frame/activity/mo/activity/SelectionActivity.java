package com.science.bamboorattan.frame.activity.mo.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.science.androidbase.mvp.Task;
import com.science.androidbase.mvp.TaskType;
import com.science.bamboorattan.R;
import com.science.bamboorattan.bean.GenusListBean;
import com.science.bamboorattan.bean.SpecListBean;
import com.science.bamboorattan.bean.RattanGenusListBean;
import com.science.bamboorattan.bean.RattanSpecListBean;
import com.science.bamboorattan.common.PresenterFactory;
import com.science.bamboorattan.frame.activity.ABaseActivity;
import com.science.bamboorattan.frame.activity.mo.adapter.CatalogAdapter;
import com.science.bamboorattan.frame.activity.mo.bean.CatalogBean;
import com.science.bamboorattan.frame.activity.mo.constant.GlobalConstants;
import com.science.bamboorattan.frame.activity.mo.util.Table;
import com.science.bamboorattan.frame.activity.mo.util.TableUtil;
import com.science.bamboorattan.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SelectionActivity extends ABaseActivity {

    private static final int SELECT_RESULT_CODE = 0X0011;
    private RecyclerView mRecyclerview;
    private Toolbar mTooblBar;
    private TextView mTitleTv;
    private CatalogAdapter mAdapter;
    private List<CatalogBean> mSelection = new ArrayList<>();
    private Table mCatalog;
    private String mCatalogValue;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_selection;
    }

    @Override
    protected void initView() {

        mTooblBar = findViewById(R.id.toolbar);
        mTitleTv = findViewById(R.id.toolbar_title_mid);
        mRecyclerview = findViewById(R.id.recyclerview);
    }

    @Override
    protected void initData() {
        setSupportActionBar(mTooblBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        String tableName = TableUtil.getTableName(mCatalog);
        if (mCatalog != null) {
            if (mCatalog == Table.SPEC) {//竹种和藤种添加
                mTitleTv.setText("选择竹属");
                getGenusList();
            }else if(mCatalog == Table.TSPEC){
                mTitleTv.setText("选择藤属");
                getRattanGenusList();
            } else {
                if (tableName.contains("藤")){//形态信息和材性信息采集
                    mTitleTv.setText("选择藤种");
                    getRattanSpecList();
                }else{
                    mTitleTv.setText("选择竹种");
                    getSpecList();
                }
            }
        }
        mAdapter = new CatalogAdapter(this, R.layout.item_selection);
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager
                .VERTICAL, false));

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
                    String name = ((CatalogBean) o).getCatalogName();
                    String id = ((CatalogBean) o).getId();
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("id", id);
                    setResult(SELECT_RESULT_CODE, intent);
                    finish();
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });

    }

    @Override
    protected void getExtraParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        mCatalog = (Table) intent.getSerializableExtra("catalog");
        mCatalogValue = intent.getStringExtra("catalogValue");
    }

    @Override
    public void onSuccess(String result, int page, Integer actionType) {
        Logger.d("SelectionActivity", result);
        mSelection.clear();
        String tableName = TableUtil.getTableName(mCatalog);
        if (mCatalog!=null) {
            if (actionType == 0) {
                if (mCatalog == Table.SPEC){
                    List<GenusListBean> genusListBean = null;
                    try {
                        genusListBean = getGenusList(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (genusListBean != null) {
                        for (GenusListBean bean : genusListBean) {
                            if (bean != null) {
                                mSelection.add(new CatalogBean()
                                        .setCatalogName(bean.getGenusNameCh())
                                        .setId(bean.getId()));
                            }
                        }
                    }
                }else {
                    List<RattanGenusListBean> rattanGenusListBean = null;
                    try {
                        rattanGenusListBean = getRattanGenusList(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (rattanGenusListBean != null) {
                        for (RattanGenusListBean bean : rattanGenusListBean) {
                            if (bean != null) {
                                mSelection.add(new CatalogBean()
                                        .setCatalogName(bean.getGenusNameCh())
                                        .setId(bean.getId()));
                            }
                        }
                    }
                }

            } else {
                if (tableName.contains("藤")){
                    List<RattanSpecListBean> rattanSpecListBean = null;
                    try {
                        rattanSpecListBean = getRattanSpecList(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (rattanSpecListBean != null) {
                        for (RattanSpecListBean bean : rattanSpecListBean) {
                            if (bean != null) {
                                mSelection.add(new CatalogBean().setCatalogName(bean.getSpecNameCh())
                                        .setId(bean.getId()));
                            }
                        }
                    }
                }else{
                    List<SpecListBean> specListBean = null;
                    try {
                        specListBean = getSpecList(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (specListBean != null) {
                        for (SpecListBean bean : specListBean) {
                            if (bean != null) {
                                mSelection.add(new CatalogBean().setCatalogName(bean.getSpecNameCh())
                                        .setId(bean.getId()));
                            }
                        }
                    }
                }


            }
        }

        for (CatalogBean catalogBean : mSelection) {
            if (catalogBean.getCatalogName().equals(mCatalogValue)) {
                catalogBean.setSelected(true);
            }
        }
        mAdapter.add(0, mSelection.size(), mSelection);

    }


    private void getGenusList() {
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.GET)
                        .setUrl(GlobalConstants.GET_GENUS_LIST)
                        .setPage(1)
                        .setActionType(0)
                        .createTask());
    }

    private void getSpecList() {
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.GET)
                        .setUrl(GlobalConstants.GET_SPEC_LIST)
                        .setPage(1)
                        .setActionType(1)
                        .createTask());
    }


    private List<GenusListBean> getGenusList(String result) throws Exception{

        Gson gson = new Gson();
        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        ArrayList<GenusListBean> genusListBeans = new ArrayList<>();

        for (Object genus : jsonArray) {
            GenusListBean bean = gson.fromJson(String.valueOf(genus), GenusListBean.class);
            genusListBeans.add(bean);
        }
        return genusListBeans;
    }

    private List<SpecListBean> getSpecList(String result) throws Exception{

        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        Gson gson = new Gson();
        ArrayList<SpecListBean> specListBeans = new ArrayList<>();

        for (Object genus : jsonArray) {
            SpecListBean bean = gson.fromJson(String.valueOf(genus), SpecListBean.class);
            specListBeans.add(bean);
        }
        return specListBeans;
    }

    private void getRattanGenusList() {
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.GET)
                        .setUrl(GlobalConstants.GET_RATTANGENUS_LIST)
                        .setPage(1)
                        .setActionType(0)
                        .createTask());
    }

    private void getRattanSpecList() {
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.GET)
                        .setUrl(GlobalConstants.GET_RATTANSPEC_LIST)
                        .setPage(1)
                        .setActionType(1)
                        .createTask());
    }


    private List<RattanGenusListBean> getRattanGenusList(String result) throws Exception{

        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        Gson gson = new Gson();
        ArrayList<RattanGenusListBean> rattanGenusListBeans = new ArrayList<>();

        for (Object genus : jsonArray) {
            RattanGenusListBean bean = gson.fromJson(String.valueOf(genus), RattanGenusListBean.class);
            rattanGenusListBeans.add(bean);
        }
        return rattanGenusListBeans;
    }

    private List<RattanSpecListBean> getRattanSpecList(String result) throws Exception{

        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        Gson gson = new Gson();
        ArrayList<RattanSpecListBean> rattanSpecListBeans = new ArrayList<>();

        for (Object genus : jsonArray) {
            RattanSpecListBean bean = gson.fromJson(String.valueOf(genus), RattanSpecListBean.class);
            rattanSpecListBeans.add(bean);
        }
        return rattanSpecListBeans;
    }
}
