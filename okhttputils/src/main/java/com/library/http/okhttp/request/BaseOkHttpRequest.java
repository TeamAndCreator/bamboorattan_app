package com.library.http.okhttp.request;

import com.library.http.okhttp.callback.BaseCallback;
import com.library.http.okhttp.utils.Exceptions;

import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author zhy
 * @date 15/11/6
 */
public abstract class BaseOkHttpRequest {
    /**
     * 统一资源定位福
     */
    protected String url;
    /**
     * 标记
     */
    protected Object tag;
    /**
     * 请求体参数
     */
    protected Map<String, String> params;
    /**
     * 请求头参数
     */
    protected Map<String, String> headers;
    protected int id;

    protected Request.Builder builder = new Request.Builder();

    protected BaseOkHttpRequest(String url, Object tag,
                                Map<String, String> params, Map<String, String> headers, int id) {
        this.url = url;
        this.tag = tag;
        this.params = params;
        this.headers = headers;
        this.id = id;

        if (url == null) {
            Exceptions.illegalArgument("url can not be null.");
        }

        initBuilder();
    }


    /**
     * 初始化一些基本参数 url , tag , headers
     */
    private void initBuilder() {
        builder.url(url).tag(tag);
        appendHeaders();
    }

    /**
     * 定义子类构建请求体的方法
     *
     * @return 请求体
     */
    protected abstract RequestBody buildRequestBody();

    protected RequestBody wrapRequestBody(RequestBody requestBody, final BaseCallback callback) {
        return requestBody;
    }

    /**
     * 定义子类构建请求的方法
     *
     * @param requestBody 请求体
     * @return 请求
     */
    protected abstract Request buildRequest(RequestBody requestBody);

    public RequestCall build() {
        return new RequestCall(this);
    }


    public Request generateRequest(BaseCallback callback) {
        RequestBody requestBody = buildRequestBody();
        RequestBody wrappedRequestBody = wrapRequestBody(requestBody, callback);
        return buildRequest(wrappedRequestBody);
    }


    protected void appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) {
            return;
        }

        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }

    public int getId() {
        return id;
    }

}
