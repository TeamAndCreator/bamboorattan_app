package com.science.bamboorattan.frame.activity.mo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.science.bamboorattan.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class RegisterActivity extends Activity {
    EditText username, name, depatment, phone;
    EditText password;
    String usename, pass, nam, depatmen, phon;
    private Handler handler = null;
    private Button back;
    private int flag = 0;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        findViews();
        handler = new Handler();
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().trim().isEmpty() || password.getText().toString
                        ().trim().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();
                } else {
                    usename = username.getText().toString().trim();
                    pass = password.getText().toString().trim();
                    nam = name.getText().toString().trim();
                    depatmen = depatment.getText().toString().trim();
                    phon = phone.getText().toString().trim();
                    register();
                }
            }
        });
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    private void findViews() {
        username = (EditText) findViewById(R.id.usernameRegister);
        password = (EditText) findViewById(R.id.passwordRegister);
        name = (EditText) findViewById(R.id.nameRegister);
        depatment = (EditText) findViewById(R.id.depatmentRegister);
        phone = (EditText) findViewById(R.id.phoneRegister);
        register = (Button) findViewById(R.id.Register);
        back = (Button) findViewById(R.id.back);
    }

    //��¼
    //��¼
    public void register() {

        Thread t = new Thread() {
            @Override
            public void run() {
                String target = "http://47.106.74.107/bamboorattan/app/anno/doRegister";
                URL url;
                try {
                    url = new URL(target);
                    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                    urlConn.setRequestMethod("POST");
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setInstanceFollowRedirects(true);
                    urlConn.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");
                    DataOutputStream out = new DataOutputStream(
                            urlConn.getOutputStream());
                    String param = "userAcct="
                            + URLEncoder.encode(usename, "utf-8")
                            + "&userPwd="
                            + URLEncoder.encode(pass, "utf-8")
                            + "&userName="
                            + URLEncoder.encode(nam, "utf-8")
                            + "&orgName="
                            + URLEncoder.encode(depatmen, "utf-8")
                            + "&orgPhone="
                            + URLEncoder.encode(phon, "utf-8");
                    out.writeBytes(param);
                    out.flush();
                    out.close();

                    if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStreamReader in = new InputStreamReader(
                                urlConn.getInputStream());
                        BufferedReader buffer = new BufferedReader(in);
                        String inputLine = null;
                        while ((inputLine = buffer.readLine()) != null) {
                            String result = inputLine + "\n";
                            JSONObject jsonObject1 = new JSONObject(result);
                            String success2 = jsonObject1.optString("statusCode");
                            String success = jsonObject1.optString("message");
                            if (success2.equals("200")) {
                                flag = 1;
                                handler.post(runnableUi);
                            } else {
                                Looper.prepare();
                                Toast.makeText(RegisterActivity.this, success, Toast
                                        .LENGTH_SHORT).show();
                                Looper.loop();
                            }
                        }
                        in.close();
                    } else {
                        Log.d("test", "code=" + urlConn.getResponseCode());
                    }
                    urlConn.disconnect();
                } catch (MalformedURLException e) {
                    Log.d("test", e.getMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.d("test", e.getMessage());
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    Runnable runnableUi = new Runnable() {

        @Override
        public void run() {

            if (flag == 1) {
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }
    };

}
