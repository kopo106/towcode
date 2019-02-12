package com.hnkypg.pojo;

import java.sql.Date;

/**
 * Created by python on 2017/6/9 0009.
 */
public class tongji {
    private int userid;
    private int zxcount;
    private int shcount;
    private int kccount;
    private int jzgtcount;
    private String name;
    private String bumen;
    private String baogaotype;
    private String month;


    public String getBaogaotype() {
        return baogaotype;
    }

    public void setBaogaotype(String baogaotype) {
        this.baogaotype = baogaotype;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }



    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getZxcount() {
        return zxcount;
    }

    public void setZxcount(int zxcount) {
        this.zxcount = zxcount;
    }

    public int getShcount() {
        return shcount;
    }

    public void setShcount(int shcount) {
        this.shcount = shcount;
    }

    public int getKccount() {
        return kccount;
    }

    public void setKccount(int kccount) {
        this.kccount = kccount;
    }

    public int getJzgtcount() {
        return jzgtcount;
    }

    public void setJzgtcount(int jzgtcount) {
        this.jzgtcount = jzgtcount;
    }



}
