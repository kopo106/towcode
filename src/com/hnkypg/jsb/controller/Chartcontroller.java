package com.hnkypg.jsb.controller;

import com.google.gson.Gson;

import com.hnkypg.dao.TongJiDao;

import com.hnkypg.pojo.Tontjia;
import com.hnkypg.pojo.sreach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Controller
@SessionAttributes("user")
public class Chartcontroller {


    //获取查询的统计图表
    @ResponseBody
    @RequestMapping(value = "/tubiaoajax.do" , method = RequestMethod.POST, produces = "application/json ;charset=UTF-8")
    public Map tubiaoajax(@RequestParam String bumen,@RequestParam String year,@RequestParam String month,@RequestParam String baogaotype ){
        sreach s = new sreach();

        s.setBaogaotype(baogaotype);
        s.setBumen(bumen);
        s.setYearmonth(year+"-"+month);

//        ArrayList<String> users = new ArrayList<>();
//        ArrayList<Float> zxs = new ArrayList<>();
//        ArrayList<Float> shs = new ArrayList<>();
//        ArrayList<Float> sdkcs = new ArrayList<>();


        Gson gson = new Gson();
        TongJiDao tjd = new TongJiDao();


        List<Tontjia> tjall = tjd.tubiaocheck(s);
        int c = tjall.size();
        String name = null;
        String[] users =  new String[c];
        String[] zxs =  new String[c];
        String[] shs =  new String[c];
        String[] sdkcs =  new String[c];
        for(int i =0;i<tjall.size();i++){
           name = tjall.get(i).getUser().getUsername();
           users[i] = name;
           zxs[i] = String.valueOf(tjall.get(i).getZhuanxie());
           shs[i] = String.valueOf(tjall.get(i).getShenhe());
           sdkcs[i] = String.valueOf(tjall.get(i).getShidikc());
        }

        Map map = new HashMap();
        map.put("users",users);
        map.put("shs",shs);
        map.put("sdkcs",sdkcs);
        map.put("zxs",zxs);

//        String jsondata = gson.toJson(map);
//        System.out.println(jsondata);

        return map;
    }


}
