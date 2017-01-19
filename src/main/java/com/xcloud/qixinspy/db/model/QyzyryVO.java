package com.xcloud.qixinspy.db.model;

import com.google.gson.Gson;

public class QyzyryVO {

    private String zjh;// 证件号
    private String xm;// 姓名
    private String zw;// 职位
    private String dh; // 电话
    private String dz; // 住址

    public String getZjh() {
        return zjh;
    }

    public void setZjh(String zjh) {
        this.zjh = zjh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }

}
