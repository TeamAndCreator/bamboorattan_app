package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

/**
 *
 */
public class SheathNodeBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String sheathNode;
    private String sheathNodeBack;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public SheathNodeBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public SheathNodeBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public SheathNodeBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getSheathNode() {
        return sheathNode;
    }

    public SheathNodeBean setSheathNode(String sheathNode) {
        this.sheathNode = sheathNode;
        return this;
    }

    public String getSheathNodeBack() {
        return sheathNodeBack;
    }

    public SheathNodeBean setSheathNodeBack(String sheathNodeBack) {
        this.sheathNodeBack = sheathNodeBack;
        return this;
    }
}
