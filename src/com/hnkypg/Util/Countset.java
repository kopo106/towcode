package com.hnkypg.Util;

import com.hnkypg.pojo.BaoGaoList;
import com.hnkypg.pojo.Count;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by python on 2017-6-16.
 */
public class Countset {
    public List<Count> yupingSet(BaoGaoList bgl){
        List<Count> cts = new ArrayList<Count>();
        Count ct =null;
        if(bgl.getZhuanxie().getUserid()!=0){
            ct = new Count();
            ct.setCount(1);
            ct.setUser(bgl.getZhuanxie());
            ct.setTjtype("zhuanxie");
            ct.setBgl(bgl);
            cts.add(ct);
        }
        if(bgl.getJszhuanxie().getUserid()!=0){
            ct = new Count();
            ct.setCount(1);
            ct.setTjtype("jszhuanxie");
            ct.setUser(bgl.getJszhuanxie());
            ct.setBgl(bgl);
            cts.add(ct);
        }
        if(bgl.getJiazhigoutong().getUserid()!=0){
            ct = new Count();
            ct.setTjtype("jiazhigoutong");
            ct.setCount(1);
            ct.setUser(bgl.getJiazhigoutong());
            ct.setBgl(bgl);
            cts.add(ct);
        }
        if(bgl.getDingjia().getUserid()!=0){
            ct = new Count();
            ct.setTjtype("dingjia");
            ct.setCount(1);
            ct.setUser(bgl.getDingjia());
            ct.setBgl(bgl);
            cts.add(ct);
        }
        if(bgl.getShidikc().getUserid()!=0){
            ct = new Count();
            ct.setTjtype("shidikc");
            ct.setCount(1);
            ct.setUser(bgl.getShidikc());
            ct.setBgl(bgl);
            cts.add(ct);
        }
        if(bgl.getKancha().getUserid()!=0){
            ct = new Count();
            ct.setCount(1);
            ct.setTjtype("kancha");
            ct.setUser(bgl.getKancha());
            ct.setBgl(bgl);
            cts.add(ct);
        }
        if(bgl.getShenhe().getUserid()!=0){
            ct = new Count();
            ct.setCount(1);
            ct.setTjtype("shenhe");
            ct.setUser(bgl.getShenhe());
            ct.setBgl(bgl);
            cts.add(ct);
        }
        return cts;
    }
}
