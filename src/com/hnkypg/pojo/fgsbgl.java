package com.hnkypg.pojo;

import java.sql.Date;

/**
 * Created by python on 2017/4/16 0016.
 */
public class fgsbgl {
    private int id;
    private String baogaotype;
    private String bgnum;
    private String laiyuan;
    private String zuoluo;
    private int state;
    private Date shidian;
    private Date chujudate;
    private String bumen;
    private int trave;
    private Float zongjias;
    private String gujiashi;
    private String tel;
    private String memo;
    private User fuzeren;
    private User creater;
    private Date createdate;
    private User updater;
    private Date updatetime;
    private int ctstate;
    private int shstate;
    private String backmemo;

    public String getBackmemo() {
        return backmemo;
    }

    public void setBackmemo(String backmemo) {
        this.backmemo = backmemo;
    }

    public int getShstate() {
        return shstate;
    }

    public void setShstate(int shstate) {
        this.shstate = shstate;
    }

    public int getCtstate() {
        return ctstate;
    }

    public void setCtstate(int ctstate) {
        this.ctstate = ctstate;
    }

    public User getUpdater() {
        return updater;
    }

    public void setUpdater(User updater) {
        this.updater = updater;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public User getFuzeren() {
        return fuzeren;
    }

    public void setFuzeren(User fuzeren) {
        this.fuzeren = fuzeren;
    }

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getGujiashi() {
        return gujiashi;
    }

    public void setGujiashi(String gujiashi) {
        this.gujiashi = gujiashi;
    }

    public Float getZongjias() {
        return zongjias;
    }

    public void setZongjias(Float zongjias) {
        this.zongjias = zongjias;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getTrave() {
        return trave;
    }

    public void setTrave(int trave) {
        this.trave = trave;
    }





    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaogaotype() {
        return baogaotype;
    }

    public void setBaogaotype(String baogaotype) {
        this.baogaotype = baogaotype;
    }

    public String getBgnum() {
        return bgnum;
    }

    public void setBgnum(String bgnum) {
        this.bgnum = bgnum;
    }

    public String getLaiyuan() {
        return laiyuan;
    }

    public void setLaiyuan(String laiyuan) {
        this.laiyuan = laiyuan;
    }

    public String getZuoluo() {
        return zuoluo;
    }

    public void setZuoluo(String zuoluo) {
        this.zuoluo = zuoluo;
    }



    public Date getShidian() {
        return shidian;
    }

    public void setShidian(Date shidian) {
        this.shidian = shidian;
    }

    public Date getChujudate() {
        return chujudate;
    }

    public void setChujudate(Date chujudate) {
        this.chujudate = chujudate;
    }

}
