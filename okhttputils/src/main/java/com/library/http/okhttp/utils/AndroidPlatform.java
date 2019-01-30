package com.library.http.okhttp.utils;


import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 *
 * @author kongminghui
 * @date 2018/5/18
 */

public class AndroidPlatform extends Platform {
    @Override
    public Executor defaultCallbackExecutor() {
        return new MainThreadExecutor();
    }
    private static class MainThreadExecutor implements Executor {
        private final Handler handler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable r) {
            handler.post(r);
        }
    }
}
