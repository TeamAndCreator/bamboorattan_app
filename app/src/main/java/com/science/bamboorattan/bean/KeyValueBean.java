package com.science.bamboorattan.bean;

import java.io.Serializable;

/**
 * Created by Admin on 2017/7/12.
 */

public class KeyValueBean implements Serializable {
    private String title;
    private String value;


    public String getTitle() {
        return title;
    }

    public KeyValueBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getValue() {
        return value;
    }

    public KeyValueBean setValue(String value) {
        this.value = value;
        return this;
    }
}
