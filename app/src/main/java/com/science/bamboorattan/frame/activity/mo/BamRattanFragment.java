package com.science.bamboorattan.frame.activity.mo;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.science.androidbase.mvp.Task;
import com.science.androidbase.mvp.TaskType;
import com.science.androidbase.utils.TextUtils;
import com.science.bamboorattan.R;
import com.science.bamboorattan.bean.SpecListBean;
import com.science.bamboorattan.common.PresenterFactory;
import com.science.bamboorattan.frame.activity.mo.activity.DetailActivity;
import com.science.bamboorattan.frame.activity.mo.adapter.MoAdapter;
import com.science.bamboorattan.frame.activity.mo.constant.GlobalConstants;
import com.science.bamboorattan.frame.fragment.ABaseFragment;
import com.science.bamboorattan.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 */
public class BamRattanFragment extends ABaseFragment {
    private TextView toolbarTitle;
    private Toolbar toolbar;
    private View fakeStatusBar;
    private TextView toolbarHelp;
    private UltimateRecyclerView recyclerView;
    private MoAdapter mAdapter;
    private List<SpecListBean> mData = new ArrayList<>();
    private SearchView mSearchView;


    @Override
    protected void initData() {
        fakeStatusBar.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        toolbarTitle.setText("竹藤检索");
        initUltimateRV();
    }

    @Override
    protected void initEvent() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {

                if (o instanceof SpecListBean) {
                    SpecListBean bean = (SpecListBean) o;
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("bean", bean);
                    startActivity(intent);
                }

            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });

//        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            // 当点击搜索按钮时触发该方法
//            @Override
//            public boolean onQueryTextSubmit(String query) {
////                mSearchView.setIconified(true);
//                return false;
//            }
//
//            // 当搜索内容改变时触发该方法
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                doSearch(newText);
//                GlobalConstants.SEARCHTEXT = newText;
//                for (int i=0;i<mData.size();i++){
//                    if (mData.get(i).getSpecName()!=GlobalConstants.SEARCHTEXT)
//                    {}
//                }
//                mAdapter.notifyDataSetChanged();
//                return false;
//            }
//        });
    }

    @Override
    protected void initView() {
        toolbarTitle = mRootView.findViewById(R.id.toolbar_title);
        toolbar = mRootView.findViewById(R.id.toolbar);
        fakeStatusBar = mRootView.findViewById(R.id.fake_status_bar);
        recyclerView = mRootView.findViewById(R.id.ultimate_recycler_view);
        mSearchView = mRootView.findViewById(R.id.searchView);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.me;
    }

    private void initUltimateRV() {
        recyclerView.setHasFixedSize(false);
        mAdapter = new MoAdapter(mData, R.layout.item_mo);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        getSpecList();
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


    @Override
    public void onSuccess(String result, int page, Integer actionType) {
        List<SpecListBean> beans = new LinkedList<>();
        List<SpecListBean> specListBean = null;
        try {
            specListBean = getSpecList(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (specListBean != null) {
            for (SpecListBean bean : specListBean) {
                if (bean != null) {
                    beans.add(bean);
                }
            }
        }
        mData.clear();
        mData.addAll(beans);
        mAdapter.notifyDataSetChanged();
    }

    private List<SpecListBean> getSpecList(String result) throws Exception {

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

//    public void doSearch(String newText){
//        SpecListBean bean = new SpecListBean();
//
//    }


}
