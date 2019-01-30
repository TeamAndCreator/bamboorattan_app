package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

/**
 *
 */
public class SheathBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String sheathShedTime;
    private String sheathChar;
    private String sheathTopForm;
    private String sheathBackPowder;
    private String sheathMarginForm;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public SheathBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public SheathBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public SheathBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getSheathShedTime() {
        return sheathShedTime;
    }

    public SheathBean setSheathShedTime(String sheathShedTime) {
        this.sheathShedTime = sheathShedTime;
        return this;
    }

    public String getSheathChar() {
        return sheathChar;
    }

    public SheathBean setSheathChar(String sheathChar) {
        this.sheathChar = sheathChar;
        return this;
    }

    public String getSheathTopForm() {
        return sheathTopForm;
    }

    public SheathBean setSheathTopForm(String sheathTopForm) {
        this.sheathTopForm = sheathTopForm;
        return this;
    }

    public String getSheathBackPowder() {
        return sheathBackPowder;
    }

    public SheathBean setSheathBackPowder(String sheathBackPowder) {
        this.sheathBackPowder = sheathBackPowder;
        return this;
    }

    public String getSheathMarginForm() {
        return sheathMarginForm;
    }

    public SheathBean setSheathMarginForm(String sheathMarginForm) {
        this.sheathMarginForm = sheathMarginForm;
        return this;
    }
}
