package com.science.bamboorattan.frame.activity.mo.activity;

import android.content.Intent;

import com.science.androidbase.mvp.Task;
import com.science.androidbase.mvp.TaskType;
import com.science.androidbase.utils.GsonUtils;
import com.science.androidbase.utils.LogUtils;
import com.science.androidbase.utils.PreferencesUtils;
import com.science.androidbase.utils.TextUtils;
import com.science.bamboorattan.R;
import com.science.bamboorattan.common.PresenterFactory;
import com.science.bamboorattan.frame.activity.ABaseActivity;
import com.science.bamboorattan.frame.activity.mo.bean.ResultBean;
import com.science.bamboorattan.frame.activity.mo.constant.GlobalConstants;

import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends ABaseActivity {

    private void startFirstActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash2;
    }

    @Override
    protected void initData() {
        boolean loggedOn = PreferencesUtils.getBoolean(this, GlobalConstants.SP_USER_LOGGED_ON,
                false);
        if (!loggedOn) {
            startFirstActivity(LoginActivity.class);
            return;
        }
        String username = PreferencesUtils.getString(this, GlobalConstants.SP_USER_NAME, "");
        String password = PreferencesUtils.getString(this, GlobalConstants.SP_PASSWORD, "");
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            startFirstActivity(LoginActivity.class);
            return;
        }
        doLogin(username, password);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onSuccess(String result, int page, Integer actionType) {
        LogUtils.d(TAG, "respose is" + result);
        if (TextUtils.isEmpty(result)) {
            return;
        }
        ResultBean bean = GsonUtils.getInstance().transitionToBean(result, ResultBean.class);
        if (bean == null) {
            return;
        }
        if (bean.getStatusCode() == 200) {
            PreferencesUtils.putBoolean(this, GlobalConstants.SP_USER_LOGGED_ON,
                    true);
            startFirstActivity(MainActivity.class);
        }
    }

    private void doLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("userAcct", username);
        params.put("userPwd", password);
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.POST)
                        .setUrl(GlobalConstants.USER_LOGIN)
                        .setParams(params)
                        .setPage(1)
                        .setActionType(0)
                        .createTask());
    }
}
