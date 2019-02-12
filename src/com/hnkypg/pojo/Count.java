package com.hnkypg.pojo;

/**
 * Created by python on 2017-6-15.
 */
public class Count {
    private int id;
    private User user;
    private String tjtype;
    private BaoGaoList bgl;
    private float count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTjtype() {
        return tjtype;
    }

    public void setTjtype(String tjtype) {
        this.tjtype = tjtype;
    }

    public BaoGaoList getBgl() {
        return bgl;
    }

    public void setBgl(BaoGaoList bgl) {
        this.bgl = bgl;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }
}
