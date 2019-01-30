package com.library.http.okhttp.callback;

import java.io.IOException;

import okhttp3.Response;

/**
 * @author zhy
 * @date 15/12/14
 */
public abstract class BaseStringCallback extends BaseCallback<String> {
    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException {
        if (null == response) {
            return null;
        }
        if (null == response.body()) {
            return null;
        }
        return response.body().string();
    }
}
