package com.science.bamboorattan.frame.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.science.androidbase.acitivity.BKBaseActivity;
import com.science.androidbase.mvp.IView;
import com.science.androidbase.utils.StatusBarUtil;
import com.science.androidbase.utils.TextUtils;
import com.science.androidbase.utils.ToastUtils;
import com.science.bamboorattan.R;
import com.science.bamboorattan.common.PresenterFactory;
import com.orhanobut.logger.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Admin
 */
public abstract class ABaseActivity extends BKBaseActivity implements IView<Integer> {

    @Override
    protected void setStatusBarTheme() {
        StatusBarUtil.setColor(ABaseActivity.this, Color.parseColor("#FFFFFF"), 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (isMiUi()) {
            setStatusBarDarkMode(ABaseActivity.this, true);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            FlymeSetStatusBarLightMode(getWindow(), true);
        }
    }

    private static boolean isMiUi() {
        try {
            Class<?> sysClass = Class.forName("android.os.SystemProperties");
            Method getStringMethod = sysClass.getDeclaredMethod("get", String.class);
            String version = (String) getStringMethod.invoke(sysClass, "ro.miui.ui.version" +
                    ".name");
            if (!TextUtils.isEmpty(version)) {
                if (version.contains("V") && version.length() == 2) {
                    int verNum = Integer.parseInt(version.substring(1));
                    if (verNum >= 6) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 需要MIUIV6以上
     *
     * @param activity
     * @param darkMode 是否把状态栏字体及图标颜色设置为深色
     */
    private static void setStatusBarDarkMode(Activity activity, boolean darkMode) {
        Window window = activity.getWindow();
        Class<? extends Window> clazz = window.getClass();
        try {
            int darkModeFlag;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(window, darkMode ? darkModeFlag : 0, darkModeFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置状态栏图标为深色和魅族特定的文字风格，Flyme4.0以上
     * 可以用来判断是否为Flyme用户
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {
                Logger.d(e.toString());
            }
        }
        return result;
    }

    @Override
    protected void getExtraParams() {

    }

    @Override
    protected void setBackground() {
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.app_background);
        this.getWindow().setBackgroundDrawable(drawable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PresenterFactory.getInstance().remove(this);
    }

    @Override
    public void onFailure(String error, int page, Integer actionType) {
        if (TextUtils.isEmpty(error)) {
            return;
        }
        if (error.contains("ConnectException")) {
            ToastUtils.showToast(getApplicationContext(), "网络连接失败，请检查网络设置");
        } else if (error.contains("404")) {
            ToastUtils.showToast(getApplicationContext(), "未知异常");
        } else if (error.contains("SocketTimeoutException")) {
            ToastUtils.showToast(getApplicationContext(), "网络连接超时，请稍后重试");
        } else {
            ToastUtils.showToast(getApplicationContext(), error);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
