package com.library.http.okhttp.builder;

import com.library.http.okhttp.request.RequestCall;
import com.library.http.okhttp.request.OtherRequest;

import okhttp3.RequestBody;

/**
 * DELETE、PUT、PATCH等其他方法
 * @author kongminghui
 */
public class OtherRequestBuilder extends OkHttpRequestBuilder<OtherRequestBuilder> {
    private RequestBody requestBody;
    private String method;
    private String content;

    public OtherRequestBuilder(String method) {
        this.method = method;
    }

    @Override
    public RequestCall build() {
        return new OtherRequest(requestBody, content, method, url, tag, params, headers, id).build();
    }

    public OtherRequestBuilder requestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public OtherRequestBuilder requestBody(String content) {
        this.content = content;
        return this;
    }


}
