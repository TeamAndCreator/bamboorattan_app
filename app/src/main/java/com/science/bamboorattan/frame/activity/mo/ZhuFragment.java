package com.science.bamboorattan.frame.activity.mo;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class ZhuFragment extends ABaseFragment {

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
            String s = result.replaceAll("\\s*", "");
            if (s.length() < 20) {
                return;
            }
            List<KeyValueBean> userInfo = getValidArray(s);
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
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.GET)
                        .setUrl(GlobalConstants.USER_INFO)
                        .setPage(1)
                        .setActionType(0)
                        .createTask());
    }

    private List<KeyValueBean> getValidArray(String msg) {
        String reg = "<td>(?:(?!<\\/td>)[\\s\\S])*<\\/td>";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(msg);
        String[] arr = new String[0];
        while (m.find()) {
            String[] dst = new String[arr.length + 1];
            System.arraycopy(arr, 0, dst, 0, arr.length);
            dst[dst.length - 1] = m.group();
            arr = dst;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println("index=" + i + ",value=" + arr[i]);
        }

        List<KeyValueBean> userInfo = new ArrayList<>();
        int i = 2;
        while (i <= 4) {
            String key = getValidString(arr[i]);
            String value = getValidString(arr[i + 1]);
            userInfo.add(new KeyValueBean().setTitle(key).setValue(value));
            i += 2;
        }
        for (int j = arr.length - 4; j < arr.length; ) {
            String key = getValidString(arr[j]);
            String value = getValidString(arr[j + 1]);
            userInfo.add(new KeyValueBean().setTitle(key).setValue(value));
            j += 2;
        }
        userInfo.add(new KeyValueBean().setTitle("清除缓存"));
        userInfo.add(new KeyValueBean().setTitle("退出登录"));
        userInfo.add(new KeyValueBean().setTitle("关于我们"));
        return userInfo;

    }

    private String getValidString(String el) {
        return el.replace("<td>", "").replace("</td>", "");
    }
}