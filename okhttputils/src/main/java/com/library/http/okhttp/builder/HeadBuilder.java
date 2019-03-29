package com.library.http.okhttp.builder;

import com.library.http.okhttp.request.RequestCall;
import com.library.http.okhttp.OkHttpUtils;
import com.library.http.okhttp.request.OtherRequest;

/**
 *
 * @author zhy
 * @date 16/3/2
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.Method.HEAD, url, tag, params, headers, id).build();
    }
}
