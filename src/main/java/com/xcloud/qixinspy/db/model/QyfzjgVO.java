package com.xcloud.qixinspy.db.model;

import java.util.Date;

import com.google.gson.Gson;

public class QyfzjgVO {

    private String zjh;// 证件号
    private String gsmc;// 公司名称
    private String fddbr;// 法定代表人
    private String zczb;// 注册资本
    private Date clrq;// 成立日期

    public String getZjh() {
        return zjh;
    }

    public void setZjh(String zjh) {
        this.zjh = zjh;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    public String getZczb() {
        return zczb;
    }

    public void setZczb(String zczb) {
        this.zczb = zczb;
    }

    public Date getClrq() {
        return clrq;
    }

    public void setClrq(Date clrq) {
        this.clrq = clrq;
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }

}
