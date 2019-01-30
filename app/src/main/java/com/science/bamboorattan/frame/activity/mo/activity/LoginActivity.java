package com.science.bamboorattan.frame.activity.mo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class LoginActivity extends ABaseActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private String mUserName;
    private String mPassword;

    @Override
    protected int getContentViewId() {
        return R.layout.login;
    }

    @Override
    protected void initView() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.register);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    private void handleLogin() {
        mUserName = username.getText().toString().trim();
        mPassword = password.getText().toString().trim();
        doLogin(mUserName, mPassword);
    }

    private void doLogin(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "请输入用户名或密码", Toast.LENGTH_LONG).show();
            return;
        }
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
            PreferencesUtils.putString(this, GlobalConstants.SP_USER_NAME, mUserName);
            PreferencesUtils.putString(this, GlobalConstants.SP_PASSWORD, mPassword);
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
