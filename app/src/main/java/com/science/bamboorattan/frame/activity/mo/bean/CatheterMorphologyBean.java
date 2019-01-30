package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class CatheterMorphologyBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String chmCatheterLenghtUnitMicrom;
    private String chmCatheterDiameterUnitMicrom;
    private String chmCatheterDensityUnitVcmidu;
    private String chmIndex;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public CatheterMorphologyBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public CatheterMorphologyBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public CatheterMorphologyBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getChmCatheterLenghtUnitMicrom() {
        return chmCatheterLenghtUnitMicrom;
    }

    public CatheterMorphologyBean setChmCatheterLenghtUnitMicrom(String chmCatheterLenghtUnitMicrom) {
        this.chmCatheterLenghtUnitMicrom = chmCatheterLenghtUnitMicrom;
        return this;
    }

    public String getChmCatheterDiameterUnitMicrom() {
        return chmCatheterDiameterUnitMicrom;
    }

    public CatheterMorphologyBean setChmCatheterDiameterUnitMicrom(String chmCatheterDiameterUnitMicrom) {
        this.chmCatheterDiameterUnitMicrom = chmCatheterDiameterUnitMicrom;
        return this;
    }

    public String getChmCatheterDensityUnitVcmidu() {
        return chmCatheterDensityUnitVcmidu;
    }

    public CatheterMorphologyBean setChmCatheterDensityUnitVcmidu(String chmCatheterDensityUnitVcmidu) {
        this.chmCatheterDensityUnitVcmidu = chmCatheterDensityUnitVcmidu;
        return this;
    }

    public String getChmIndex() {
        return chmIndex;
    }

    public CatheterMorphologyBean setChmIndex(String chmIndex) {
        this.chmIndex = chmIndex;
        return this;
    }
}
