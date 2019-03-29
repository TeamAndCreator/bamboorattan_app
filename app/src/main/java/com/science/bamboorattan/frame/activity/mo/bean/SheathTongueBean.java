package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

/**
 *
 */
public class SheathTongueBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String sheathTongueColor;
    private String sheathTongueHeight;
    private String sheathTongueMarginShape;
    private String sheathTongueBackPowderv;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public SheathTongueBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public SheathTongueBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public SheathTongueBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getSheathTongueColor() {
        return sheathTongueColor;
    }

    public SheathTongueBean setSheathTongueColor(String sheathTongueColor) {
        this.sheathTongueColor = sheathTongueColor;
        return this;
    }

    public String getSheathTongueHeight() {
        return sheathTongueHeight;
    }

    public SheathTongueBean setSheathTongueHeight(String sheathTongueHeight) {
        this.sheathTongueHeight = sheathTongueHeight;
        return this;
    }

    public String getSheathTongueMarginShape() {
        return sheathTongueMarginShape;
    }

    public SheathTongueBean setSheathTongueMarginShape(String sheathTongueMarginShape) {
        this.sheathTongueMarginShape = sheathTongueMarginShape;
        return this;
    }

    public String getSheathTongueBackPowderv() {
        return sheathTongueBackPowderv;
    }

    public SheathTongueBean setSheathTongueBackPowderv(String sheathTongueBackPowderv) {
        this.sheathTongueBackPowderv = sheathTongueBackPowderv;
        return this;
    }
}
