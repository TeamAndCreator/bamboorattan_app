package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class FlowerFruitBean implements Serializable {

    private String saveOperateFlag;
    private String id;
    private String specId;
    private String spikeletShape;
    private String spikeletBack;
    private String spikeletFloret;
    private String stamenNum;
    private String glume;
    private String lodicule;
    private String palea;
    private String lemma;

    public String getSaveOperateFlag() {
        return saveOperateFlag;
    }

    public FlowerFruitBean setSaveOperateFlag(String saveOperateFlag) {
        this.saveOperateFlag = saveOperateFlag;
        return this;
    }

    public String getId() {
        return id;
    }

    public FlowerFruitBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getSpecId() {
        return specId;
    }

    public FlowerFruitBean setSpecId(String specId) {
        this.specId = specId;
        return this;
    }

    public String getSpikeletShape() {
        return spikeletShape;
    }

    public FlowerFruitBean setSpikeletShape(String spikeletShape) {
        this.spikeletShape = spikeletShape;
        return this;
    }

    public String getSpikeletBack() {
        return spikeletBack;
    }

    public FlowerFruitBean setSpikeletBack(String spikeletBack) {
        this.spikeletBack = spikeletBack;
        return this;
    }

    public String getSpikeletFloret() {
        return spikeletFloret;
    }

    public FlowerFruitBean setSpikeletFloret(String spikeletFloret) {
        this.spikeletFloret = spikeletFloret;
        return this;
    }

    public String getStamenNum() {
        return stamenNum;
    }

    public FlowerFruitBean setStamenNum(String stamenNum) {
        this.stamenNum = stamenNum;
        return this;
    }

    public String getGlume() {
        return glume;
    }

    public FlowerFruitBean setGlume(String glume) {
        this.glume = glume;
        return this;
    }

    public String getLodicule() {
        return lodicule;
    }

    public FlowerFruitBean setLodicule(String lodicule) {
        this.lodicule = lodicule;
        return this;
    }

    public String getPalea() {
        return palea;
    }

    public FlowerFruitBean setPalea(String palea) {
        this.palea = palea;
        return this;
    }

    public String getLemma() {
        return lemma;
    }

    public FlowerFruitBean setLemma(String lemma) {
        this.lemma = lemma;
        return this;
    }
}
