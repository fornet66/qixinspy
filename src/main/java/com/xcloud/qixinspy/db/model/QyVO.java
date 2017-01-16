package com.xcloud.qixinspy.db.model;

import java.util.Date;

import com.google.gson.Gson;

public class QyVO {

    private String uuid;
    private String zjh;// 证件号
    private String qymc;// 企业名称
    private String tyshxydm;// 统一社会信用代码
    private String zzjgdm;// 组织机构代码
    private String jyzt;// 经营状态
    private String gslx;// 工商类型
    private Date clrq;// 成立日期
    private String fddbr;// 法定代表人
    private String yyqx;// 营业期限
    private String zczb;// 注册资本
    private String fzrq;// 发证日期
    private String djjg;// 登记机构
    private String qydz;// 企业地址
    private String jyfw;// 经营范围

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getZjh() {
        return zjh;
    }

    public void setZjh(String zjh) {
        this.zjh = zjh;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getTyshxydm() {
        return tyshxydm;
    }

    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    public String getJyzt() {
        return jyzt;
    }

    public void setJyzt(String jyzt) {
        this.jyzt = jyzt;
    }

    public String getGslx() {
        return gslx;
    }

    public void setGslx(String gslx) {
        this.gslx = gslx;
    }

    public Date getClrq() {
        return clrq;
    }

    public void setClrq(Date clrq) {
        this.clrq = clrq;
    }

    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    public String getYyqx() {
        return yyqx;
    }

    public void setYyqx(String yyqx) {
        this.yyqx = yyqx;
    }

    public String getZczb() {
        return zczb;
    }

    public void setZczb(String zczb) {
        this.zczb = zczb;
    }

    public String getFzrq() {
        return fzrq;
    }

    public void setFzrq(String fzrq) {
        this.fzrq = fzrq;
    }

    public String getDjjg() {
        return djjg;
    }

    public void setDjjg(String djjg) {
        this.djjg = djjg;
    }

    public String getQydz() {
        return qydz;
    }

    public void setQydz(String qydz) {
        this.qydz = qydz;
    }

    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this).toString();
    }

}