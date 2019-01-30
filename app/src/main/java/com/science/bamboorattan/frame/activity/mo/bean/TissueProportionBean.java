package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class TissueProportionBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String tpFiberPeoportionUnitPercent;
    private String tpVesselProportionUnitPercent;
    private String tpSieveTubeProportionUnitPercent;
    private String tpParenchymaCellProportionUnitPercent;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public TissueProportionBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public TissueProportionBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public TissueProportionBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getTpFiberPeoportionUnitPercent() {
        return tpFiberPeoportionUnitPercent;
    }

    public TissueProportionBean setTpFiberPeoportionUnitPercent(String tpFiberPeoportionUnitPercent) {
        this.tpFiberPeoportionUnitPercent = tpFiberPeoportionUnitPercent;
        return this;
    }

    public String getTpVesselProportionUnitPercent() {
        return tpVesselProportionUnitPercent;
    }

    public TissueProportionBean setTpVesselProportionUnitPercent(String tpVesselProportionUnitPercent) {
        this.tpVesselProportionUnitPercent = tpVesselProportionUnitPercent;
        return this;
    }

    public String getTpSieveTubeProportionUnitPercent() {
        return tpSieveTubeProportionUnitPercent;
    }

    public TissueProportionBean setTpSieveTubeProportionUnitPercent(String tpSieveTubeProportionUnitPercent) {
        this.tpSieveTubeProportionUnitPercent = tpSieveTubeProportionUnitPercent;
        return this;
    }

    public String getTpParenchymaCellProportionUnitPercent() {
        return tpParenchymaCellProportionUnitPercent;
    }

    public TissueProportionBean setTpParenchymaCellProportionUnitPercent(String tpParenchymaCellProportionUnitPercent) {
        this.tpParenchymaCellProportionUnitPercent = tpParenchymaCellProportionUnitPercent;
        return this;
    }
}
