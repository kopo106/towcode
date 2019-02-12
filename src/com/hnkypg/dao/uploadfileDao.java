package com.hnkypg.dao;

import com.hnkypg.pojo.BaoGao;
import com.hnkypg.pojo.BaoGaoList;

import com.hnkypg.pojo.Count;
import com.hnkypg.pojo.User;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by python on 2017-6-16.
 */
public class uploadfileDao {
    public Map loadypfile(File file){
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<BaoGao>();
        BaoGaoList bgl = null;
        List<BaoGaoList> bgls = new ArrayList<BaoGaoList>();
        String[] s = null;
        User zhuanxie =null;
        User shenhe =null;
        User kc =null;
        User sdkc =null;
        User jszx =null;
        User jzgt =null;
        User dingjia =null;
        User fuzeren =null;
        Count ct = null;
        List<Count> cts = new ArrayList<>();
        Map map = new HashMap();
        List<String> dataList= importCsv(file);
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                bg = new BaoGao();
                bgl = new BaoGaoList();
                s = data.split(",");
                System.out.println(s.length+"本行数据一共多少个");
                bg.setBgnum(s[0]);
                bg.setChanquanren(s[1]);
                bg.setZuoluo(s[3]);
                if(s[4].length()<1){
                    bg.setMianji(0);
                }else {
                    bg.setMianji(Float.parseFloat(s[4]));
                }

                bg.setNiandai(s[5]);
                bg.setSuo(s[6]);
                bg.setZong(s[7]);
                bg.setYongtu(s[8]);
                if(s[9].length()<1){
                    bg.setDanjia(0);
                }else {
                    bg.setDanjia(Float.parseFloat(s[9]));
                }
                if(s[10].length()<1){
                    bg.setZongjia(0);
                }else{
                    bg.setZongjia(Float.parseFloat(s[10]));
                }
                bg.setShidian(Date.valueOf(s[11]));
                bg.setChujudate(Date.valueOf(s[12]));
                bg.setProname(s[20]);
                bg.setPoint("保留二位");
                System.out.println(s[20]+"---"+s[21]+"---"+s[22]+"---");

                bgl.setState(1);
                bgl.setBaogaotype("预评报告");
                bgl.setBumen(s[23]);
                bgl.setBgnum(s[0]);
                bgl.setLaiyuan(s[2]);
                bgl.setZuoluo(s[3]);
                bgl.setShidian(Date.valueOf(s[11]));
                bgl.setChujudate(Date.valueOf(s[12]));
                bgl.setTel(s[21]);
                bgl.setMemo(s[22]);
                bgl.setZongjias(bg.getZongjia());
                System.out.println(s[13]+"--"+s[14]);
                System.out.println(s[13]);
                if(s[13].length()<1){
                    zhuanxie = new User();
                    zhuanxie.setUserid(0);
                    bgl.setZhuanxie(zhuanxie);
                }else {
                    zhuanxie = new User();
                    zhuanxie.setUserid(Integer.parseInt(s[13]));
                    bgl.setZhuanxie(zhuanxie);
                }
                if(s[14].length()<1){
                    shenhe = new User();
                    shenhe.setUserid(0);
                    bgl.setShenhe(shenhe);
                }else {
                    shenhe = new User();
                    shenhe.setUserid(Integer.parseInt(s[14]));
                    bgl.setShenhe(shenhe);

                }
                if(s[15].length()<1){
                    kc =new User();
                    kc.setUserid(0);
                    bgl.setKancha(kc);
                }else {
                    kc =new User();
                    kc.setUserid(Integer.parseInt(s[15]));
                    bgl.setKancha(kc);

                }
                if(s[16].length()<1){
                    sdkc = new User();
                    sdkc.setUserid(0);
                    bgl.setShidikc(sdkc);
                }else {
                    sdkc = new User();
                    sdkc.setUserid(Integer.parseInt(s[16]));
                    bgl.setShidikc(sdkc);

                }
                if(s[17].length()<1){
                    dingjia = new User();
                    dingjia.setUserid(0);
                    bgl.setDingjia(dingjia);
                }else {
                    dingjia = new User();
                    dingjia.setUserid(Integer.parseInt(s[17]));
                    bgl.setDingjia(dingjia);

                }
                if(s[18].length()<1){
                    jzgt =new User();
                    jzgt.setUserid(0);
                    bgl.setJiazhigoutong(jzgt);
                }else {
                    jzgt =new User();
                    jzgt.setUserid(Integer.parseInt(s[18]));
                    bgl.setJiazhigoutong(jzgt);

                }
                if(s[19].length()<1){
                    jszx = new User();
                    jszx.setUserid(0);
                    bgl.setJszhuanxie(jszx);
                }else {
                    jszx = new User();
                    jszx.setUserid(Integer.parseInt(s[19]));
                    bgl.setJszhuanxie(jszx);

                }
                if(s[24].length()<1){
                    fuzeren = new User();
                    fuzeren.setUserid(0);
                    bgl.setFuzeren(fuzeren);
                }else {
                    fuzeren = new User();
                    fuzeren.setUserid(Integer.parseInt(s[24]));
                    bgl.setFuzeren(fuzeren);
                }
                bgl.setCtstate(2);
                bgs.add(bg);
                bgls.add(bgl);

            }
        }
        map.put("bgs",bgs);
        map.put("bgls",bgls);

        return map;
    }

    public Map loadzpfile(File file){
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<BaoGao>();
        BaoGaoList bgl = null;
        List<BaoGaoList> bgls = new ArrayList<BaoGaoList>();
        String[] s = null;
        User zhuanxie =null;
        User shenhe =null;
        User kc =null;
        User sdkc =null;
        User jszx =null;
        User jzgt =null;
        User dingjia =null;
        User fuzeren =null;
        Map map = new HashMap();
        List<String> dataList= importCsv(file);
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                bg = new BaoGao();
                bgl = new BaoGaoList();
                s = data.split(",");
                bg.setBgnum(s[0]);
                bg.setChanquanren(s[1]);
                bg.setZuoluo(s[3]);
                bg.setMianji(Float.parseFloat(s[4]));
                bg.setNiandai(s[5]);
                bg.setSuo(s[6]);
                bg.setZong(s[7]);
                bg.setYongtu(s[8]);
                bg.setDanjia(Float.parseFloat(s[9]));
                bg.setZongjia(Float.parseFloat(s[10]));
                bg.setShidian(Date.valueOf(s[11]));
                bg.setChujudate(Date.valueOf(s[12]));
                bg.setProname(s[21]);
                bg.setPoint("保留二位");

                bgl.setZongjias(Float.parseFloat(s[10]));
                bgl.setMemo(s[23]);
                bgl.setTel(s[22]);
                bgl.setGujiashi(s[20]);
                bgl.setState(3);
                bgl.setBaogaotype("正式报告");
                bgl.setBumen(s[24]);
                bgl.setBgnum(s[0]);

                bgl.setLaiyuan(s[2]);
                bgl.setZuoluo(s[3]);
                bgl.setShidian(Date.valueOf(s[11]));
                bgl.setChujudate(Date.valueOf(s[12]));
                System.out.println(s[13]+"--"+s[14]);
                System.out.println(s[13]);
                if(s[13].length()<1){
                    zhuanxie = new User();
                    zhuanxie.setUserid(0);
                    bgl.setZhuanxie(zhuanxie);
                }else {
                    zhuanxie = new User();
                    zhuanxie.setUserid(Integer.parseInt(s[13]));
                    bgl.setZhuanxie(zhuanxie);
                }
                if(s[14].length()<1){
                    shenhe = new User();
                    shenhe.setUserid(0);
                    bgl.setShenhe(shenhe);
                }else {
                    shenhe = new User();
                    shenhe.setUserid(Integer.parseInt(s[14]));
                    bgl.setShenhe(shenhe);

                }
                if(s[15].length()<1){
                    kc =new User();
                    kc.setUserid(0);
                    bgl.setKancha(kc);
                }else {
                    kc =new User();
                    kc.setUserid(Integer.parseInt(s[15]));
                    bgl.setKancha(kc);

                }
                if(s[16].length()<1){
                    sdkc = new User();
                    sdkc.setUserid(0);
                    bgl.setShidikc(sdkc);
                }else {
                    sdkc = new User();
                    sdkc.setUserid(Integer.parseInt(s[16]));
                    bgl.setShidikc(sdkc);

                }
                if(s[17].length()<1){
                    dingjia = new User();
                    dingjia.setUserid(0);
                    bgl.setDingjia(dingjia);
                }else {
                    dingjia = new User();
                    dingjia.setUserid(Integer.parseInt(s[17]));
                    bgl.setDingjia(dingjia);

                }
                if(s[18].length()<1){
                    jzgt =new User();
                    jzgt.setUserid(0);
                    bgl.setJiazhigoutong(jzgt);
                }else {
                    jzgt =new User();
                    jzgt.setUserid(Integer.parseInt(s[18]));
                    bgl.setJiazhigoutong(jzgt);

                }
                if(s[19].length()<1){
                    jszx = new User();
                    jszx.setUserid(0);
                    bgl.setJszhuanxie(jszx);
                }else {
                    jszx = new User();
                    jszx.setUserid(Integer.parseInt(s[19]));
                    bgl.setJszhuanxie(jszx);

                }
                if(s[25].length()<1){
                    fuzeren = new User();
                    fuzeren.setUserid(0);
                    bgl.setFuzeren(fuzeren);
                }else {
                    fuzeren = new User();
                    fuzeren.setUserid(Integer.parseInt(s[25]));
                    bgl.setFuzeren(fuzeren);
                }
                bgl.setCtstate(2);
                bgs.add(bg);
                bgls.add(bgl);
            }
        }
        map.put("bgs",bgs);
        map.put("bgls",bgls);
        return map;
    }

    public Map loadfgsfile(File file){
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<BaoGao>();
        BaoGaoList bgl = null;
        List<BaoGaoList> bgls = new ArrayList<BaoGaoList>();
        String[] s = null;
        User zhuanxie =null;
        User shenhe =null;
        User kc =null;
        User sdkc =null;
        User jszx =null;
        User jzgt =null;
        User dingjia =null;
        User fuzeren =null;
        Map map = new HashMap();
        List<String> dataList= importCsv(file);
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                bg = new BaoGao();
                bgl = new BaoGaoList();
                s = data.split(",");
                System.out.println(s.length+"本行数据一共多少个");
                bg.setBgnum(s[0]);
                bg.setChanquanren(s[1]);
                bg.setZuoluo(s[3]);
                bg.setMianji(Float.parseFloat(s[4]));
                bg.setNiandai(s[5]);
                bg.setSuo(s[6]);
                bg.setZong(s[7]);
                bg.setYongtu(s[8]);
                bg.setDanjia(Float.parseFloat(s[9]));
                bg.setZongjia(Float.parseFloat(s[10]));
                bg.setShidian(Date.valueOf(s[11]));
                bg.setChujudate(Date.valueOf(s[12]));
                bg.setPoint("保留二位");
                bg.setProname(s[21]);



                bgl.setState(5);
                bgl.setBaogaotype("分公司报告审核");
                bgl.setBumen(s[24]);
                bgl.setGujiashi(s[20]);
                bgl.setMemo(s[23]);
                bgl.setTel(s[22]);
                bgl.setBgnum(s[0]);
                bgl.setZongjias(Float.parseFloat(s[10]));

                bgl.setLaiyuan(s[2]);
                bgl.setZuoluo(s[3]);
                bgl.setShidian(Date.valueOf(s[11]));
                bgl.setChujudate(Date.valueOf(s[12]));
                System.out.println(s[13]+"--"+s[14]);
                System.out.println(s[13]);
                if(s[13].length()<1){
                    zhuanxie = new User();
                    zhuanxie.setUserid(0);
                    bgl.setZhuanxie(zhuanxie);
                }else {
                    zhuanxie = new User();
                    zhuanxie.setUserid(Integer.parseInt(s[13]));
                    bgl.setZhuanxie(zhuanxie);
                }
                if(s[14].length()<1){
                    shenhe = new User();
                    shenhe.setUserid(0);
                    bgl.setShenhe(shenhe);
                }else {
                    shenhe = new User();
                    shenhe.setUserid(Integer.parseInt(s[14]));
                    bgl.setShenhe(shenhe);

                }
                if(s[15].length()<1){
                    kc =new User();
                    kc.setUserid(0);
                    bgl.setKancha(kc);
                }else {
                    kc =new User();
                    kc.setUserid(Integer.parseInt(s[15]));
                    bgl.setKancha(kc);

                }
                if(s[16].length()<1){
                    sdkc = new User();
                    sdkc.setUserid(0);
                    bgl.setShidikc(sdkc);
                }else {
                    sdkc = new User();
                    sdkc.setUserid(Integer.parseInt(s[16]));
                    bgl.setShidikc(sdkc);

                }
                if(s[17].length()<1){
                    dingjia = new User();
                    dingjia.setUserid(0);
                    bgl.setDingjia(dingjia);
                }else {
                    dingjia = new User();
                    dingjia.setUserid(Integer.parseInt(s[17]));
                    bgl.setDingjia(dingjia);

                }
                if(s[18].length()<1){
                    jzgt =new User();
                    jzgt.setUserid(0);
                    bgl.setJiazhigoutong(jzgt);
                }else {
                    jzgt =new User();
                    jzgt.setUserid(Integer.parseInt(s[18]));
                    bgl.setJiazhigoutong(jzgt);

                }
                if(s[19].length()<1){
                    jszx = new User();
                    jszx.setUserid(0);
                    bgl.setJszhuanxie(jszx);
                }else {
                    jszx = new User();
                    jszx.setUserid(Integer.parseInt(s[19]));
                    bgl.setJszhuanxie(jszx);

                }
                if(s[25].length()<1){
                    fuzeren = new User();
                    fuzeren.setUserid(0);
                    bgl.setFuzeren(fuzeren);
                }else {
                    fuzeren = new User();
                    fuzeren.setUserid(Integer.parseInt(s[25]));
                    bgl.setFuzeren(fuzeren);
                }


//                System.out.println(data);
                bgl.setCtstate(2);
                bgs.add(bg);
                bgls.add(bgl);

            }
        }
        map.put("bgs",bgs);
        map.put("bgls",bgls);

        return map;
    }

    public Map loadypzfile(File file){
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<BaoGao>();
        BaoGaoList bgl = null;
        List<BaoGaoList> bgls = new ArrayList<BaoGaoList>();
        String[] s = null;
        User zhuanxie =null;
        User shenhe =null;
        User kc =null;
        User sdkc =null;
        User jszx =null;
        User jzgt =null;
        User dingjia =null;
        User fuzeren =null;
        Map map = new HashMap();
        List<String> dataList= importCsv(file);
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                bg = new BaoGao();
                bgl = new BaoGaoList();
                s = data.split(",");
                System.out.println(s.length+"本行数据一共多少个");
                bg.setBgnum(s[0]);
                bg.setChanquanren(s[1]);
                bg.setZuoluo(s[3]);
                bg.setMianji(Float.parseFloat(s[4]));
                bg.setNiandai(s[5]);
                bg.setSuo(s[6]);
                bg.setZong(s[7]);
                bg.setYongtu(s[8]);
                bg.setDanjia(Float.parseFloat(s[9]));
                bg.setZongjia(Float.parseFloat(s[10]));
                bg.setShidian(Date.valueOf(s[11]));
                bg.setChujudate(Date.valueOf(s[12]));
                bg.setProname(s[20]);
                bg.setPoint("保留二位");




                bgl.setState(2);
                bgl.setBaogaotype("预评报告");
                bgl.setZongjias(Float.parseFloat(s[10]));
                bgl.setTel(s[21]);
                bgl.setMemo(s[22]);
                bgl.setBumen(s[23]);
                bgl.setBgnum(s[0]);

                bgl.setLaiyuan(s[2]);
                bgl.setZuoluo(s[3]);
                bgl.setShidian(Date.valueOf(s[11]));
                bgl.setChujudate(Date.valueOf(s[12]));
                System.out.println(s[13]+"--"+s[14]);
                System.out.println(s[13]);
                if(s[13].length()<1){
                    zhuanxie = new User();
                    zhuanxie.setUserid(0);
                    bgl.setZhuanxie(zhuanxie);
                }else {
                    zhuanxie = new User();
                    zhuanxie.setUserid(Integer.parseInt(s[13]));
                    bgl.setZhuanxie(zhuanxie);
                }
                if(s[14].length()<1){
                    shenhe = new User();
                    shenhe.setUserid(0);
                    bgl.setShenhe(shenhe);
                }else {
                    shenhe = new User();
                    shenhe.setUserid(Integer.parseInt(s[14]));
                    bgl.setShenhe(shenhe);

                }
                if(s[15].length()<1){
                    kc =new User();
                    kc.setUserid(0);
                    bgl.setKancha(kc);
                }else {
                    kc =new User();
                    kc.setUserid(Integer.parseInt(s[15]));
                    bgl.setKancha(kc);

                }
                if(s[16].length()<1){
                    sdkc = new User();
                    sdkc.setUserid(0);
                    bgl.setShidikc(sdkc);
                }else {
                    sdkc = new User();
                    sdkc.setUserid(Integer.parseInt(s[16]));
                    bgl.setShidikc(sdkc);

                }
                if(s[17].length()<1){
                    dingjia = new User();
                    dingjia.setUserid(0);
                    bgl.setDingjia(dingjia);
                }else {
                    dingjia = new User();
                    dingjia.setUserid(Integer.parseInt(s[17]));
                    bgl.setDingjia(dingjia);

                }
                if(s[18].length()<1){
                    jzgt =new User();
                    jzgt.setUserid(0);
                    bgl.setJiazhigoutong(jzgt);
                }else {
                    jzgt =new User();
                    jzgt.setUserid(Integer.parseInt(s[18]));
                    bgl.setJiazhigoutong(jzgt);

                }
                if(s[19].length()<1){
                    jszx = new User();
                    jszx.setUserid(0);
                    bgl.setJszhuanxie(jszx);
                }else {
                    jszx = new User();
                    jszx.setUserid(Integer.parseInt(s[19]));
                    bgl.setJszhuanxie(jszx);

                }
                if(s[24].length()<1){
                    fuzeren = new User();
                    fuzeren.setUserid(0);
                    bgl.setFuzeren(fuzeren);
                }else {
                    fuzeren = new User();
                    fuzeren.setUserid(Integer.parseInt(s[24]));
                    bgl.setFuzeren(fuzeren);
                }


//                System.out.println(data);
                bgl.setCtstate(2);
                bgs.add(bg);
                bgls.add(bgl);

            }
        }
        map.put("bgs",bgs);
        map.put("bgls",bgls);

        return map;
    }


    public Map loadzzpfile(File file){
        BaoGao bg = null;
        List<BaoGao> bgs = new ArrayList<BaoGao>();
        BaoGaoList bgl = null;
        List<BaoGaoList> bgls = new ArrayList<BaoGaoList>();
        String[] s = null;
        User zhuanxie =null;
        User shenhe =null;
        User kc =null;
        User sdkc =null;
        User jszx =null;
        User jzgt =null;
        User dingjia =null;
        User fuzeren =null;
        Map map = new HashMap();
        List<String> dataList= importCsv(file);
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                bg = new BaoGao();
                bgl = new BaoGaoList();
                s = data.split(",");
                bg.setBgnum(s[0]);
                bg.setChanquanren(s[1]);
                bg.setZuoluo(s[3]);
                bg.setMianji(Float.parseFloat(s[4]));
                bg.setNiandai(s[5]);
                bg.setSuo(s[6]);
                bg.setZong(s[7]);
                bg.setYongtu(s[8]);
                bg.setDanjia(Float.parseFloat(s[9]));
                bg.setZongjia(Float.parseFloat(s[10]));
                bg.setShidian(Date.valueOf(s[11]));
                bg.setChujudate(Date.valueOf(s[12]));
                bg.setPoint("保留二位");
                bg.setProname(s[21]);

                bg.setTrave(1);

                bgl.setState(4);
                bgl.setBaogaotype("正式报告");
                bgl.setBumen(s[24]);
                bgl.setMemo(s[23]);
                bgl.setTel(s[22]);
                bgl.setGujiashi(s[20]);
                bgl.setBgnum(s[0]);
                bgl.setLaiyuan(s[2]);
                bgl.setZuoluo(s[3]);
                bgl.setShidian(Date.valueOf(s[11]));
                bgl.setChujudate(Date.valueOf(s[12]));
                bgl.setTrave(1);
                System.out.println(s[13]+"--"+s[14]);
                System.out.println(s[13]);
                if(s[13].length()<1){
                    zhuanxie = new User();
                    zhuanxie.setUserid(0);
                    bgl.setZhuanxie(zhuanxie);
                }else {
                    zhuanxie = new User();
                    zhuanxie.setUserid(Integer.parseInt(s[13]));
                    bgl.setZhuanxie(zhuanxie);
                }
                if(s[14].length()<1){
                    shenhe = new User();
                    shenhe.setUserid(0);
                    bgl.setShenhe(shenhe);
                }else {
                    shenhe = new User();
                    shenhe.setUserid(Integer.parseInt(s[14]));
                    bgl.setShenhe(shenhe);

                }
                if(s[15].length()<1){
                    kc =new User();
                    kc.setUserid(0);
                    bgl.setKancha(kc);
                }else {
                    kc =new User();
                    kc.setUserid(Integer.parseInt(s[15]));
                    bgl.setKancha(kc);

                }
                if(s[16].length()<1){
                    sdkc = new User();
                    sdkc.setUserid(0);
                    bgl.setShidikc(sdkc);
                }else {
                    sdkc = new User();
                    sdkc.setUserid(Integer.parseInt(s[16]));
                    bgl.setShidikc(sdkc);

                }
                if(s[17].length()<1){
                    dingjia = new User();
                    dingjia.setUserid(0);
                    bgl.setDingjia(dingjia);
                }else {
                    dingjia = new User();
                    dingjia.setUserid(Integer.parseInt(s[17]));
                    bgl.setDingjia(dingjia);

                }
                if(s[18].length()<1){
                    jzgt =new User();
                    jzgt.setUserid(0);
                    bgl.setJiazhigoutong(jzgt);
                }else {
                    jzgt =new User();
                    jzgt.setUserid(Integer.parseInt(s[18]));
                    bgl.setJiazhigoutong(jzgt);

                }
                if(s[19].length()<1){
                    jszx = new User();
                    jszx.setUserid(0);
                    bgl.setJszhuanxie(jszx);
                }else {
                    jszx = new User();
                    jszx.setUserid(Integer.parseInt(s[19]));
                    bgl.setJszhuanxie(jszx);

                }

                if(s[25].length()<1){
                    fuzeren = new User();
                    fuzeren.setUserid(0);
                    bgl.setFuzeren(fuzeren);
                }else {
                    fuzeren = new User();
                    fuzeren.setUserid(Integer.parseInt(s[25]));
                    bgl.setFuzeren(fuzeren);
                }

                bgl.setCtstate(2);

                bgs.add(bg);
                bgls.add(bgl);
            }
        }
        map.put("bgs",bgs);
        map.put("bgls",bgls);
        return map;
    }


    /**
     * 导出
     *
     * @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataList 数据
     * @return
     */
    public static boolean exportCsv(File file, List<String> dataList){
        boolean isSucess=false;

        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    /**
     * 导入
     *
     * @param file csv文件(路径+文件)
     * @return
     */
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();

        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }
}
