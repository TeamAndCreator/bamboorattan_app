package com.library.http.okhttp.utils;

import android.util.Log;

import com.library.http.okhttp.common.ConfigConstants;

/**
 *
 * @author zhy
 * @date 15/11/6
 */
public class L {

    public static void d(String msg) {
        if (ConfigConstants.DEBUG) {
            Log.d("OkHttp", msg);
        }
    }

}

