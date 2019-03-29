package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class MechanicsBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String mechBendingModulusElastictyUnitGpa;
    private String mechBendingStrenghtUnitMpa;
    private String mechCompressionStrenghtUnitMpa;
    private String mechShearStrenghtUnitMpa;
    private String mechTensileStrenghtUnitMpa;
    private String mechImpactDuctilityUnitRenxiang;
    private String mechComplianceUnitRouliang;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public MechanicsBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public MechanicsBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public MechanicsBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getMechBendingModulusElastictyUnitGpa() {
        return mechBendingModulusElastictyUnitGpa;
    }

    public MechanicsBean setMechBendingModulusElastictyUnitGpa(String mechBendingModulusElastictyUnitGpa) {
        this.mechBendingModulusElastictyUnitGpa = mechBendingModulusElastictyUnitGpa;
        return this;
    }

    public String getMechBendingStrenghtUnitMpa() {
        return mechBendingStrenghtUnitMpa;
    }

    public MechanicsBean setMechBendingStrenghtUnitMpa(String mechBendingStrenghtUnitMpa) {
        this.mechBendingStrenghtUnitMpa = mechBendingStrenghtUnitMpa;
        return this;
    }

    public String getMechCompressionStrenghtUnitMpa() {
        return mechCompressionStrenghtUnitMpa;
    }

    public MechanicsBean setMechCompressionStrenghtUnitMpa(String mechCompressionStrenghtUnitMpa) {
        this.mechCompressionStrenghtUnitMpa = mechCompressionStrenghtUnitMpa;
        return this;
    }

    public String getMechShearStrenghtUnitMpa() {
        return mechShearStrenghtUnitMpa;
    }

    public MechanicsBean setMechShearStrenghtUnitMpa(String mechShearStrenghtUnitMpa) {
        this.mechShearStrenghtUnitMpa = mechShearStrenghtUnitMpa;
        return this;
    }

    public String getMechTensileStrenghtUnitMpa() {
        return mechTensileStrenghtUnitMpa;
    }

    public MechanicsBean setMechTensileStrenghtUnitMpa(String mechTensileStrenghtUnitMpa) {
        this.mechTensileStrenghtUnitMpa = mechTensileStrenghtUnitMpa;
        return this;
    }

    public String getMechImpactDuctilityUnitRenxiang() {
        return mechImpactDuctilityUnitRenxiang;
    }

    public MechanicsBean setMechImpactDuctilityUnitRenxiang(String mechImpactDuctilityUnitRenxiang) {
        this.mechImpactDuctilityUnitRenxiang = mechImpactDuctilityUnitRenxiang;
        return this;
    }

    public String getMechComplianceUnitRouliang() {
        return mechComplianceUnitRouliang;
    }

    public MechanicsBean setMechComplianceUnitRouliang(String mechComplianceUnitRouliang) {
        this.mechComplianceUnitRouliang = mechComplianceUnitRouliang;
        return this;
    }
}
