package com.science.bamboorattan.frame.activity.mo.bean;

public class ResultBean {


    /**
     * statusCode : 200
     * message : 结构性质表增加成功！
     * navTabId : structureList
     * forwardUrl : null
     * callbackType : closeCurrent
     * rel : null
     */

    private int statusCode;
    private String message;
    private String navTabId;
    private Object forwardUrl;
    private String callbackType;
    private Object rel;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNavTabId() {
        return navTabId;
    }

    public void setNavTabId(String navTabId) {
        this.navTabId = navTabId;
    }

    public Object getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(Object forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public String getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
    }

    public Object getRel() {
        return rel;
    }

    public void setRel(Object rel) {
        this.rel = rel;
    }
}
