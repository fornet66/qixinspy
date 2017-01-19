package com.xcloud.qixinspy.db.model;

import com.google.gson.Gson;

public class QygdxxVO {

    private String zjh;// 证件号
    private String gdlx;// 股东类型
    private String gd;// 股东
    private String rjcz;// 认缴出资
    private String sjcz;// 实缴出资

    public String getZjh() {
        return zjh;
    }

    public void setZjh(String zjh) {
        this.zjh = zjh;
    }

    public String getGdlx() {
        return gdlx;
    }

    public void setGdlx(String gdlx) {
        this.gdlx = gdlx;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
    }

    public String getRjcz() {
        return rjcz;
    }

    public void setRjcz(String rjcz) {
        this.rjcz = rjcz;
    }

    public String getSjcz() {
        return sjcz;
    }

    public void setSjcz(String sjcz) {
        this.sjcz = sjcz;
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }

}
