package com.hnkypg.Util;

import com.hnkypg.dao.BaoGaoDao;
import com.hnkypg.dao.UserDao;
import com.hnkypg.pojo.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by python on 2017-6-22.
 */
public class bgutil {
    public Map bglfirstset(HttpServletRequest request){
        Map map = new HashMap();
        BaoGaoList bgl = new BaoGaoList();
        UserDao ud = new UserDao();
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<>();
        if(request.getParameter("baogaotype").equals("预评报告")){
            bgl.setState(1);
        }else if(request.getParameter("baogaotype").equals("正式报告")){
            bgl.setState(3);
        }else if(request.getParameter("baogaotype").equals("分公司报告审核")){
            bgl.setState(5);
        }else{
            bgl.setState(6);
        }
        bgl.setBumen(request.getParameter("bumen"));
        bgl.setBgnum(request.getParameter("bgnum"));
        bgl.setBaogaotype(request.getParameter("baogaotype"));
        if(request.getParameter("chujudate").length()<1){
            bgl.setChujudate(null);
        }else{
            bgl.setChujudate(Date.valueOf(request.getParameter("chujudate")));
        }

        bgl.setLaiyuan(request.getParameter("laiyuan"));
        if(request.getParameter("shidian").length()<1){
            bgl.setShidian(null);
        }else{
            bgl.setShidian(Date.valueOf(request.getParameter("shidian")));
        }

        //设置bgl的gujiashi tel  memo
        bgl.setGujiashi(request.getParameter("gujiashi"));
        bgl.setTel(request.getParameter("tel"));
        bgl.setMemo(request.getParameter("memo"));

        User zhuanxie = new User();
        User jszhuanxie = new User();
        User shenhe = new User();
        User kancha = new User();
        User shidikc = new User();
        User dingjia = new User();
        User jiazhigoutong = new User();
        User fuzeren =new User();
        Count ct = null;
        List<Count> cts = new ArrayList<>();
        if(request.getParameter("zhuanxie").length()>0){
            String[] zxbm = request.getParameter("zhuanxie").split("---");
            zhuanxie.setUsername(zxbm[0]);
            zhuanxie.setBumen(zxbm[1]);
            bgl.setZhuanxie(ud.finduseridbynameandbumen(zhuanxie));
            ct = new Count();
            ct.setUser(bgl.getZhuanxie());
            ct.setTjtype("zhuanxie");
            ct.setCount(1);
            cts.add(ct);

        }else {
            zhuanxie.setUserid(0);
            bgl.setZhuanxie(zhuanxie);
        }
        if(request.getParameter("kancha").length()>0){
            String[] kcbm = request.getParameter("kancha").split("---");
            kancha.setUsername(kcbm[0]);
            kancha.setBumen(kcbm[1]);
            bgl.setKancha(ud.finduseridbynameandbumen(kancha));
            ct = new Count();
            ct.setUser(bgl.getKancha());
            ct.setTjtype("kancha");
            ct.setCount(1);
            cts.add(ct);
        }else{
            kancha.setUserid(0);
            bgl.setKancha(kancha);
        }
        if(request.getParameter("shenhe").length()>0){
            if(request.getParameter("bumen").equals("新乡")){
                String[] shbm = request.getParameter("shenhe").split("---");
                shenhe.setUsername(shbm[0]);
                shenhe.setBumen(shbm[1]);
                bgl.setShenhe(ud.finduseridbynameandbumen(shenhe));
                ct = new Count();
                ct.setUser(bgl.getShenhe());
                ct.setTjtype("fgsshenhe");
                ct.setCount(1);
                cts.add(ct);
            }else{
                String[] shbm = request.getParameter("shenhe").split("---");
                shenhe.setUsername(shbm[0]);
                shenhe.setBumen(shbm[1]);
                bgl.setShenhe(ud.finduseridbynameandbumen(shenhe));
                ct = new Count();
                ct.setUser(bgl.getShenhe());
                ct.setTjtype("shenhe");
                ct.setCount(1);
                cts.add(ct);
            }

        }else{
            shenhe.setUserid(0);
            bgl.setShenhe(shenhe);
        }
        if(request.getParameter("jiazhigoutong").length()>0){
            String[] jzbm = request.getParameter("jiazhigoutong").split("---");
            jiazhigoutong.setUsername(jzbm[0]);
            jiazhigoutong.setBumen(jzbm[1]);
            bgl.setJiazhigoutong(ud.finduseridbynameandbumen(jiazhigoutong));
            ct = new Count();
            ct.setUser(bgl.getJiazhigoutong());
            ct.setTjtype("jiazhigoutong");
            ct.setCount(1);
            cts.add(ct);
        }else{
            jiazhigoutong.setUserid(0);
            bgl.setJiazhigoutong(jiazhigoutong);
        }
        if(request.getParameter("jszhuanxie").length()>0){
            String[] jzbm = request.getParameter("jszhuanxie").split("---");
            jszhuanxie.setUsername(jzbm[0]);
            jszhuanxie.setBumen(jzbm[1]);
            bgl.setJszhuanxie(ud.finduseridbynameandbumen(jszhuanxie));
            ct = new Count();
            ct.setUser(bgl.getJszhuanxie());
            ct.setTjtype("jszhuanxie");
            ct.setCount(1);
            cts.add(ct);
        }else{
            jszhuanxie.setUserid(0);
            bgl.setJszhuanxie(jszhuanxie);
        }
        if(request.getParameter("dingjia").length()>0){
            String[] jzbm = request.getParameter("dingjia").split("---");
            dingjia.setUsername(jzbm[0]);
            dingjia.setBumen(jzbm[1]);
            bgl.setDingjia(ud.finduseridbynameandbumen(dingjia));
            ct = new Count();
            ct.setUser(bgl.getDingjia());
            ct.setTjtype("dingjia");
            ct.setCount(1);
            cts.add(ct);
        }else{
            dingjia.setUserid(0);
            bgl.setDingjia(dingjia);
        }
        if(request.getParameter("shidikc").length()>0){
            String[] jzbm = request.getParameter("shidikc").split("---");
            shidikc.setUsername(jzbm[0]);
            shidikc.setBumen(jzbm[1]);
            bgl.setShidikc(ud.finduseridbynameandbumen(shidikc));
            ct = new Count();
            ct.setUser(bgl.getShidikc());
            ct.setTjtype("shidikc");
            ct.setCount(1);
            cts.add(ct);
        }else{
            shidikc.setUserid(0);
            bgl.setShidikc(shidikc);
        }
        if(request.getParameter("fuzeren").length()>0){
            String[] fzbm = request.getParameter("fuzeren").split("---");
            fuzeren.setUsername(fzbm[0]);
            fuzeren.setBumen(fzbm[1]);
            bgl.setFuzeren(ud.finduseridbynameandbumen(fuzeren));
            ct = new Count();
            ct.setUser(bgl.getFuzeren());
            ct.setTjtype("fuzeren");
            ct.setCount(1);
            cts.add(ct);

        }else {
            fuzeren.setUserid(0);
            bgl.setFuzeren(fuzeren);
        }

        String zuoluo = null;
        Float zongjia = null;
        if(request.getParameter("bdwct")!=null){
            String i = request.getParameter("bdwct");
            if(i.indexOf(",")!=-1){
                String[] bdwct = i.split(",");
                for(int j=0;j<bdwct.length;j++){
                    System.out.println("danjia"+bdwct[j]);
                    System.out.println(request.getParameter("danjia"+bdwct[j]));
                }
                for (int j =0;j<bdwct.length;j++){
                    bg = new BaoGao();
                    bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+bdwct[j])));
                    bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+bdwct[j])));
                    bg.setZong(request.getParameter("zong"+bdwct[j]));
                    bg.setSuo(request.getParameter("suo"+bdwct[j]));
                    bg.setProname(request.getParameter("proname"+bdwct[j]));
                    bg.setChanquanren(request.getParameter("chanquanren"+bdwct[j]));
                    bg.setYongtu(request.getParameter("yongtu"+bdwct[j]));
                    bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    bg.setNiandai(request.getParameter("niandai"+bdwct[j]));
                    bg.setMianji(Float.parseFloat(request.getParameter("mianji"+bdwct[j])));
                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+bdwct[j]));
                    bg.setPoint(request.getParameter("point"+bdwct[j]));
                    if(j==0){
                        zuoluo = bg.getZuoluo();
                        zongjia = bg.getZongjia();
                    }else{
                        zuoluo = zuoluo + "/"+bg.getZuoluo();
                        zongjia = zongjia + bg.getZongjia();
                    }
                    bgs.add(bg);
                }
            }else {
                bg = new BaoGao();
                bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+i)));
                bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+i)));
                bg.setZong(request.getParameter("zong"+i));
                bg.setSuo(request.getParameter("suo"+i));
                bg.setProname(request.getParameter("proname"+i));
                bg.setChanquanren(request.getParameter("chanquanren"+i));
                bg.setYongtu(request.getParameter("yongtu"+i));
                bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                bg.setNiandai(request.getParameter("niandai"+i));
                bg.setMianji(Float.parseFloat(request.getParameter("mianji"+i)));
                bg.setBgnum(request.getParameter("bgnum"));
                bg.setZuoluo(request.getParameter("zuoluo"+i));
                bg.setPoint(request.getParameter("point"+i));
                zuoluo = bg.getZuoluo();
                zongjia = bg.getZongjia();

                bgs.add(bg);
            }


        }
        bgl.setZuoluo(zuoluo);
        bgl.setZongjias(zongjia);
        //bgl 要有一个总的价格并且设置总价格

        map.put("bgl",bgl);
        map.put("cts",cts);
        map.put("bgs",bgs);
        return map;
    }

    public Map bgltraveset(HttpServletRequest request){
        Map map = new HashMap();
        BaoGaoList bgl = new BaoGaoList();
        UserDao ud = new UserDao();
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<>();
        if(request.getParameter("baogaotype").equals("预评报告")){
            bgl.setState(1);
        }else if(request.getParameter("baogaotype").equals("正式报告")){
            bgl.setState(3);
        }else if(request.getParameter("baogaotype").equals("分公司报告审核")){
            bgl.setState(5);
        }else{
            bgl.setState(6);
        }
        bgl.setTrave(1);
        bgl.setState(4);
        bgl.setBumen(request.getParameter("bumen"));
        bgl.setBgnum(request.getParameter("bgnum"));
        bgl.setBaogaotype(request.getParameter("baogaotype"));
        bgl.setChujudate(Date.valueOf(request.getParameter("chujudate")));
        bgl.setLaiyuan(request.getParameter("laiyuan"));
        bgl.setShidian(Date.valueOf(request.getParameter("shidian")));
        //设置bgl的gujiashi tel  memo
        bgl.setGujiashi(request.getParameter("gujiashi"));
        bgl.setTel(request.getParameter("tel"));
        bgl.setMemo(request.getParameter("memo"));

        User zhuanxie = new User();
        User jszhuanxie = new User();
        User shenhe = new User();
        User kancha = new User();
        User shidikc = new User();
        User dingjia = new User();
        User jiazhigoutong = new User();
        Count ct = null;
        List<Count> cts = new ArrayList<>();
        if(request.getParameter("zhuanxie").length()>0){
            String[] zxbm = request.getParameter("zhuanxie").split("---");
            zhuanxie.setUsername(zxbm[0]);
            zhuanxie.setBumen(zxbm[1]);
            bgl.setZhuanxie(ud.finduseridbynameandbumen(zhuanxie));
            ct = new Count();
            ct.setUser(bgl.getZhuanxie());
            ct.setTjtype("zhuanxie");
            ct.setCount(1);
            cts.add(ct);

        }else {
            zhuanxie.setUserid(0);
            bgl.setZhuanxie(zhuanxie);
        }

        if(request.getParameter("jszhuanxie").length()>0){
            String[] jzbm = request.getParameter("jszhuanxie").split("---");
            jszhuanxie.setUsername(jzbm[0]);
            jszhuanxie.setBumen(jzbm[1]);
            bgl.setJszhuanxie(ud.finduseridbynameandbumen(jszhuanxie));
            ct = new Count();
            ct.setUser(bgl.getJszhuanxie());
            ct.setTjtype("jszhuanxie");
            ct.setCount(1);
            cts.add(ct);
        }else{
            jszhuanxie.setUserid(0);
            bgl.setJszhuanxie(jszhuanxie);
        }


        String zuoluo = null;
        Float zongjia = null;
        if(request.getParameter("bdwct")!=null){
            String i = request.getParameter("bdwct");
            if(i.indexOf(",")!=-1){
                String[] bdwct = i.split(",");
                for(int j=0;j<bdwct.length;j++){
                    System.out.println("danjia"+bdwct[j]);
                    System.out.println(request.getParameter("danjia"+bdwct[j]));
                }
                for (int j =0;j<bdwct.length;j++){
                    bg = new BaoGao();
                    bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+bdwct[j])));
                    bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+bdwct[j])));
                    bg.setZong(request.getParameter("zong"+bdwct[j]));
                    bg.setSuo(request.getParameter("suo"+bdwct[j]));
                    bg.setProname(request.getParameter("proname"+bdwct[j]));
                    bg.setChanquanren(request.getParameter("chanquanren"+bdwct[j]));
                    bg.setYongtu(request.getParameter("yongtu"+bdwct[j]));
                    bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    bg.setNiandai(request.getParameter("niandai"+bdwct[j]));
                    bg.setMianji(Float.parseFloat(request.getParameter("mianji"+bdwct[j])));
                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+bdwct[j]));
                    bg.setPoint(request.getParameter("point"+bdwct[j]));
                    if(j==0){
                        zuoluo = bg.getZuoluo();
                        zongjia = bg.getZongjia();
                    }else{
                        zuoluo = zuoluo + "/"+bg.getZuoluo();
                        zongjia = zongjia + bg.getZongjia();
                    }
                    bgs.add(bg);
                }
            }else {
                bg = new BaoGao();
                bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+i)));
                bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+i)));
                bg.setZong(request.getParameter("zong"+i));
                bg.setSuo(request.getParameter("suo"+i));
                bg.setProname(request.getParameter("proname"+i));
                bg.setChanquanren(request.getParameter("chanquanren"+i));
                bg.setYongtu(request.getParameter("yongtu"+i));
                bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                bg.setNiandai(request.getParameter("niandai"+i));
                bg.setMianji(Float.parseFloat(request.getParameter("mianji"+i)));
                bg.setBgnum(request.getParameter("bgnum"));
                bg.setZuoluo(request.getParameter("zuoluo"+i));
                bg.setPoint(request.getParameter("point"+i));
                zuoluo = bg.getZuoluo();
                zongjia = bg.getZongjia();

                bgs.add(bg);
            }


        }
        bgl.setZuoluo(zuoluo);
        bgl.setZongjias(zongjia);
        //bgl 要有一个总的价格并且设置总价格

        map.put("bgl",bgl);
        map.put("cts",cts);
        map.put("bgs",bgs);
        return map;
    }

    public Map fgsfirstset(HttpServletRequest request){
        Map map = new HashMap();
        fgsbgl bgl = new fgsbgl();
        UserDao ud = new UserDao();
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<>();
        if(request.getParameter("baogaotype").equals("预评报告")){
            bgl.setState(1);
        }else if(request.getParameter("baogaotype").equals("正式报告")){
            bgl.setState(3);
        }else if(request.getParameter("baogaotype").equals("分公司报告审核")){
            bgl.setState(5);
        }else{
            bgl.setState(6);
        }
        bgl.setBumen(request.getParameter("bumen"));
        bgl.setBgnum(request.getParameter("bgnum"));
        bgl.setBaogaotype(request.getParameter("baogaotype"));
        bgl.setChujudate(Date.valueOf(request.getParameter("chujudate")));
        bgl.setLaiyuan(request.getParameter("laiyuan"));
        bgl.setShidian(Date.valueOf(request.getParameter("shidian")));
        //设置bgl的gujiashi tel  memo
        bgl.setGujiashi(request.getParameter("gujiashi"));
        bgl.setTel(request.getParameter("tel"));
        bgl.setMemo(request.getParameter("memo"));
        bgl.setShstate(1);
        User fuzeren =new User();


        if(request.getParameter("fuzeren").length()>0){
            String[] fzbm = request.getParameter("fuzeren").split("---");
            fuzeren.setUsername(fzbm[0]);
            fuzeren.setBumen(fzbm[1]);
            bgl.setFuzeren(ud.finduseridbynameandbumen(fuzeren));

        }else {
            fuzeren.setUserid(0);
            bgl.setFuzeren(fuzeren);
        }

        String zuoluo = null;
        Float zongjia = null;
        if(request.getParameter("bdwct")!=null){
            String i = request.getParameter("bdwct");
            if(i.indexOf(",")!=-1){
                String[] bdwct = i.split(",");
                for(int j=0;j<bdwct.length;j++){
                    System.out.println("danjia"+bdwct[j]);
                    System.out.println(request.getParameter("danjia"+bdwct[j]));
                }
                for (int j =0;j<bdwct.length;j++){
                    bg = new BaoGao();
                    bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+bdwct[j])));
                    bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+bdwct[j])));
                    bg.setZong(request.getParameter("zong"+bdwct[j]));
                    bg.setSuo(request.getParameter("suo"+bdwct[j]));
                    bg.setProname(request.getParameter("proname"+bdwct[j]));
                    bg.setChanquanren(request.getParameter("chanquanren"+bdwct[j]));
                    bg.setYongtu(request.getParameter("yongtu"+bdwct[j]));
                    bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    bg.setNiandai(request.getParameter("niandai"+bdwct[j]));
                    bg.setMianji(Float.parseFloat(request.getParameter("mianji"+bdwct[j])));
                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+bdwct[j]));
                    bg.setPoint(request.getParameter("point"+bdwct[j]));
                    if(j==0){
                        zuoluo = bg.getZuoluo();
                        zongjia = bg.getZongjia();
                    }else{
                        zuoluo = zuoluo + "/"+bg.getZuoluo();
                        zongjia = zongjia + bg.getZongjia();
                    }
                    bgs.add(bg);
                }
            }else {
                bg = new BaoGao();
                bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+i)));
                bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+i)));
                bg.setZong(request.getParameter("zong"+i));
                bg.setSuo(request.getParameter("suo"+i));
                bg.setProname(request.getParameter("proname"+i));
                bg.setChanquanren(request.getParameter("chanquanren"+i));
                bg.setYongtu(request.getParameter("yongtu"+i));
                bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                bg.setNiandai(request.getParameter("niandai"+i));
                bg.setMianji(Float.parseFloat(request.getParameter("mianji"+i)));
                bg.setBgnum(request.getParameter("bgnum"));
                bg.setZuoluo(request.getParameter("zuoluo"+i));
                bg.setPoint(request.getParameter("point"+i));
                zuoluo = bg.getZuoluo();
                zongjia = bg.getZongjia();

                bgs.add(bg);
            }


        }
        bgl.setZuoluo(zuoluo);
        bgl.setZongjias(zongjia);
        //bgl 要有一个总的价格并且设置总价格

        map.put("bgl",bgl);
        map.put("bgs",bgs);
        return map;
    }

    public Map fgstraveset(HttpServletRequest request){
        Map map = new HashMap();
        fgsbgl bgl = new fgsbgl();
        UserDao ud = new UserDao();
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<>();
        if(request.getParameter("baogaotype").equals("正式报告")){
            bgl.setState(4);
        }
        bgl.setTrave(1);
        bgl.setBumen(request.getParameter("bumen"));
        bgl.setBgnum(request.getParameter("bgnum"));
        bgl.setBaogaotype(request.getParameter("baogaotype"));
        bgl.setChujudate(Date.valueOf(request.getParameter("chujudate")));
        bgl.setLaiyuan(request.getParameter("laiyuan"));
        bgl.setShidian(Date.valueOf(request.getParameter("shidian")));
        //设置bgl的gujiashi tel  memo
        bgl.setGujiashi(request.getParameter("gujiashi"));
        bgl.setTel(request.getParameter("tel"));
        bgl.setMemo(request.getParameter("memo"));

        User fuzeren =new User();


        if(request.getParameter("fuzeren").length()>0){
            String[] fzbm = request.getParameter("fuzeren").split("---");
            fuzeren.setUsername(fzbm[0]);
            fuzeren.setBumen(fzbm[1]);
            bgl.setFuzeren(ud.finduseridbynameandbumen(fuzeren));

        }else {
            fuzeren.setUserid(0);
            bgl.setFuzeren(fuzeren);
        }



        String zuoluo = null;
        Float zongjia = null;
        if(request.getParameter("bdwct")!=null){
            String i = request.getParameter("bdwct");
            if(i.indexOf(",")!=-1){
                String[] bdwct = i.split(",");
                for(int j=0;j<bdwct.length;j++){
                    System.out.println("danjia"+bdwct[j]);
                    System.out.println(request.getParameter("danjia"+bdwct[j]));
                }
                for (int j =0;j<bdwct.length;j++){
                    bg = new BaoGao();
                    bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+bdwct[j])));
                    bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+bdwct[j])));
                    bg.setZong(request.getParameter("zong"+bdwct[j]));
                    bg.setSuo(request.getParameter("suo"+bdwct[j]));
                    bg.setProname(request.getParameter("proname"+bdwct[j]));
                    bg.setChanquanren(request.getParameter("chanquanren"+bdwct[j]));
                    bg.setYongtu(request.getParameter("yongtu"+bdwct[j]));
                    bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    bg.setNiandai(request.getParameter("niandai"+bdwct[j]));
                    bg.setMianji(Float.parseFloat(request.getParameter("mianji"+bdwct[j])));
                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+bdwct[j]));
                    bg.setPoint(request.getParameter("point"+bdwct[j]));
                    if(j==0){
                        zuoluo = bg.getZuoluo();
                        zongjia = bg.getZongjia();
                    }else{
                        zuoluo = zuoluo + "/"+bg.getZuoluo();
                        zongjia = zongjia + bg.getZongjia();
                    }
                    bgs.add(bg);
                }
            }else {
                bg = new BaoGao();
                bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+i)));
                bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+i)));
                bg.setZong(request.getParameter("zong"+i));
                bg.setSuo(request.getParameter("suo"+i));
                bg.setProname(request.getParameter("proname"+i));
                bg.setChanquanren(request.getParameter("chanquanren"+i));
                bg.setYongtu(request.getParameter("yongtu"+i));
                bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                bg.setNiandai(request.getParameter("niandai"+i));
                bg.setMianji(Float.parseFloat(request.getParameter("mianji"+i)));
                bg.setBgnum(request.getParameter("bgnum"));
                bg.setZuoluo(request.getParameter("zuoluo"+i));
                bg.setPoint(request.getParameter("point"+i));
                zuoluo = bg.getZuoluo();
                zongjia = bg.getZongjia();

                bgs.add(bg);
            }


        }
        bgl.setZuoluo(zuoluo);
        bgl.setZongjias(zongjia);
        //bgl 要有一个总的价格并且设置总价格

        map.put("bgl",bgl);
        map.put("bgs",bgs);
        return map;
    }

    public Map bglerror(HttpServletRequest request){
        Map map = new HashMap();
        BaoGaoList bgl = new BaoGaoList();
        UserDao ud = new UserDao();
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<>();
        if(request.getParameter("baogaotype").equals("预评报告")){
            bgl.setState(1);
        }else if(request.getParameter("baogaotype").equals("正式报告")){
            bgl.setState(3);
        }else if(request.getParameter("baogaotype").equals("分公司报告审核")){
            bgl.setState(5);
        }else{
            bgl.setState(6);
        }
        bgl.setBumen(request.getParameter("bumen"));
        bgl.setBgnum(request.getParameter("bgnum"));
        bgl.setBaogaotype(request.getParameter("baogaotype"));
        if(request.getParameter("chujudate").length()<1){
            bgl.setChujudate(null);
        }else{
            bgl.setChujudate(Date.valueOf(request.getParameter("chujudate")));
        }

        bgl.setLaiyuan(request.getParameter("laiyuan"));
        if(request.getParameter("shidian").length()<1){
            bgl.setShidian(null);
        }else{
            bgl.setShidian(Date.valueOf(request.getParameter("shidian")));
        }

        //设置bgl的gujiashi tel  memo
        bgl.setGujiashi(request.getParameter("gujiashi"));
        bgl.setTel(request.getParameter("tel"));
        bgl.setMemo(request.getParameter("memo"));

        User zhuanxie = new User();
        User jszhuanxie = new User();
        User shenhe = new User();
        User kancha = new User();
        User shidikc = new User();
        User dingjia = new User();
        User jiazhigoutong = new User();
        User fuzeren =new User();
        Count ct = null;
        List<Count> cts = new ArrayList<>();
        if(request.getParameter("zhuanxie").length()>0){
            String[] zxbm = request.getParameter("zhuanxie").split("---");
            zhuanxie.setUsername(zxbm[0]);
            zhuanxie.setBumen(zxbm[1]);
            bgl.setZhuanxie(ud.finduseridbynameandbumen(zhuanxie));
            ct = new Count();
            ct.setUser(bgl.getZhuanxie());
            ct.setTjtype("zhuanxie");
            ct.setCount(1);
            cts.add(ct);

        }else {
            zhuanxie.setUserid(0);
            bgl.setZhuanxie(zhuanxie);
        }
        if(request.getParameter("kancha").length()>0){
            String[] kcbm = request.getParameter("kancha").split("---");
            kancha.setUsername(kcbm[0]);
            kancha.setBumen(kcbm[1]);
            bgl.setKancha(ud.finduseridbynameandbumen(kancha));
            ct = new Count();
            ct.setUser(bgl.getKancha());
            ct.setTjtype("kancha");
            ct.setCount(1);
            cts.add(ct);
        }else{
            kancha.setUserid(0);
            bgl.setKancha(kancha);
        }
        if(request.getParameter("shenhe").length()>0){
            if(request.getParameter("baogaotype").equals("分公司报告审核")){
                String[] shbm = request.getParameter("shenhe").split("---");
                shenhe.setUsername(shbm[0]);
                shenhe.setBumen(shbm[1]);
                bgl.setShenhe(ud.finduseridbynameandbumen(shenhe));
                ct = new Count();
                ct.setUser(bgl.getShenhe());
                ct.setTjtype("fgsshenhe");
                ct.setCount(1);
                cts.add(ct);
            }else{
                String[] shbm = request.getParameter("shenhe").split("---");
                shenhe.setUsername(shbm[0]);
                shenhe.setBumen(shbm[1]);
                bgl.setShenhe(ud.finduseridbynameandbumen(shenhe));
                ct = new Count();
                ct.setUser(bgl.getShenhe());
                ct.setTjtype("shenhe");
                ct.setCount(1);
                cts.add(ct);
            }

        }else{
            shenhe.setUserid(0);
            bgl.setShenhe(shenhe);
        }
        if(request.getParameter("jiazhigoutong").length()>0){
            String[] jzbm = request.getParameter("jiazhigoutong").split("---");
            jiazhigoutong.setUsername(jzbm[0]);
            jiazhigoutong.setBumen(jzbm[1]);
            bgl.setJiazhigoutong(ud.finduseridbynameandbumen(jiazhigoutong));
            ct = new Count();
            ct.setUser(bgl.getJiazhigoutong());
            ct.setTjtype("jiazhigoutong");
            ct.setCount(1);
            cts.add(ct);
        }else{
            jiazhigoutong.setUserid(0);
            bgl.setJiazhigoutong(jiazhigoutong);
        }
        if(request.getParameter("jszhuanxie").length()>0){
            String[] jzbm = request.getParameter("jszhuanxie").split("---");
            jszhuanxie.setUsername(jzbm[0]);
            jszhuanxie.setBumen(jzbm[1]);
            bgl.setJszhuanxie(ud.finduseridbynameandbumen(jszhuanxie));
            ct = new Count();
            ct.setUser(bgl.getJszhuanxie());
            ct.setTjtype("jszhuanxie");
            ct.setCount(1);
            cts.add(ct);
        }else{
            jszhuanxie.setUserid(0);
            bgl.setJszhuanxie(jszhuanxie);
        }
        if(request.getParameter("dingjia").length()>0){
            String[] jzbm = request.getParameter("dingjia").split("---");
            dingjia.setUsername(jzbm[0]);
            dingjia.setBumen(jzbm[1]);
            bgl.setDingjia(ud.finduseridbynameandbumen(dingjia));
            ct = new Count();
            ct.setUser(bgl.getDingjia());
            ct.setTjtype("dingjia");
            ct.setCount(1);
            cts.add(ct);
        }else{
            dingjia.setUserid(0);
            bgl.setDingjia(dingjia);
        }
        if(request.getParameter("shidikc").length()>0){
            String[] jzbm = request.getParameter("shidikc").split("---");
            shidikc.setUsername(jzbm[0]);
            shidikc.setBumen(jzbm[1]);
            bgl.setShidikc(ud.finduseridbynameandbumen(shidikc));
            ct = new Count();
            ct.setUser(bgl.getShidikc());
            ct.setTjtype("shidikc");
            ct.setCount(1);
            cts.add(ct);
        }else{
            shidikc.setUserid(0);
            bgl.setShidikc(shidikc);
        }
        if(request.getParameter("fuzeren").length()>0){
            String[] fzbm = request.getParameter("fuzeren").split("---");
            fuzeren.setUsername(fzbm[0]);
            fuzeren.setBumen(fzbm[1]);
            bgl.setFuzeren(ud.finduseridbynameandbumen(fuzeren));
            ct = new Count();
            ct.setUser(bgl.getFuzeren());
            ct.setTjtype("fuzeren");
            ct.setCount(1);
            cts.add(ct);

        }else {
            fuzeren.setUserid(0);
            bgl.setFuzeren(fuzeren);
        }

        String zuoluo = null;
        Float zongjia = null;
        System.out.println(request.getParameter("bdwct")+"看看是多少啊");
        if(request.getParameter("bdwct")!=null){
            String i = request.getParameter("bdwct");
            if(i.indexOf(",")!=-1){
                String[] bdwct = i.split(",");
                for(int j=0;j<bdwct.length;j++){
                    System.out.println("danjia"+bdwct[j]);
                    System.out.println(request.getParameter("danjia"+bdwct[j]));
                }
                for (int j =0;j<bdwct.length;j++){
                    bg = new BaoGao();
                    if(request.getParameter("danjia"+bdwct[j]).length()<1){
                        bg.setDanjia(0);
                    }else{
                        bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+bdwct[j])));
                    }
                    if(request.getParameter("zongjia"+bdwct[j]).length()<1){
                        bg.setZongjia(0);
                    }else {
                        bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+bdwct[j])));
                    }

                    bg.setZong(request.getParameter("zong"+bdwct[j]));
                    bg.setSuo(request.getParameter("suo"+bdwct[j]));
                    bg.setProname(request.getParameter("proname"+bdwct[j]));
                    bg.setChanquanren(request.getParameter("chanquanren"+bdwct[j]));
                    bg.setYongtu(request.getParameter("yongtu"+bdwct[j]));
                    if(request.getParameter("chujudate").length()<1){
                        bg.setChujudate(null);
                    }else{
                        bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                    }

                    bgl.setLaiyuan(request.getParameter("laiyuan"));
                    if(request.getParameter("shidian").length()<1){
                        bg.setShidian(null);
                    }else{
                        bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    }


                    bg.setNiandai(request.getParameter("niandai"+bdwct[j]));

                    if(request.getParameter("mianji"+bdwct[j]).length()<1){
                        bg.setMianji(0);
                    }else {
                        bg.setMianji(Float.parseFloat(request.getParameter("mianji"+bdwct[j])));
                    }

                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+bdwct[j]));
                    bg.setPoint(request.getParameter("point"+bdwct[j]));
                    if(j==0){
                        zuoluo = bg.getZuoluo();
                        zongjia = bg.getZongjia();
                    }else{
                        zuoluo = zuoluo + "/"+bg.getZuoluo();
                        zongjia = zongjia + bg.getZongjia();
                    }
                    bgs.add(bg);
                }
            }else if(i.length()>0){
                if(Integer.parseInt(i)==1){
                    bg = new BaoGao();
                    if(request.getParameter("danjia"+i).length()<1){
                        bg.setDanjia(0);
                    }else{
                        bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+i)));
                    }
                    if(request.getParameter("zongjia"+i).length()<1){
                        bg.setZongjia(0);
                    }else {
                        bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+i)));
                    }

                    bg.setZong(request.getParameter("zong"+i));
                    bg.setSuo(request.getParameter("suo"+i));
                    bg.setProname(request.getParameter("proname"+i));
                    bg.setChanquanren(request.getParameter("chanquanren"+i));
                    bg.setYongtu(request.getParameter("yongtu"+i));
                    if(request.getParameter("chujudate").length()<1){
                        bg.setChujudate(null);
                    }else{
                        bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                    }

                    bgl.setLaiyuan(request.getParameter("laiyuan"));
                    if(request.getParameter("shidian").length()<1){
                        bg.setShidian(null);
                    }else{
                        bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    }


                    bg.setNiandai(request.getParameter("niandai"+i));

                    if(request.getParameter("mianji"+i).length()<1){
                        bg.setMianji(0);
                    }else {
                        bg.setMianji(Float.parseFloat(request.getParameter("mianji"+i)));
                    }

                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+i));
                    bg.setPoint(request.getParameter("point"+i));
                    zuoluo = bg.getZuoluo();
                    zongjia = bg.getZongjia();

                    bgs.add(bg);
            }

            }else{
                System.out.println("没有标的物");
            }
        }
        bgl.setZuoluo(zuoluo);
        bgl.setZongjias(zongjia);
        //bgl 要有一个总的价格并且设置总价格

        map.put("bgl",bgl);
        map.put("cts",cts);
        map.put("bgs",bgs);
        return map;
    }

    public Map fgsbglerror(HttpServletRequest request){
        Map map = new HashMap();
        fgsbgl bgl = new fgsbgl();
        UserDao ud = new UserDao();
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<>();
        if(request.getParameter("baogaotype").equals("预评报告")){
            bgl.setState(1);
        }else if(request.getParameter("baogaotype").equals("正式报告")){
            bgl.setState(3);
        }else if(request.getParameter("baogaotype").equals("分公司报告审核")){
            bgl.setState(5);
        }else{
            bgl.setState(6);
        }
        bgl.setBumen(request.getParameter("bumen"));
        bgl.setBgnum(request.getParameter("bgnum"));
        bgl.setBaogaotype(request.getParameter("baogaotype"));
        if(request.getParameter("chujudate").length()<1){
            bgl.setChujudate(null);
        }else{
            bgl.setChujudate(Date.valueOf(request.getParameter("chujudate")));
        }

        bgl.setLaiyuan(request.getParameter("laiyuan"));
        if(request.getParameter("shidian").length()<1){
            bgl.setShidian(null);
        }else{
            bgl.setShidian(Date.valueOf(request.getParameter("shidian")));
        }

        //设置bgl的gujiashi tel  memo
        bgl.setGujiashi(request.getParameter("gujiashi"));
        bgl.setTel(request.getParameter("tel"));
        bgl.setMemo(request.getParameter("memo"));


        User fuzeren =new User();
        Count ct = null;
        List<Count> cts = new ArrayList<>();

        if(request.getParameter("fuzeren").length()>0){
            String[] fzbm = request.getParameter("fuzeren").split("---");
            fuzeren.setUsername(fzbm[0]);
            fuzeren.setBumen(fzbm[1]);
            bgl.setFuzeren(ud.finduseridbynameandbumen(fuzeren));
            ct = new Count();
            ct.setUser(bgl.getFuzeren());
            ct.setTjtype("fuzeren");
            ct.setCount(1);
            cts.add(ct);

        }else {
            fuzeren.setUserid(0);
            bgl.setFuzeren(fuzeren);
        }

        String zuoluo = null;
        Float zongjia = null;
        System.out.println(request.getParameter("bdwct")+"看看是多少啊");
        if(request.getParameter("bdwct")!=null){
            String i = request.getParameter("bdwct");
            if(i.indexOf(",")!=-1){
                String[] bdwct = i.split(",");
                for(int j=0;j<bdwct.length;j++){
                    System.out.println("danjia"+bdwct[j]);
                    System.out.println(request.getParameter("danjia"+bdwct[j]));
                }
                for (int j =0;j<bdwct.length;j++){
                    bg = new BaoGao();
                    if(request.getParameter("danjia"+bdwct[j]).length()<1){
                        bg.setDanjia(0);
                    }else{
                        bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+bdwct[j])));
                    }
                    if(request.getParameter("zongjia"+bdwct[j]).length()<1){
                        bg.setZongjia(0);
                    }else {
                        bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+bdwct[j])));
                    }

                    bg.setZong(request.getParameter("zong"+bdwct[j]));
                    bg.setSuo(request.getParameter("suo"+bdwct[j]));
                    bg.setProname(request.getParameter("proname"+bdwct[j]));
                    bg.setChanquanren(request.getParameter("chanquanren"+bdwct[j]));
                    bg.setYongtu(request.getParameter("yongtu"+bdwct[j]));
                    if(request.getParameter("chujudate").length()<1){
                        bg.setChujudate(null);
                    }else{
                        bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                    }

                    bgl.setLaiyuan(request.getParameter("laiyuan"));
                    if(request.getParameter("shidian").length()<1){
                        bg.setShidian(null);
                    }else{
                        bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    }


                    bg.setNiandai(request.getParameter("niandai"+bdwct[j]));

                    if(request.getParameter("mianji"+bdwct[j]).length()<1){
                        bg.setMianji(0);
                    }else {
                        bg.setMianji(Float.parseFloat(request.getParameter("mianji"+bdwct[j])));
                    }

                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+bdwct[j]));
                    bg.setPoint(request.getParameter("point"+bdwct[j]));
                    if(j==0){
                        zuoluo = bg.getZuoluo();
                        zongjia = bg.getZongjia();
                    }else{
                        zuoluo = zuoluo + "/"+bg.getZuoluo();
                        zongjia = zongjia + bg.getZongjia();
                    }
                    bgs.add(bg);
                }
            }else if(i.length()>0){
                if(Integer.parseInt(i)==1){
                    bg = new BaoGao();
                    if(request.getParameter("danjia"+i).length()<1){
                        bg.setDanjia(0);
                    }else{
                        bg.setDanjia(Float.parseFloat(request.getParameter("danjia"+i)));
                    }
                    if(request.getParameter("zongjia"+i).length()<1){
                        bg.setZongjia(0);
                    }else {
                        bg.setZongjia(Float.parseFloat(request.getParameter("zongjia"+i)));
                    }

                    bg.setZong(request.getParameter("zong"+i));
                    bg.setSuo(request.getParameter("suo"+i));
                    bg.setProname(request.getParameter("proname"+i));
                    bg.setChanquanren(request.getParameter("chanquanren"+i));
                    bg.setYongtu(request.getParameter("yongtu"+i));
                    if(request.getParameter("chujudate").length()<1){
                        bg.setChujudate(null);
                    }else{
                        bg.setChujudate(Date.valueOf(request.getParameter("chujudate")));
                    }

                    bgl.setLaiyuan(request.getParameter("laiyuan"));
                    if(request.getParameter("shidian").length()<1){
                        bg.setShidian(null);
                    }else{
                        bg.setShidian(Date.valueOf(request.getParameter("shidian")));
                    }


                    bg.setNiandai(request.getParameter("niandai"+i));

                    if(request.getParameter("mianji"+i).length()<1){
                        bg.setMianji(0);
                    }else {
                        bg.setMianji(Float.parseFloat(request.getParameter("mianji"+i)));
                    }

                    bg.setBgnum(request.getParameter("bgnum"));
                    bg.setZuoluo(request.getParameter("zuoluo"+i));
                    bg.setPoint(request.getParameter("point"+i));
                    zuoluo = bg.getZuoluo();
                    zongjia = bg.getZongjia();

                    bgs.add(bg);
                }

            }else{
                System.out.println("没有标的物");
            }
        }
        bgl.setZuoluo(zuoluo);
        bgl.setZongjias(zongjia);
        //bgl 要有一个总的价格并且设置总价格

        map.put("bgl",bgl);
        map.put("bgs",bgs);
        return map;
    }


    public Map bglupfile(HttpServletRequest request){
        Map map = new HashMap();
        BaoGaoList bgl = new BaoGaoList();
        UserDao ud = new UserDao();
        bgl.setState(1);

        bgl.setLaiyuan(request.getParameter("laiyuan"));
        bgl.setBumen(request.getParameter("bumen"));

        //设置bgl的gujiashi tel  memo

        bgl.setTel(request.getParameter("tel"));
        bgl.setMemo(request.getParameter("memo"));

        User zhuanxie = new User();
        User jszhuanxie = new User();
        User shenhe = new User();
        User kancha = new User();
        User shidikc = new User();
        User dingjia = new User();
        User jiazhigoutong = new User();
        User fuzeren =new User();
        Count ct = null;
        List<Count> cts = new ArrayList<>();
        if(request.getParameter("zhuanxie").length()>0){
            String[] zxbm = request.getParameter("zhuanxie").split("---");
            zhuanxie.setUsername(zxbm[0]);
            zhuanxie.setBumen(zxbm[1]);
            bgl.setZhuanxie(ud.finduseridbynameandbumen(zhuanxie));
            ct = new Count();
            ct.setUser(bgl.getZhuanxie());
            ct.setTjtype("zhuanxie");
            ct.setCount(1);
            cts.add(ct);

        }else {
            zhuanxie.setUserid(0);
            bgl.setZhuanxie(zhuanxie);
        }
        if(request.getParameter("kancha").length()>0){
            String[] kcbm = request.getParameter("kancha").split("---");
            kancha.setUsername(kcbm[0]);
            kancha.setBumen(kcbm[1]);
            bgl.setKancha(ud.finduseridbynameandbumen(kancha));
            ct = new Count();
            ct.setUser(bgl.getKancha());
            ct.setTjtype("kancha");
            ct.setCount(1);
            cts.add(ct);
        }else{
            kancha.setUserid(0);
            bgl.setKancha(kancha);
        }
        if(request.getParameter("shenhe").length()>0){
            if(request.getParameter("bumen").equals("新乡")){
                String[] shbm = request.getParameter("shenhe").split("---");
                shenhe.setUsername(shbm[0]);
                shenhe.setBumen(shbm[1]);
                bgl.setShenhe(ud.finduseridbynameandbumen(shenhe));
                ct = new Count();
                ct.setUser(bgl.getShenhe());
                ct.setTjtype("fgsshenhe");
                ct.setCount(1);
                cts.add(ct);
            }else{
                String[] shbm = request.getParameter("shenhe").split("---");
                shenhe.setUsername(shbm[0]);
                shenhe.setBumen(shbm[1]);
                bgl.setShenhe(ud.finduseridbynameandbumen(shenhe));
                ct = new Count();
                ct.setUser(bgl.getShenhe());
                ct.setTjtype("shenhe");
                ct.setCount(1);
                cts.add(ct);
            }

        }else{
            shenhe.setUserid(0);
            bgl.setShenhe(shenhe);
        }
        if(request.getParameter("jiazhigoutong").length()>0){
            String[] jzbm = request.getParameter("jiazhigoutong").split("---");
            jiazhigoutong.setUsername(jzbm[0]);
            jiazhigoutong.setBumen(jzbm[1]);
            bgl.setJiazhigoutong(ud.finduseridbynameandbumen(jiazhigoutong));
            ct = new Count();
            ct.setUser(bgl.getJiazhigoutong());
            ct.setTjtype("jiazhigoutong");
            ct.setCount(1);
            cts.add(ct);
        }else{
            jiazhigoutong.setUserid(0);
            bgl.setJiazhigoutong(jiazhigoutong);
        }
        if(request.getParameter("jszhuanxie").length()>0){
            String[] jzbm = request.getParameter("jszhuanxie").split("---");
            jszhuanxie.setUsername(jzbm[0]);
            jszhuanxie.setBumen(jzbm[1]);
            bgl.setJszhuanxie(ud.finduseridbynameandbumen(jszhuanxie));
            ct = new Count();
            ct.setUser(bgl.getJszhuanxie());
            ct.setTjtype("jszhuanxie");
            ct.setCount(1);
            cts.add(ct);
        }else{
            jszhuanxie.setUserid(0);
            bgl.setJszhuanxie(jszhuanxie);
        }
        if(request.getParameter("dingjia").length()>0){
            String[] jzbm = request.getParameter("dingjia").split("---");
            dingjia.setUsername(jzbm[0]);
            dingjia.setBumen(jzbm[1]);
            bgl.setDingjia(ud.finduseridbynameandbumen(dingjia));
            ct = new Count();
            ct.setUser(bgl.getDingjia());
            ct.setTjtype("dingjia");
            ct.setCount(1);
            cts.add(ct);
        }else{
            dingjia.setUserid(0);
            bgl.setDingjia(dingjia);
        }
        if(request.getParameter("shidikc").length()>0){
            String[] jzbm = request.getParameter("shidikc").split("---");
            shidikc.setUsername(jzbm[0]);
            shidikc.setBumen(jzbm[1]);
            bgl.setShidikc(ud.finduseridbynameandbumen(shidikc));
            ct = new Count();
            ct.setUser(bgl.getShidikc());
            ct.setTjtype("shidikc");
            ct.setCount(1);
            cts.add(ct);
        }else{
            shidikc.setUserid(0);
            bgl.setShidikc(shidikc);
        }
        if(request.getParameter("fuzeren").length()>0){
            String[] fzbm = request.getParameter("fuzeren").split("---");
            fuzeren.setUsername(fzbm[0]);
            fuzeren.setBumen(fzbm[1]);
            bgl.setFuzeren(ud.finduseridbynameandbumen(fuzeren));
            ct = new Count();
            ct.setUser(bgl.getFuzeren());
            ct.setTjtype("fuzeren");
            ct.setCount(1);
            cts.add(ct);

        }else {
            fuzeren.setUserid(0);
            bgl.setFuzeren(fuzeren);
        }






        //bgl 要有一个总的价格并且设置总价格

        map.put("bgl",bgl);
        map.put("cts",cts);
        return map;
    }
}
