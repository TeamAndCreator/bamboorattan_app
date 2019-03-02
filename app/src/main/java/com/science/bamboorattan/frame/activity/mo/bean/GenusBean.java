package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

/**
 *
 */
public class GenusBean implements Serializable {

    private String saveOperateFlag;
    private String genusId;
    private String genusNameCh;
    private String genusNameEn;
    private String genusNameLd;
    private String genusNameOth;
    private String genusDesc;
    private String sortNum;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public GenusBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return genusId;
    }

    public GenusBean setId(String id) {
        this.genusId = id;
        return this;
    }

    public String getGenusNameCh() {
        return genusNameCh;
    }

    public GenusBean setGenusNameCh(String genusNameCh) {
        this.genusNameCh = genusNameCh;
        return this;
    }

    public String getGenusNameEn() {
        return genusNameEn;
    }

    public GenusBean setGenusNameEn(String genusNameEn) {
        this.genusNameEn = genusNameEn;
        return this;
    }

    public String getGenusNameLd() {
        return genusNameLd;
    }

    public GenusBean setGenusNameLd(String genusNameLd) {
        this.genusNameLd = genusNameLd;
        return this;
    }

    public String getGenusNameOth() {
        return genusNameOth;
    }

    public GenusBean setGenusNameOth(String genusNameOth) {
        this.genusNameOth = genusNameOth;
        return this;
    }

    public String getGenusDesc() {
        return genusDesc;
    }

    public GenusBean setGenusDesc(String genusDesc) {
        this.genusDesc = genusDesc;
        return this;
    }

    public String getSortNum() {
        return sortNum;
    }

    public GenusBean setSortNum(String sortNum) {
        this.sortNum = sortNum;
        return this;
    }
}
