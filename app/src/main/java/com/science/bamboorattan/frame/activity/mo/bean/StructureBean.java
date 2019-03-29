package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class StructureBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String specName;
    private String stStemDiameterUnitMm;
    private String stWallThicknessUnitMm;
    private String stMaximumInternodeLengthUnitCm;
    private String stRattanDiameterUnitMm;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public StructureBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public StructureBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public StructureBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getSpecName() {
        return specName;
    }

    public StructureBean setSpecName(String specName) {
        this.specName = specName;
        return this;
    }

    public String getStStemDiameterUnitMm() {
        return stStemDiameterUnitMm;
    }

    public StructureBean setStStemDiameterUnitMm(String stStemDiameterUnitMm) {
        this.stStemDiameterUnitMm = stStemDiameterUnitMm;
        return this;
    }

    public String getStWallThicknessUnitMm() {
        return stWallThicknessUnitMm;
    }

    public StructureBean setStWallThicknessUnitMm(String stWallThicknessUnitMm) {
        this.stWallThicknessUnitMm = stWallThicknessUnitMm;
        return this;
    }

    public String getStMaximumInternodeLengthUnitCm() {
        return stMaximumInternodeLengthUnitCm;
    }

    public StructureBean setStMaximumInternodeLengthUnitCm(String stMaximumInternodeLengthUnitCm) {
        this.stMaximumInternodeLengthUnitCm = stMaximumInternodeLengthUnitCm;
        return this;
    }

    public String getStRattanDiameterUnitMm() {
        return stRattanDiameterUnitMm;
    }

    public StructureBean setStRattanDiameterUnitMm(String stRattanDiameterUnitMm) {
        this.stRattanDiameterUnitMm = stRattanDiameterUnitMm;
        return this;
    }
}
