package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class FiberMorphologyBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String fmLengthUnitMicron;
    private String fmWidthUnitMicron;
    private String fmDwallThicknessUnitMicron;
    private String fmLetWidthRatio;
    private String fmCavityDeameterUnitMicrom;
    private String fmWallCavityRatio;
    private String fmCavityDiameterRatio;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public FiberMorphologyBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public FiberMorphologyBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public FiberMorphologyBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getFmLengthUnitMicron() {
        return fmLengthUnitMicron;
    }

    public FiberMorphologyBean setFmLengthUnitMicron(String fmLengthUnitMicron) {
        this.fmLengthUnitMicron = fmLengthUnitMicron;
        return this;
    }

    public String getFmWidthUnitMicron() {
        return fmWidthUnitMicron;
    }

    public FiberMorphologyBean setFmWidthUnitMicron(String fmWidthUnitMicron) {
        this.fmWidthUnitMicron = fmWidthUnitMicron;
        return this;
    }

    public String getFmDwallThicknessUnitMicron() {
        return fmDwallThicknessUnitMicron;
    }

    public FiberMorphologyBean setFmDwallThicknessUnitMicron(String fmDwallThicknessUnitMicron) {
        this.fmDwallThicknessUnitMicron = fmDwallThicknessUnitMicron;
        return this;
    }

    public String getFmLetWidthRatio() {
        return fmLetWidthRatio;
    }

    public FiberMorphologyBean setFmLetWidthRatio(String fmLetWidthRatio) {
        this.fmLetWidthRatio = fmLetWidthRatio;
        return this;
    }

    public String getFmCavityDeameterUnitMicrom() {
        return fmCavityDeameterUnitMicrom;
    }

    public FiberMorphologyBean setFmCavityDeameterUnitMicrom(String fmCavityDeameterUnitMicrom) {
        this.fmCavityDeameterUnitMicrom = fmCavityDeameterUnitMicrom;
        return this;
    }

    public String getFmWallCavityRatio() {
        return fmWallCavityRatio;
    }

    public FiberMorphologyBean setFmWallCavityRatio(String fmWallCavityRatio) {
        this.fmWallCavityRatio = fmWallCavityRatio;
        return this;
    }

    public String getFmCavityDiameterRatio() {
        return fmCavityDiameterRatio;
    }

    public FiberMorphologyBean setFmCavityDiameterRatio(String fmCavityDiameterRatio) {
        this.fmCavityDiameterRatio = fmCavityDiameterRatio;
        return this;
    }
}
