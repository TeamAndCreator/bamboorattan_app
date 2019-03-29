package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class Pair implements Serializable {

    private String key;
    private String value = "";
    private String unit;

    public String getKey() {
        return key;
    }

    public Pair setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Pair setValue(String value) {
        this.value = value;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Pair setUnit(String unit) {
        this.unit = unit;
        return this;
    }
}
