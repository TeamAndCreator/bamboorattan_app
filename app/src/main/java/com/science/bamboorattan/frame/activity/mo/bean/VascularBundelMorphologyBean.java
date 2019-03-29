package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class VascularBundelMorphologyBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String vbmRadialDiameterUnitMicrom;
    private String vbmChordDiameterUnitMicrom;
    private String vbmDensityUnitVcmidu;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public VascularBundelMorphologyBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public VascularBundelMorphologyBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public VascularBundelMorphologyBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getVbmRadialDiameterUnitMicrom() {
        return vbmRadialDiameterUnitMicrom;
    }

    public VascularBundelMorphologyBean setVbmRadialDiameterUnitMicrom(String vbmRadialDiameterUnitMicrom) {
        this.vbmRadialDiameterUnitMicrom = vbmRadialDiameterUnitMicrom;
        return this;
    }

    public String getVbmChordDiameterUnitMicrom() {
        return vbmChordDiameterUnitMicrom;
    }

    public VascularBundelMorphologyBean setVbmChordDiameterUnitMicrom(String vbmChordDiameterUnitMicrom) {
        this.vbmChordDiameterUnitMicrom = vbmChordDiameterUnitMicrom;
        return this;
    }

    public String getVbmDensityUnitVcmidu() {
        return vbmDensityUnitVcmidu;
    }

    public VascularBundelMorphologyBean setVbmDensityUnitVcmidu(String vbmDensityUnitVcmidu) {
        this.vbmDensityUnitVcmidu = vbmDensityUnitVcmidu;
        return this;
    }
}
