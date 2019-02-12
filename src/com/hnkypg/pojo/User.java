package com.hnkypg.pojo;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
public class User {
    private int userid;
    private String username;
    private String password;
    private int idcard;
    private String imgpath;
    private String bumen;
    private String loginname;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }


}
