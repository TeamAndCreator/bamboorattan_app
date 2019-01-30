package com.library.http.okhttp.callback;

/**
 * Created by JimGong on 2016/6/23.
 */
interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
