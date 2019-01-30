package com.library.http.okhttp.builder;

import com.library.http.okhttp.request.RequestCall;
import com.library.http.okhttp.request.PostFileRequest;

import java.io.File;

import okhttp3.MediaType;

/**
 *
 * @author zhy
 * @date 15/12/14
 */
public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder> {
    private File file;
    private MediaType mediaType;


    public OkHttpRequestBuilder file(File file) {
        this.file = file;
        return this;
    }

    public OkHttpRequestBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build() {
        return new PostFileRequest(url, tag, params, headers, file, mediaType, id).build();
    }


}
