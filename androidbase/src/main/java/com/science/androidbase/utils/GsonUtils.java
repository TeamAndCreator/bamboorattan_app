package com.science.androidbase.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/6 0006.
 */

public class GsonUtils {

    private static volatile GsonUtils singleton = null;
    private static Gson gson = null;

    private GsonUtils() {
        gson = new Gson();
    }

    public static GsonUtils getInstance() {
        if (null == singleton) {
            synchronized (GsonUtils.class) {
                if (null == singleton) {
                    singleton = new GsonUtils();
                }
            }
        }
        return singleton;
    }

    public <T> T transitionToBean(String jsonString, Class<T> T) {
        return gson.fromJson(jsonString, T);
    }

    public String transitionToString(Object obj) {
        return gson.toJson(obj);
    }

    public <T> List<T> transitionToList(String jsonString, Class<T> cls) {
        return gson.fromJson(jsonString, new TypeToken<List<T>>() {
        }.getType());
    }

    public <T> List<Map<String, T>> transitionToListMaps(String jsonString) {
        return gson.fromJson(jsonString,
                new TypeToken<List<Map<String, T>>>() {
                }.getType());
    }

    public <T> Map<String, T> transitionToMaps(String jsonString) {

        return gson.fromJson(jsonString, new TypeToken<Map<String, T>>() {
        }.getType());
    }
}
