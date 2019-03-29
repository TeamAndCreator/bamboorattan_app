package com.science.bamboorattan.frame.activity.mo;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.science.androidbase.mvp.Task;
import com.science.androidbase.mvp.TaskType;
import com.science.androidbase.utils.PreferencesUtils;
import com.science.bamboorattan.R;
import com.science.bamboorattan.adapter.MeAdapter;
import com.science.bamboorattan.bean.KeyValueBean;
import com.science.bamboorattan.common.PresenterFactory;
import com.science.bamboorattan.frame.activity.mo.activity.LoginActivity;
import com.science.bamboorattan.frame.activity.mo.constant.GlobalConstants;
import com.science.bamboorattan.frame.fragment.ABaseFragment;
import com.science.bamboorattan.listener.OnItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalFragment extends ABaseFragment {

    private TextView toolbarTitle;
    private Toolbar toolbar;
    private View fakeStatusBar;
    private TextView toolbarHelp;
    private UltimateRecyclerView recyclerView;
    private MeAdapter mAdapter;
    private List<KeyValueBean> mData = new ArrayList<>();


    @Override
    protected void initData() {
        fakeStatusBar.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        toolbarTitle.setText(mContext.getString(R.string.me));
        initUltimateRV();
        getUserInfo();
    }

    @Override
    protected void initEvent() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                if (position == mData.size() - 2) {
                    logout();
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
    }

    @Override
    protected void initView() {
        toolbarTitle = mRootView.findViewById(R.id.toolbar_title);
        toolbar = mRootView.findViewById(R.id.toolbar);
        fakeStatusBar = mRootView.findViewById(R.id.fake_status_bar);
        recyclerView = mRootView.findViewById(R.id.ultimate_recycler_view);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.zhu;
    }

    private void initUltimateRV() {
        recyclerView.setHasFixedSize(false);
        mAdapter = new MeAdapter(mData, R.layout.item_me);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onSuccess(String result, int page, Integer actionType) {
        if (actionType == 0) {

            List<KeyValueBean> userInfo = getValidArray(result);
            mData.clear();
            mData.addAll(userInfo);
            mAdapter.notifyDataSetChanged();
        } else {
            if (getActivity() != null) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }

        }
    }

    @Override
    public void onFailure(String error, int page, Integer actionType) {
        if (getActivity() != null) {
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    private void logout() {
        PreferencesUtils.putBoolean(mContext, GlobalConstants.SP_USER_LOGGED_ON,
                false);
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.GET)
                        .setUrl(GlobalConstants.USER_LOGOUT)
                        .setPage(1)
                        .setActionType(1)
                        .createTask());
    }

    private void getUserInfo() {
        String userparam = PreferencesUtils.getString(super.mContext,GlobalConstants.SP_USER_NAME);
        String  url = GlobalConstants.USER_INFO + userparam;
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.GET)
                        .setUrl(url)
                        .setPage(1)
                        .setActionType(0)
                        .createTask());
    }

    private List<KeyValueBean> getValidArray(String msg) {
        JSONObject user = JSON.parseObject(msg);
        String message = user.getString("data");
        List<KeyValueBean> userInfo = new ArrayList<>();
        JSONObject jsonObject = JSON.parseObject(message);

        userInfo.add(new KeyValueBean().setTitle("登录账号：").setValue(jsonObject.getString("userAcct")));
        userInfo.add(new KeyValueBean().setTitle("用户姓名：").setValue(jsonObject.getString("userName")));
        userInfo.add(new KeyValueBean().setTitle("所在部门：").setValue(jsonObject.getString("orgName")));
        userInfo.add(new KeyValueBean().setTitle("办公室电话：").setValue(jsonObject.getString("orgPhone")));
        userInfo.add(new KeyValueBean().setTitle("清除缓存"));
        userInfo.add(new KeyValueBean().setTitle("退出登录"));
        userInfo.add(new KeyValueBean().setTitle("关于我们"));
        return userInfo;

    }
}