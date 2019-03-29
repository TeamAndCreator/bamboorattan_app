package com.science.bamboorattan.common;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.multidex.MultiDexApplication;

import com.science.androidbase.utils.ProcessUtils;
import com.science.bamboorattan.BuildConfig;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.library.http.okhttp.OkHttpUtils;
import com.library.http.okhttp.https.HttpsUtils;
import com.library.http.okhttp.log.LoggerInterceptor;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import butterknife.ButterKnife;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/10/29 0029.
 * 启用 Dalvik 可执行文件分包输出
 */

public class UApplication extends MultiDexApplication {

    private static UApplication mInstance;
    private UBroadcastReceiver mUBroadcastReceiver;

    public static UApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();
    }

    private void init() {
        initUShare();//初始化友盟社会化分享
        if (isAppProcess()) {
            initUBroadcastReceiver();//在当前进程注册广播
            initOkHttpUtils();//初始化OkHttp配置
            initUAnalysis();//初始化友盟统计
        }
        initBugly();//初始化Bugly
        initLeakCanary();//初始化LeakCanary
        initButterKnife();//初始化ButterKnife
        initLogger();//初始化Logger
        initAMapLocation();//初始化高德定位
        initJPush();//初始化极光推送
    }

    private void initAMapLocation() {
    }

    private void initUShare() {
    }

    private void initJPush() {
    }

    private void initOkHttpUtils() {
        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new
                SharedPrefsCookiePersistor(getApplicationContext()));
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15 * 1000L, TimeUnit.MILLISECONDS)
                .readTimeout(15 * 1000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("OKHttp", true))
                .cookieJar(cookieJar)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    private void initUAnalysis() {
        MobclickAgent.setCatchUncaughtExceptions(true);
    }

    private boolean isAppProcess() {
        // 获取当前包名
        String packageName = getApplicationContext().getPackageName();
        // 获取当前进程名
        String processName = ProcessUtils.getProcessNameByPid(android.os.Process.myPid());
        Logger.d(processName);
        return (null != processName && processName.equals(packageName));
    }

    private void initBugly() {
        // 获取当前包名
        String packageName = getApplicationContext().getPackageName();
        // 获取当前进程名
        String processName = ProcessUtils.getProcessNameByPid(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        // 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下
        CrashReport.initCrashReport(getApplicationContext(), strategy);
    }

    private void initLeakCanary() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    private void initButterKnife() {
        ButterKnife.setDebug(BuildConfig.DEBUG);
    }

    private void initUBroadcastReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        filter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED);
        mUBroadcastReceiver = new UBroadcastReceiver();
        registerReceiver(mUBroadcastReceiver, filter);
    }

    private void initLogger() {

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not.
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(3)        // (Optional) Skips some method invokes in stack trace.
                .tag("UApplication")   // (Optional) Custom tag for each log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
        {
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                createConfigurationContext(newConfig);
            } else {
                //设置默认
                res.updateConfiguration(newConfig, res.getDisplayMetrics());
            }
        }
        return res;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mUBroadcastReceiver != null) {
            unregisterReceiver(mUBroadcastReceiver);
        }
    }
}
