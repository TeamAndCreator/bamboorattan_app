package com.science.bamboorattan.frame.activity.mo.bean;

import java.io.Serializable;

public class UploadResultBean implements Serializable {


    /**
     * displayUrl : http://bamboorattan.oss-cn-qingdao.aliyuncs
     * .com/nstall/images/20181003/20181003214948oNCIGQQm.mp4
     * saveUrl : nstall/images/20181003/20181003214948oNCIGQQm.mp4
     * sourceFileName : test.mp4
     */

    private String displayUrl;
    private String saveUrl;
    private String sourceFileName;

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }
}
