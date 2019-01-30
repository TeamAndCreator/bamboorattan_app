package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

/**
 *
 */
public class SheathEarBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String sheathEarDev;
    private String sheathEarShape;
    private String sheathEarMargin;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public SheathEarBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public SheathEarBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public SheathEarBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getSheathEarDev() {
        return sheathEarDev;
    }

    public SheathEarBean setSheathEarDev(String sheathEarDev) {
        this.sheathEarDev = sheathEarDev;
        return this;
    }

    public String getSheathEarShape() {
        return sheathEarShape;
    }

    public SheathEarBean setSheathEarShape(String sheathEarShape) {
        this.sheathEarShape = sheathEarShape;
        return this;
    }

    public String getSheathEarMargin() {
        return sheathEarMargin;
    }

    public SheathEarBean setSheathEarMargin(String sheathEarMargin) {
        this.sheathEarMargin = sheathEarMargin;
        return this;
    }
}
