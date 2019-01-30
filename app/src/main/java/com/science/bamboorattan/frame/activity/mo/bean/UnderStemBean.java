package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

/**
 *
 */
public class UnderStemBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String underStem;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public UnderStemBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public UnderStemBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public UnderStemBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getUnderStem() {
        return underStem;
    }

    public UnderStemBean setUnderStem(String underStem) {
        this.underStem = underStem;
        return this;
    }
}
