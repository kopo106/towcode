package com.hnkypg.pojo;

import java.sql.Date ;

/**
 * Created by python on 2018-3-20.
 */
public class baogaoyanzheng {

    private int id;
    private String gujiashi;
    private String pinggujigou;
    private String bgnum;
    private String bgname;
    private java.sql.Date chujudate;
    private Float zongjia;
    private Float jianzhumianji;
    private int status;
    private java.sql.Date createdate;
    private String TwiceEncString;
    private String memo;
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTwiceEncString() {
        return TwiceEncString;
    }

    public void setTwiceEncString(String twiceEncString) {
        TwiceEncString = twiceEncString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGujiashi() {
        return gujiashi;
    }

    public void setGujiashi(String gujiashi) {
        this.gujiashi = gujiashi;
    }

    public String getPinggujigou() {
        return pinggujigou;
    }

    public void setPinggujigou(String pinggujigou) {
        this.pinggujigou = pinggujigou;
    }

    public String getBgnum() {
        return bgnum;
    }

    public void setBgnum(String bgnum) {
        this.bgnum = bgnum;
    }

    public String getBgname() {
        return bgname;
    }

    public void setBgname(String bgname) {
        this.bgname = bgname;
    }

    public Date getChujudate() {
        return chujudate;
    }

    public void setChujudate(Date chujudate) {
        this.chujudate = chujudate;
    }

    public Float getZongjia() {
        return zongjia;
    }

    public void setZongjia(Float zongjia) {
        this.zongjia = zongjia;
    }

    public Float getJianzhumianji() {
        return jianzhumianji;
    }

    public void setJianzhumianji(Float jianzhumianji) {
        this.jianzhumianji = jianzhumianji;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
