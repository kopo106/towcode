package com.hnkypg.jsb.controller;

import com.google.gson.Gson;
import com.hnkypg.Util.*;
import com.hnkypg.dao.*;
import com.hnkypg.pojo.*;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Tbl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by python on 2017/4/16 0016.
 */

@Controller
@SessionAttributes("user")
public class maincontroller {

    //登录到主界面
    @RequestMapping(value = "/index.do")
    public String index(HttpSession session){
       User user =(User)session.getAttribute("user");
       if(user.getBumen().equals("洛阳")||user.getBumen().equals("商丘")){
           return "ly/fgsindex";
       }else{
           return "zz/index";
       }

    }

    //登录到查询页面
    @RequestMapping(value = "/select.do")
    public String select(){

        return "zz/select";
    }

    //获取报告子表内容
    @ResponseBody
    @RequestMapping(value = "/indexchildajax.do", method=RequestMethod.GET,produces = "application/json ;charset=UTF-8")
    public String indexchildajax(@RequestParam int bglid){
        BaoGaoDao bgd = new BaoGaoDao();
        Gson gson = new Gson();
        List<BaoGao> bgs = bgd.findbgsbybglid(bglid);
        String jsondata = gson.toJson(bgs);
        int counts = bgs.size();
        jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
        System.out.println(jsondata);

        return jsondata;
    }

    //获取报告清单内容
    @ResponseBody
    @RequestMapping(value = "/indexajax.do" , method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String indexajax(HttpServletRequest request,ModelMap model){
        sreach s = new sreach();
        String l =request.getParameter("limit");
        String o =request.getParameter("offset");
        if(l==null&&o == null){
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            s.setSelect(request.getParameter("select"));
            if(startdate.length()>0){
                s.setStartdate(Date.valueOf(startdate));
            }
            if(enddate.length()>0){
                s.setEnddate(Date.valueOf(enddate));
            }

            s.setText(request.getParameter("text"));
            int counts =0 ;
            Gson gson = new Gson();
            List<BaoGaoList> bgls= new ArrayList<BaoGaoList>();
            BaoGaoDao bgd = new BaoGaoDao();
            if(s.getSelect().equals("all")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.bglistbydatedown(s);
                        counts = bgd.allcountsbydatedown(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    System.out.println("走的是这里把");
                    bgls = bgd.bglistdown();
                    counts =bgd.allcountsdown();
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }
            String jsondata = gson.toJson(bgls);
            jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
            System.out.println(jsondata);
            System.out.println(counts);
            return jsondata;

        }else{
            int limit = Integer.parseInt(request.getParameter("limit"));
            int offset = Integer.parseInt(request.getParameter("offset"));
            s.setLimit(limit);
            s.setOffset(offset);
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            s.setSelect(request.getParameter("select"));
            if(startdate.isEmpty()){
                s.setStartdate(null);
            }else {
                s.setStartdate(Date.valueOf(startdate));
            }
            if(enddate.isEmpty()){
                s.setEnddate(null);
            }else{
                s.setEnddate(Date.valueOf(enddate));
            }

            s.setText(request.getParameter("text"));
            int counts =0 ;
            Gson gson = new Gson();
            List<BaoGaoList> bgls= new ArrayList<BaoGaoList>();
            BaoGaoDao bgd = new BaoGaoDao();
            if(s.getSelect().equals("all")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.bglistbydate(s);
                        counts = bgd.allcountsbydate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.bglist(s);
                    counts =bgd.allcounts();
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }else if(s.getSelect().equals("bgnum")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.findbglsbybgnumanddate(s);
                        counts = bgd.allcountsbybgnumanddate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.findbglsbybgnum(s);
                    counts = bgd.allcountsbybgnum(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            }else if(s.getSelect().equals("zuoluo")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyzldate(s);
                        counts = bgd.allcountsbyzldate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.bglistbyzuoluo(s);
                    counts = bgd.allcountsbyzuoluo(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            }else if(s.getSelect().equals("proname")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbypronameanddate(s);
                        counts = bgd.allcountBaoGaoListbypronameandate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyproname(s);
                    counts = bgd.allcountBaoGaoListbyproname(s);
                    System.out.println(counts);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }

            }else if(s.getSelect().equals("chanquanren")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbycqranddate(s);
                        counts = bgd.countbycqrandate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbycqr(s);
                    counts = bgd.countbycqr(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }

            }else if(s.getSelect().equals("zxorjszx")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyzxorjszxdate(s);
                        counts = bgd.countbyzxorjszxdate(s);

                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyzxorjszx(s);
                    counts = bgd.countbyzxorjszx(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }else if(s.getSelect().equals("laiyuan")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbylaiyuandate(s);
                        counts = bgd.countbylaiyuandate(s);

                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbylaiyuan(s);
                    counts = bgd.countbylaiyuan(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }


            String jsondata = gson.toJson(bgls);
            jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
            System.out.println(jsondata);
            System.out.println(counts);
            return jsondata;
        }

    }

    //添加报告页面
    @RequestMapping(value = "/input.do",method = RequestMethod.GET)
    public String input(HttpSession session, ModelMap model){
//        User user =(User)session.getAttribute("user");
//        UserDao ud = new UserDao();
//        List<User> users = new ArrayList<User>();
//        users = ud.finduserbybumen(user.getBumen());
//        model.addAttribute("users",users);
        return "zz/input";
    }

    //添加报告页面
    @RequestMapping(value = "/inputupfile.do",method = RequestMethod.GET)
    public String inputupfile(HttpSession session, ModelMap model){

        return "zz/inputupfile";
    }


    //添加报告处理完并返回主页面
    @RequestMapping(value = "inputfix.do",method = RequestMethod.POST)
    public String inputfix(HttpServletRequest request,ModelMap model,HttpSession session){
        jiaoyan jy = new jiaoyan();
        bgutil bgt = new bgutil();
        String info = jy.inputpd(request);
        String bdwct =request.getParameter("bdwct");
        if(info.equals("success") == false){
            model.addAttribute("error",info);
            Map map = bgt.bglerror(request);
            BaoGaoList bgl = (BaoGaoList) map.get("bgl");
            List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
            model.addAttribute("bgl",bgl);
            model.addAttribute("bgs",bgs);
            model.addAttribute("bdwct",bdwct);
//            return "zz/input_error";
            return "zz/input" ;
        }
        Map map = bgt.bglfirstset(request);
        BaoGaoList bgl = (BaoGaoList) map.get("bgl");
        bgl.setCreater((User) session.getAttribute("user"));
        java.util.Date  date =new java.util.Date();
        java.sql.Date  data1 =new java.sql.Date(date.getTime());
        bgl.setCreatedate(data1);
        bgl.setCtstate(3);
        List<Count> cts = (List<Count>)map.get("cts");
        List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
        BaoGaoDao bgd = new BaoGaoDao();
        if(bgd.findbglidbybunum(bgl.getBgnum())>0){
            model.addAttribute("error","数据库中已存在该报告编号，请核查一下！");
            return "zz/input_error";
        }else{
            bgd.insertbaogaolist(bgl);
            bgl.setId(bgd.findbglidbybunum(bgl.getBgnum()));
            for(int i =0; i<bgs.size();i++){
                bgs.get(i).setBglid(bgl.getId());
            }
            for(int j =0; j<cts.size();j++){
                cts.get(j).setBgl(bgl);
            }
            bgd.insertbaogaos(bgs);
            TongJiDao tjd = new TongJiDao();
            tjd.insertTj(cts);
            model.addAttribute("success","录入成功");
            return "zz/input_ok";
        }


    }

    //一部和二部添加报告页面
    @RequestMapping(value = "/inputa.do",method = RequestMethod.GET)
    public String logina(HttpSession session, ModelMap model){
//        User user =(User)session.getAttribute("user");
//        UserDao ud = new UserDao();
//        List<User> users = new ArrayList<User>();
//        users = ud.finduserbybumen(user.getBumen());
//        model.addAttribute("users",users);
        return "zz/inputa";
    }

    //编辑报告页面
    @RequestMapping(value = "/edit.do",method = RequestMethod.GET)
    public String edit(int bglid, ModelMap model,HttpSession session){
        System.out.println(bglid);
        UserDao ud = new UserDao();
        BaoGaoList bgl =new BaoGaoList();
        List<BaoGao> bgs = new ArrayList<>();
        BaoGaoDao bgd =new BaoGaoDao();
        bgl = bgd.findbglbyid(bglid);
        bgs = bgd.findbgsbybglid(bglid);
        bgl.setZhuanxie(ud.finduseridbyname(bgl.getZhuanxie()));
        bgl.setShenhe(ud.finduseridbyname(bgl.getShenhe()));
        bgl.setKancha(ud.finduseridbyname(bgl.getKancha()));
        bgl.setJiazhigoutong(ud.finduseridbyname(bgl.getJiazhigoutong()));
        bgl.setJszhuanxie(ud.finduseridbyname(bgl.getJszhuanxie()));
        bgl.setShidikc(ud.finduseridbyname(bgl.getShidikc()));
        bgl.setDingjia(ud.finduseridbyname(bgl.getDingjia()));
        bgl.setFuzeren(ud.finduseridbyname(bgl.getFuzeren()));
        String  bdwct = null;
//        if(bgs.size()<1){
//
//        }
        for(int i = 0 ; i < bgs.size();i++){
            if(i==0){
                bdwct = String.valueOf(1);
            }else {
                bdwct = bdwct+","+String.valueOf(i+1);
            }

        }
        System.out.println(bdwct);
        for(int j= 0; j<bgs.size();j++){
            System.out.println(bgs.get(j).getProname()+"+++"+bgs.get(j).getBgnum()+"+++++");
        }
        model.addAttribute("bgl",bgl);
        model.addAttribute("bgs",bgs);
        model.addAttribute("bdwct",bdwct);
        User user = (User)session.getAttribute("user");
        if(user.getBumen().equals("技术部")){
            return "zz/edit";
        }else{
            return "zz/edita";
        }

    }

    //UPDATE报告处理完并返回主页面
    @RequestMapping(value = "updateedit.do",method = RequestMethod.POST)
    public String updateedit(HttpServletRequest request, ModelMap model,HttpSession session){
        BaoGaoDao bgd = new BaoGaoDao();
        BaoGaoList bgl1=bgd.findbglbyid(Integer.parseInt(request.getParameter("bglid")));
        jiaoyan jy = new jiaoyan();
        String info =null;
        if(bgl1.getState()==4){
            info = jy.travejy(request);
        }else{
            info = jy.inputpd(request);
        }

        bgutil bgt = new bgutil();

        if(info.equals("success") == false){
            String bglid = request.getParameter("bglid");
            String bdwct =request.getParameter("bdwct");
            model.addAttribute("error",info);
            Map map = bgt.bglerror(request);
            BaoGaoList bgl = (BaoGaoList) map.get("bgl");
            List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
            bgl.setId(Integer.parseInt(bglid));
            model.addAttribute("bgl",bgl);
            model.addAttribute("bgs",bgs);
            model.addAttribute("bdwct",bdwct);
            model.addAttribute("bglid",bglid);
            return "zz/edit";
        }

        Map map = bgt.bglfirstset(request);
        BaoGaoList bgl = (BaoGaoList) map.get("bgl");
        List<Count> cts = (List<Count>)map.get("cts");
        List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");

        bgl.setId(Integer.parseInt(request.getParameter("bglid")));
        bgl.setUpdater((User)session.getAttribute("user"));
        java.util.Date  date =new java.util.Date();
        java.sql.Date  data1 =new java.sql.Date(date.getTime());
        bgl.setUpdatetime(data1);
        bgd.updatebglbybglid(bgl);

        for(int i =0; i<bgs.size();i++){
            bgs.get(i).setBglid(bgl.getId());
        }
        for(int j =0; j<cts.size();j++){
            cts.get(j).setBgl(bgl);
        }

        bgd.delbgbybglid(bgl.getId());
        bgd.insertbaogaos(bgs);

        TongJiDao tjd = new TongJiDao();
        tjd.deltjbybglid(bgl.getId());
        tjd.insertTj(cts);


        model.addAttribute("success","更新报告成功");
        return "zz/edit_ok";

    }

    //报告类型转换编辑报告页面
    @RequestMapping(value = "/trave.do",method = RequestMethod.GET)
    public String trave(int bglid, ModelMap model,HttpSession session){
        System.out.println(bglid);
        UserDao ud = new UserDao();
        BaoGaoDao bgd =new BaoGaoDao();
        BaoGaoList bgl = bgd.findbglbyid(bglid);
        List<BaoGao> bgs = bgd.findbgsbybglid(bglid);

        if(bgl.getState() == 2 ){
            model.addAttribute("error","预评已经转过正式报告！！");
            return "zz/trave_error";
        }else if(bgl.getState()==5){
            model.addAttribute("error","分公司报告审核不需要转正式报告");
            return "zz/trave_error";
        }else if(bgl.getState()==3){
            model.addAttribute("error","正式报告不需要转正式报告");
            return "zz/trave_error";
        }else if(bgl.getState()==4){
            model.addAttribute("error","已转正式报告不需要转正式报告");
            return "zz/trave_error";
        }else{
            bgl.setZhuanxie(ud.finduseridbyname(bgl.getZhuanxie()));
            bgl.setShenhe(ud.finduseridbyname(bgl.getShenhe()));
            bgl.setKancha(ud.finduseridbyname(bgl.getKancha()));
            bgl.setJiazhigoutong(ud.finduseridbyname(bgl.getJiazhigoutong()));
            bgl.setJszhuanxie(ud.finduseridbyname(bgl.getJszhuanxie()));
            bgl.setShidikc(ud.finduseridbyname(bgl.getShidikc()));
            bgl.setDingjia(ud.finduseridbyname(bgl.getDingjia()));
            bgl.setFuzeren(ud.finduseridbyname(bgl.getFuzeren()));

            String  bdwct = null;
            for(int i = 0 ; i < bgs.size();i++){
                if(i==0){
                    bdwct = String.valueOf(1);
                }else {
                    bdwct = bdwct+","+String.valueOf(i+1);
                }

            }
            System.out.println(bdwct);

            for(int j= 0; j<bgs.size();j++){
                System.out.println(bgs.get(j).getProname()+"+++"+bgs.get(j).getBgnum()+"+++++");
            }
            model.addAttribute("bgl",bgl);
            model.addAttribute("bgs",bgs);
            model.addAttribute("bdwct",bdwct);
            User user = (User)session.getAttribute("user");
            if(user.getBumen().equals("技术部")){
                return "zz/trave";
            }else {
                model.addAttribute("error","一部和二部不统计正式报告，无需转正评");
                return "zz/trave_error";
            }

        }
//        else{
//            model.addAttribute("error","正式报告无需再次转换");
//            return  "trave_error";
//        }

    }


    //报告类型转换处理完并返回主页面
    @RequestMapping(value = "traveedit.do",method = RequestMethod.POST)
    public String traveedit(HttpServletRequest request,ModelMap model){
        jiaoyan jy = new jiaoyan();
        String info = jy.travejy(request);
        bgutil bgt = new bgutil();
        if(info.equals("success") == false){
            String bglid = request.getParameter("bglid");
            String bdwct =request.getParameter("bdwct");
            model.addAttribute("error",info);
            Map map = bgt.bglerror(request);
            BaoGaoList bgl = (BaoGaoList) map.get("bgl");
            List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
            bgl.setId(Integer.parseInt(bglid));
            model.addAttribute("bgl",bgl);
            model.addAttribute("bgs",bgs);
            model.addAttribute("bdwct",bdwct);
            model.addAttribute("bglid",bglid);
            return "zz/trave";
        }

        Map map = bgt.bgltraveset(request);
        BaoGaoList bgl = (BaoGaoList) map.get("bgl");
        List<Count> cts = (List<Count>)map.get("cts");
        List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
        BaoGaoDao bgd = new BaoGaoDao();

        bgd.updatebglstatebyid(Integer.parseInt(request.getParameter("bglid")));
        bgl.setCtstate(3);
        bgd.insertbaogaolist(bgl);

        bgl.setId(bgd.findbglidbystrave(bgl.getBgnum()));
        for(int i =0; i<bgs.size();i++){
            bgs.get(i).setBglid(bgl.getId());
        }
        for(int j =0; j<cts.size();j++){
            cts.get(j).setBgl(bgl);
        }
        bgd.insertbaogaos(bgs);
        TongJiDao tjd = new TongJiDao();
        tjd.insertTj(cts);
        model.addAttribute("success","预评已经转换成正式报告！");
        return "zz/trave_ok";

    }

    //统计页面
    @RequestMapping(value = "/statistics.do",method = RequestMethod.GET)
    public String statistics(HttpSession session, ModelMap model){

        return "zz/statistics";
    }

    //获取统计数据处理
    @ResponseBody
    @RequestMapping(value = "/statisticsajxa.do" , method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String statisticsajxa(@RequestParam int limit,@RequestParam int offset ){
        sreach s = new sreach();
        s.setLimit(limit);
        s.setOffset(offset);
//        s.setSelect(select);
//        if(startdate.length()>0){
////            System.out.print("测试走不走这里");
//            s.setStartdate(Date.valueOf(startdate));
//        }
//        if(enddate.length()>0){
////            System.out.print("测试走不走这里");
//            s.setEnddate(Date.valueOf(enddate));
//        }
//
//        s.setText(text);


        Gson gson = new Gson();
        TongJiDao tjd = new TongJiDao();
        List<Tontjia> tjall = tjd.tongjiall(s);
        int counts = tjd.Counttongjiall();
        String jsondata = gson.toJson(tjall);
        jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";

//        List<tongji> tjs = new ArrayList<tongji>();
//        List<tongji> tjss = new ArrayList<tongji>();
//        List<User> us = new ArrayList<User>();
//        List<tongji> tj ;
//        UserDao ud = new UserDao();
//        BaoGaoDao bgd = new BaoGaoDao();
//        us = ud.findusers();
//        for(int i = 0;i < us.size();i++){
//            tj = new ArrayList<tongji>();
////            System.out.println(us.get(i).getUsername()+us.get(i).getUserid());
//            tj=bgd.tongjibyuserid(us.get(i));
//            tjs.addAll(tj);
//        }
////        for(int i=0;i<tjs.size();i++){
////            tj=bgd.tongjibyuserid(tjs.get(i));
////            tjss.add(tj);
////        }
////        for(int i=0;i<tjss.size();i++){
////            System.out.println(tjss.get(i).getUserid()+"++"+tjss.get(i).getZxcount()+"++"+tjss.get(i).getShcount()+"++"+tjss.get(i).getKccount()+"++"+tjss.get(i).getJzgtcount());
////        }
//        int counts = tjs.size();
//        if(s.getOffset()==0){
//            for(int i=0;i<s.getLimit();i++){
//                tjss.add(tjs.get(i));
//            }
//        }else if(s.getLimit()+s.getOffset()>tjs.size()){
//            for(int i=s.getOffset();i<tjs.size();i++){
//                tjss.add(tjs.get(i));
//            }
//        }else{
//            for(int i=s.getOffset();i<s.getOffset()+s.getLimit();i++){
//                tjss.add(tjs.get(i));
//            }
//        }
//        String jsondata = gson.toJson(tjss);
//        jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
//        System.out.println(jsondata);
//        System.out.println(counts);
        return jsondata;
    }

    //上传界面
    @RequestMapping(value = "/upfile.do",method = RequestMethod.GET)
    public String upfile(HttpSession session, ModelMap model){

        return "zz/upfile";
    }


    //没出正评的预评上传
    @RequestMapping(value = "/uploadfile.do")
    public String uploadfile( MultipartFile uploadFile, ModelMap model)throws Exception {

        System.out.println("开始");
//        String leftpath = request.getSession().getServletContext().getRealPath("upload");
        String leftpath = "E:\\springmvc-project\\test\\jsb\\web\\upload";
        String fileName = uploadFile.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath,fileName);
        //保存
        uploadFile.transferTo(file);
//        File upfile = new File()
//
//        model.addAttribute("fileUrl", "/upload/"+fileName);
        uploadfileDao nlfd = new uploadfileDao();
        Map map = nlfd.loadypfile(new File(leftpath+"\\"+fileName));
        List<BaoGao> bgs = new ArrayList<BaoGao>();
        List<BaoGaoList> bgls = new ArrayList<BaoGaoList>();
        bgs = (List<BaoGao>) map.get("bgs");
        bgls = (List<BaoGaoList>) map.get("bgls");
        BaoGaoDao bgd = new BaoGaoDao();
        bgd.insertyppl(bgs,bgls);
        return "zz/result";
    }

    //直接正式报告的上传
    @RequestMapping(value = "/uploadzsfile.do")
    public String uploadzsfile( MultipartFile uploadFile, ModelMap model)throws Exception {


        String leftpath = "E:\\springmvc-project\\test\\jsb\\web\\upload";
        String fileName = uploadFile.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath,fileName);
        //保存
        uploadFile.transferTo(file);

        uploadfileDao nlfd = new uploadfileDao();
        Map map = nlfd.loadzpfile(new File(leftpath+"\\"+fileName));


        List<BaoGao> bgs = (List<BaoGao>) map.get("bgs");
        List<BaoGaoList> bgls = (List<BaoGaoList>) map.get("bgls");

        BaoGaoDao bgd = new BaoGaoDao();
        bgd.insertyppl(bgs,bgls);

        return "zz/result";
    }

    //分公司报告审核的上传
    @RequestMapping(value = "/uploadfgsfile.do")
    public String uploadfgsfile( MultipartFile uploadFile, ModelMap model)throws Exception {

        String leftpath = "E:\\springmvc-project\\test\\jsb\\web\\upload";
        String fileName = uploadFile.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath,fileName);
        //保存
        uploadFile.transferTo(file);
//        File upfile = new File()
//
//        model.addAttribute("fileUrl", "/upload/"+fileName);
        uploadfileDao nlfd = new uploadfileDao();
        Map map = nlfd.loadfgsfile(new File(leftpath+"\\"+fileName));

        List<BaoGao> bgs  = (List<BaoGao>) map.get("bgs");
        List<BaoGaoList> bgls  = (List<BaoGaoList>) map.get("bgls");

        BaoGaoDao bgd = new BaoGaoDao();
        bgd.insertyppl(bgs,bgls);
        return "zz/result";
    }

    //转正评的预评报告的上传
    @RequestMapping(value = "/uploadypzfile.do")
    public String uploadypzfile( MultipartFile uploadFile, ModelMap model)throws Exception {

        String leftpath = "E:\\springmvc-project\\test\\jsb\\web\\upload";
        String fileName = uploadFile.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath,fileName);


        uploadFile.transferTo(file);
//        File upfile = new File()
//
//        model.addAttribute("fileUrl", "/upload/"+fileName);
        uploadfileDao nlfd = new uploadfileDao();
        Map map = nlfd.loadypzfile(new File(leftpath+"\\"+fileName));

        List<BaoGao> bgs  = (List<BaoGao>) map.get("bgs");
        List<BaoGaoList> bgls = (List<BaoGaoList>) map.get("bgls");
        List<Count> cts = new ArrayList<Count>();
        BaoGaoDao bgd = new BaoGaoDao();
        bgd.insertyppl(bgs,bgls);

        return "zz/result";
    }

    //转正评的正式报告的上传
    @RequestMapping(value = "/uploadzpzfile.do")
    public String uploadzpzfile( MultipartFile uploadFile, ModelMap model)throws Exception {

        String leftpath = "E:\\springmvc-project\\test\\jsb\\web\\upload";
        String fileName = uploadFile.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath,fileName);


        uploadFile.transferTo(file);
//        File upfile = new File()
//
//        model.addAttribute("fileUrl", "/upload/"+fileName);
        uploadfileDao nlfd = new uploadfileDao();
        Map map = nlfd.loadzzpfile(new File(leftpath+"\\"+fileName));

        List<BaoGao> bgs  = (List<BaoGao>) map.get("bgs");
        List<BaoGaoList> bgls = (List<BaoGaoList>) map.get("bgls");

        BaoGaoDao bgd = new BaoGaoDao();
        bgd.insertyppl(bgs,bgls);

        return "zz/result";
    }

    //统计CTS生成页面
    @RequestMapping(value = "/ctset.do",method = RequestMethod.GET)
    public String ctset(){
        return "zz/ctset";
    }

    //统计从bgls里面获取cts并插入数据库处理
    @RequestMapping(value = "/ctsetfix.do",method = RequestMethod.POST)
    public String ctsetfix(){
        BaoGaoDao bgd = new BaoGaoDao();
        List<BaoGaoList> bgls = bgd.selectbglsbyid();
        Count ct =null;
        List<Count> cts = new ArrayList<>();
        for(int i = 0; i < bgls.size(); i++){
            if(bgls.get(i).getBaogaotype().equals("分公司报告审核")){
                ct = new Count();
                ct.setTjtype("fgsshenhe");
                ct.setCount(1);
                ct.setBgl(bgls.get(i));
                ct.setUser(bgls.get(i).getShenhe());
                cts.add(ct);
                bgls.get(i).setCtstate(3);
            }else{
                if(bgls.get(i).getZhuanxie().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("zhuanxie");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getZhuanxie());
                    cts.add(ct);
                }
                if(bgls.get(i).getJszhuanxie().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("jszhuanxie");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getJszhuanxie());
                    cts.add(ct);
                }
                if(bgls.get(i).getShenhe().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("shenhe");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getShenhe());
                    cts.add(ct);
                }
                if(bgls.get(i).getKancha().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("kancha");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getKancha());
                    cts.add(ct);
                }
                if(bgls.get(i).getShidikc().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("shidikc");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getShidikc());
                    cts.add(ct);
                }
                if(bgls.get(i).getDingjia().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("dingjia");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getDingjia());
                    cts.add(ct);
                }
                if(bgls.get(i).getJiazhigoutong().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("jiazhigoutong");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getJiazhigoutong());
                    cts.add(ct);
                }
                if(bgls.get(i).getFuzeren().getUserid()>0){
                    ct = new Count();
                    ct.setTjtype("fuzeren");
                    ct.setCount(1);
                    ct.setBgl(bgls.get(i));
                    ct.setUser(bgls.get(i).getFuzeren());
                    cts.add(ct);
                }
                bgls.get(i).setCtstate(3);
            }

        }
        TongJiDao tjd = new TongJiDao();
        tjd.insertTj(cts);
        bgd.updatectstates(bgls);

        return "zz/result";
    }

    //批量处理baogao 的bglid
    @RequestMapping(value = "/bglidfix.do",method = RequestMethod.POST)
    public String bglidfix(){
        int bglid = 0;
        BaoGaoDao bgd = new BaoGaoDao();
        List<BaoGao> bgs = bgd.selectbgsbynull();
        for (int i = 0; i < bgs.size();i++){
            bglid = bgd.findbglidbybunum(bgs.get(i).getBgnum());
            if(bglid!=0){
                bgs.get(i).setBglid(bglid);
            }
        }

        bgd.updatebgbglid(bgs);

        return "zz/result";
    }

    @RequestMapping(value = "/statisticsa.do",method = RequestMethod.GET)
    public String statisticsa(){

        return "zz/statisticscheck";
    }

    //测试条件查询统计
    @ResponseBody
    @RequestMapping(value = "/statisticsajxaa.do" , method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String statisticsajxaa(@RequestParam int limit,@RequestParam int offset,@RequestParam String bumen,@RequestParam String baogaotype,@RequestParam String year,@RequestParam String month ){
        sreach s = new sreach();
        s.setLimit(limit);
        s.setOffset(offset);
        s.setBaogaotype(baogaotype);
        s.setBumen(bumen);
        s.setYearmonth(year+"-"+month);


        List<Tontjia> tjas = new ArrayList<>();
        UserDao ud = new UserDao();
        List<User> users = ud.findjsbusers();
        for(int i=0;i<users.size();i++){
            Tontjia tja = new Tontjia();
            tja.setUser(users.get(i));
            tja.setBaogaotype(s.getBaogaotype());
            tja.setMonth(s.getYearmonth());
            tja.setZhuanxie((float) 0);
            tja.setShenhe((float) 0);
            tja.setJszhuanxie((float) 0);
            tja.setKancha((float) 0);
            tja.setShidikc((float) 0);
            tja.setJiazhigoutong((float) 0);
            tja.setDingjia((float) 0);
            tja.setFgs((float) 0);
            tjas.add(tja);
        }
        BaoGaoDao bgd = new BaoGaoDao();
        List<Tontjia> tjass = bgd.tongjiquanyebgl(s,tjas);

        List<Tontjia> tjasss = tjass.subList(s.getOffset(),s.getOffset()+s.getLimit());
        Gson gson = new Gson();
        int counts = tjas.size();
        String jsondata = gson.toJson(tjasss);
        jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";

//        List<tongji> tjs = new ArrayList<tongji>();
//        List<tongji> tjss = new ArrayList<tongji>();
//        List<User> us = new ArrayList<User>();
//        List<tongji> tj ;
//        UserDao ud = new UserDao();
//        BaoGaoDao bgd = new BaoGaoDao();
//        us = ud.findusers();
//        for(int i = 0;i < us.size();i++){
//            tj = new ArrayList<tongji>();
////            System.out.println(us.get(i).getUsername()+us.get(i).getUserid());
//            tj=bgd.tongjibyuserid(us.get(i));
//            tjs.addAll(tj);
//        }
////        for(int i=0;i<tjs.size();i++){
////            tj=bgd.tongjibyuserid(tjs.get(i));
////            tjss.add(tj);
////        }
////        for(int i=0;i<tjss.size();i++){
////            System.out.println(tjss.get(i).getUserid()+"++"+tjss.get(i).getZxcount()+"++"+tjss.get(i).getShcount()+"++"+tjss.get(i).getKccount()+"++"+tjss.get(i).getJzgtcount());
////        }
//        int counts = tjs.size();
//        if(s.getOffset()==0){
//            for(int i=0;i<s.getLimit();i++){
//                tjss.add(tjs.get(i));
//            }
//        }else if(s.getLimit()+s.getOffset()>tjs.size()){
//            for(int i=s.getOffset();i<tjs.size();i++){
//                tjss.add(tjs.get(i));
//            }
//        }else{
//            for(int i=s.getOffset();i<s.getOffset()+s.getLimit();i++){
//                tjss.add(tjs.get(i));
//            }
//        }
//        String jsondata = gson.toJson(tjss);
//        jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
//        System.out.println(jsondata);
//        System.out.println(counts);
        return jsondata;
    }


    //密码界面
    @RequestMapping(value = "/userinfo.do",method = RequestMethod.GET)
    public String userinfo(HttpSession session, ModelMap model){

        return "zz/userinfo";
    }

    //密码修改处理完并返回主页面
    @RequestMapping(value = "useredit.do",method = RequestMethod.POST)
    public String useredit(HttpServletRequest request, ModelMap model){
        if(request.getParameter("newps").equals(request.getParameter("renewps"))) {

            LoginDao ld = new LoginDao();
            User user = ld.loginaaa(request.getParameter("loginname"), request.getParameter("oldps"));
            if (user != null) {
                user.setPassword(request.getParameter("newps"));
                ld.updateuserps(user);
                model.addAttribute("success", "修改密码成功");
                return "zz/useredit_ok";
            } else {

                model.addAttribute("error", "原密码错误，无法修改密码");
                return "zz/userinfo";
            }
        }else{
            model.addAttribute("error","新密码不一致，请重新录入");
            return "zz/userinfo";
        }


    }


    //查询报告然后编辑
    @RequestMapping(value = "/bgtoedit.do",method = RequestMethod.GET)
    public String bgtoedit(HttpSession session, ModelMap model){

        return "zz/bgtoedit";
    }


    //进入分公司报告审核界面
    @RequestMapping(value = "/fgsshenhe.do")
    public String fgsshenhe(){

        return "zz/fgssh";
    }
    //分公司报告审核编辑

    @ResponseBody
    @RequestMapping(value = "/fgsshajax.do" , method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String fgsindexajax(@RequestParam int limit,@RequestParam int offset,@RequestParam String startdate,@RequestParam String enddate, ModelMap model){
        sreach s = new sreach();
        s.setLimit(limit);
        s.setOffset(offset);
        int counts =0;
        if(startdate.length()>0){
            s.setStartdate(Date.valueOf(startdate));
        }
        if(enddate.length()>0){
            s.setEnddate(Date.valueOf(enddate));
        }

        Gson gson = new Gson();
        List<fgsbgl> bgls= new ArrayList<>();
        fgsDao fgsd = new fgsDao();
        if(s.getEnddate()!=null && s.getStartdate()!=null){
            if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                model.addAttribute("error","截止日期不能小于起始日期");
                return "zz/index_error";
            }else {
                bgls = fgsd.fgsshlistbydate(s);
                counts = fgsd.fgsshcountbydate(s);
            }
        }else if(s.getStartdate()==null && s.getEnddate() ==null){
            bgls = fgsd.fgsshbglist(s);
            counts =fgsd.fgsshallcounts();
        }else{
            model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
            return "zz/index_error";
        }


        String jsondata = gson.toJson(bgls);
        jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
        System.out.println(jsondata);
        System.out.println(counts);
        return jsondata;
    }

    //获取分公司审核报告的子报告
    @ResponseBody
    @RequestMapping(value = "/fgsshchildajax.do", method=RequestMethod.GET,produces = "application/json ;charset=UTF-8")
    public String fgsindexchildajax(@RequestParam int bglid){
        fgsDao fgsd = new fgsDao();
        Gson gson = new Gson();
        List<BaoGao> bgs = fgsd.fgsfindbgsbybglid(bglid);
        String jsondata = gson.toJson(bgs);
        int counts = bgs.size();
        jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
        System.out.println(jsondata);

        return jsondata;
    }

    //分公司报告审核转到BAOGAOLIST/BAO
    @RequestMapping(value = "/fgsshinput.do",method = RequestMethod.GET)
    public String fgsinput(int bglid,HttpSession session, ModelMap model){
        System.out.println(bglid);
        UserDao ud = new UserDao();
        fgsbgl bgl =new fgsbgl();
        List<BaoGao> bgs = new ArrayList<>();
        fgsDao fgsd =new fgsDao();
        bgl = fgsd.fgsfindbglbyid(bglid);
        bgs = fgsd.fgsfindbgsbybglid(bglid);

        bgl.setFuzeren(ud.finduseridbyname(bgl.getFuzeren()));
        String  bdwct = null;
        for(int i = 0 ; i < bgs.size();i++){
            if(i==0){
                bdwct = String.valueOf(1);
            }else {
                bdwct = bdwct+","+String.valueOf(i+1);
            }

        }
        System.out.println(bdwct);
        for(int j= 0; j<bgs.size();j++){
            System.out.println(bgs.get(j).getProname()+"+++"+bgs.get(j).getBgnum()+"+++++");
        }
        model.addAttribute("bgl",bgl);
        model.addAttribute("bgs",bgs);
        model.addAttribute("bdwct",bdwct);
        User user = (User)session.getAttribute("user");
        return "zz/fgsinput";
    }

    //编辑分公司报告内容
    @RequestMapping(value = "/fgsshenheedit.do",method = RequestMethod.POST)
    public String fgsshenheedit(int fgsbglid,HttpServletRequest request, ModelMap model,HttpSession session){
        BaoGaoDao bgd = new BaoGaoDao();
        jiaoyan jy = new jiaoyan();
        String info =jy.fgsshjy(request);
        fgsDao fgsd = new fgsDao();


        if(info.equals("success") == false){
            model.addAttribute("error",info);
            return "zz/fgsshedit_error";
        }
        bgutil bgt = new bgutil();
        Map map = bgt.bglfirstset(request);
        BaoGaoList bgl = (BaoGaoList) map.get("bgl");
        List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
        List<Count> cts = (List<Count>)map.get("cts");

        bgl.setCreater((User) session.getAttribute("user"));
        java.util.Date  date =new java.util.Date();
        java.sql.Date  data1 =new java.sql.Date(date.getTime());
        bgl.setCreatedate(data1);
        bgl.setCtstate(3);

        if(bgd.findbglidbybunum(bgl.getBgnum())>0){
            model.addAttribute("error","数据库中已存在该报告编号，请核查一下！");
            return "zz/fgsshedit_error";
        }else{
            bgl.setBumen("技术部");
            bgd.insertbaogaolist(bgl);
            fgsd.fgsupdatebglshstatebyid(fgsbglid);
            bgl.setId(bgd.findbglidbybunum(bgl.getBgnum()));
            for(int i =0; i<bgs.size();i++){
                bgs.get(i).setBglid(bgl.getId());
            }
            for(int j =0; j<cts.size();j++){
                cts.get(j).setBgl(bgl);
            }
            bgd.insertbaogaos(bgs);
            TongJiDao tjd = new TongJiDao();
            tjd.insertTj(cts);
        }

        model.addAttribute("success","分公司报告审核录入成功");
        return "zz/fgsshedit_ok";

    }

    //进入分公司报告退回说明界面
    @RequestMapping(value = "/fgsback.do")
    public String fgsback(HttpServletRequest request ,HttpSession session, ModelMap model){
        String bglid = request.getParameter("bglid");
        model.addAttribute("bglid",bglid);
        return "zz/fgsback";
    }
    //分公司报告退回处理
    @RequestMapping(value = "/fgsbackfix.do")
    public String fgsbackfix(HttpServletRequest request ,HttpSession session, ModelMap model){
        int bglid = Integer.parseInt(request.getParameter("bglid"));
        String backmemo = request.getParameter("backmemo");
        fgsbgl bgl = new fgsbgl();
        bgl.setId(bglid);
        bgl.setBackmemo(backmemo);
        fgsDao fgsd = new fgsDao();
        fgsd.fgsbackupdate(bgl);
        model.addAttribute("success","驳回处理成功");
        return "zz/fgsbackok";
    }
    //分公司报告审核查询
    @RequestMapping(value = "/fgsshselect.do")
    public String fgsshselect(HttpServletRequest request ,HttpSession session, ModelMap model){

        return "zz/fgsshselect";
    }

    //进入查询下载页面
    @RequestMapping(value = "/zxshdown.do")
    public String zxshdown(HttpServletRequest request ,HttpSession session, ModelMap model){

        return "zz/zxshdown";
    }

    //获取查询下载页面的ajax
    @ResponseBody
    @RequestMapping(value = "/zxshdownajax.do" , method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String zxshdownajax(HttpServletRequest request,ModelMap model){
        sreach s = new sreach();
        String l =request.getParameter("limit");
        String o =request.getParameter("offset");
        if(l==null&&o == null){
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            s.setSelect(request.getParameter("select"));
            if(startdate.length()>0){
                s.setStartdate(Date.valueOf(startdate));
            }
            if(enddate.length()>0){
                s.setEnddate(Date.valueOf(enddate));
            }

            s.setText(request.getParameter("text"));
            int counts =0 ;
            Gson gson = new Gson();
            List<BaoGaoList> bgls= new ArrayList<BaoGaoList>();
            BaoGaoDao bgd = new BaoGaoDao();
            if(s.getSelect().equals("all")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.bglistbydatedown(s);
                        counts = bgd.allcountsbydatedown(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    System.out.println("走的是这里把");
                    bgls = bgd.bglistdown();
                    counts =bgd.allcountsdown();
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }else if(s.getSelect().equals("zporsd")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyzporsddatedownall(s);
                        counts = bgd.countbyzporsddateall(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyzporsddwall(s);
                    counts = bgd.countbyzporsdall(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            }else if(s.getSelect().equals("shdown")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyshdowndateall(s);
                        counts = bgd.countbyshdownddateall(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyshdownall(s);
                    counts = bgd.countbyshdownall(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            }else if(s.getSelect().equals("jzdown")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectjzdownbydateall(s);
                        counts = bgd.countbyjzdowndateall(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyjzdownall(s);
                    counts = bgd.countbyjzdownall(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }

            }else if(s.getSelect().equals("djdown")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectdjdownbydateall(s);
                        counts = bgd.countbydjdowndateall(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbydjdownall(s);
                    counts = bgd.countbydjdownall(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }

            }else if(s.getSelect().equals("zxorjszx")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyzxorjszxdateall(s);
                        counts = bgd.countbyzxorjszxdateall(s);

                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyzxorjszxall(s);
                    counts = bgd.countbyzxorjszxall(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }
            String jsondata = gson.toJson(bgls);
            jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
            System.out.println(jsondata);
            System.out.println(counts);
            return jsondata;

        }else{
            int limit = Integer.parseInt(request.getParameter("limit"));
            int offset = Integer.parseInt(request.getParameter("offset"));
            s.setLimit(limit);
            s.setOffset(offset);
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            s.setSelect(request.getParameter("select"));
            if(startdate.isEmpty()){
                s.setStartdate(null);
            }else {
                s.setStartdate(Date.valueOf(startdate));
            }
            if(enddate.isEmpty()){
                s.setEnddate(null);
            }else{
                s.setEnddate(Date.valueOf(enddate));
            }

            s.setText(request.getParameter("text"));
            int counts =0 ;
            Gson gson = new Gson();
            List<BaoGaoList> bgls= new ArrayList<BaoGaoList>();
            BaoGaoDao bgd = new BaoGaoDao();
            if(s.getSelect().equals("all")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.bglistbydate(s);
                        counts = bgd.allcountsbydate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.bglist(s);
                    counts =bgd.allcounts();
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }else if(s.getSelect().equals("zporsd")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyzporsddate(s);
                        counts = bgd.countbyzporsddate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyzporsd(s);
                    counts = bgd.countbyzporsd(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            }else if(s.getSelect().equals("shdown")){
                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyshdowndate(s);
                        counts = bgd.countbyshdownddate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyshdown(s);
                    counts = bgd.countbyshdown(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            }else if(s.getSelect().equals("jzdown")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectjzdownbydate(s);
                        counts = bgd.countbyjzdowndate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyjzdown(s);
                    counts = bgd.countbyjzdown(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }

            }else if(s.getSelect().equals("djdown")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectdjdownbydate(s);
                        counts = bgd.countbydjdowndate(s);
                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbydjdown(s);
                    counts = bgd.countbydjdown(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }

            }else if(s.getSelect().equals("zxorjszx")){

                if(s.getEnddate()!=null && s.getStartdate()!=null){
                    if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                        model.addAttribute("error","截止日期不能小于起始日期");
                        return "index_error";
                    }else {
                        bgls = bgd.selectBaoGaoListbyzxorjszxdate(s);
                        counts = bgd.countbyzxorjszxdate(s);

                    }
                }else if(s.getStartdate()==null && s.getEnddate() ==null){
                    bgls = bgd.selectBaoGaoListbyzxorjszx(s);
                    counts = bgd.countbyzxorjszx(s);
                }else{
                    model.addAttribute("error","日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }


            String jsondata = gson.toJson(bgls);
            jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
            System.out.println(jsondata);
            System.out.println(counts);
            return jsondata;
        }

    }




    //登录到信息录入页面
    @RequestMapping(value = "/bguploadinput.do")
    public String bguploadinput(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "zz/login";
        }else {
            return "zz/bguploadinput";
        }

    }

    //预评报告上传后的处理
    @RequestMapping(value = "/bguploadtrans.do")
    public String bguploadtrans(MultipartFile uploadFile, ModelMap model, HttpServletRequest request) throws Exception {

        java.util.Date date = new java.util.Date();
        String strFormat ="yyyyMMddHHmmss";
        SimpleDateFormat sf = new SimpleDateFormat(strFormat);
        String str11 = sf.format(date);


        String leftpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/upload");
//        String fileName = uploadFile.getOriginalFilename();
        String fileName =  str11 + "jsb.docx";
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath, fileName);
        //保存
        uploadFile.transferTo(file);

        String filepathname = leftpath+"/"+fileName;

        jiaoyan jy = new jiaoyan();
        bgutil bgt = new bgutil();
        String info = jy.upfilejy(request);

        if(info.equals("success") == false){
            model.addAttribute("error",info);
            return "zz/inputupfile" ;
        }else{

            Map map = bgt.bglupfile(request);
            BaoGaoList bgl = (BaoGaoList) map.get("bgl");
            BaoGao bg = new BaoGao();


            System.out.println(filepathname+"----------------------------------------------");
            Docx4j_S3_Test dds = new Docx4j_S3_Test();
            WordprocessingMLPackage wmp = dds.loadWordprocessingMLPackage(filepathname);
            List<Tbl> tblList = dds.getAllTbl(wmp);
            List<String> alltablelist = new ArrayList<>();
            for(int i=0;i<tblList.size();i++){
                List<String> ontablelist = dds.getTblContentList(tblList.get(i));
                alltablelist.addAll(ontablelist);
            }

            String bgnum = alltablelist.get(0);
            bgnum = bgnum.substring(bgnum.indexOf("第")+1,bgnum.indexOf("号"));
            bgl.setBgnum(bgnum);
            bg.setBgnum(bgnum);

            String jiazhisihdian = alltablelist.get(1).substring(alltablelist.get(1).indexOf("价值时点")+4,alltablelist.get(1).indexOf("的估价结果"));
            System.out.println(jiazhisihdian+"-------------------------------");
            jiazhisihdian = jiazhisihdian.replace("年","-").replace("月","-").replace("日","");
            System.out.println(jiazhisihdian+"++++++++++++++++++++++++++++");
            bgl.setShidian(Date.valueOf(jiazhisihdian));
            bg.setShidian(Date.valueOf(jiazhisihdian));


            float zongjia = Float.parseFloat(alltablelist.get(2).substring(alltablelist.get(2).indexOf("：")+1,alltablelist.get(2).indexOf("万元")));
            bgl.setZongjias(zongjia);
            bg.setZongjia(zongjia);

//		String ddd = bbb.get(2).substring(bbb.get(2).indexOf("单价：")+3,bbb.get(2).indexOf("元/平方米"));
            float danjia = Float.parseFloat(alltablelist.get(3).substring(alltablelist.get(3).indexOf("单价：")+3,alltablelist.get(3).indexOf("元/平方米")));
            bg.setDanjia(danjia);

            String chujudate = alltablelist.get(4);
            System.out.println(chujudate);
//            chujudate = chujudate.replace("年","-").replace("月","-").replace("日","").replace(",","").replace("  ","");
            chujudate = chujudate.replace(",","").replace("  ","");
            String y = chujudate.substring(0,chujudate.indexOf("年"));
            String m = chujudate.substring(chujudate.indexOf("年")+1,chujudate.indexOf("月"));
            String d = chujudate.substring(chujudate.indexOf("月")+1,chujudate.indexOf("日"));

            System.out.println(y+"----"+m+"-----"+d);

            String month = "";

            String day = "";
            System.out.println(y+"----"+m+"-----"+d);
            String[] hanziy = { "〇","一", "二", "三", "四", "五", "六", "七", "八", "九" };
            String[] hanzim1 = { "一", "二", "三", "四", "五", "六", "七", "八", "九" };

            String[] hanzid1 = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
            String[] hanzid2 = { "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九"  };
            String[] hanzid3 = {"二十一", "二十二", "二十三", "二十四", "二十五", "二十六", "二十七", "二十八", "二十九" };
            for(int i = 0;i<hanziy.length;i++){
                y = y.replace(hanziy[i],String.valueOf(i));
            }
            System.out.println(m.indexOf("十"));
            if(m.indexOf("十")==0){
                if(m.equals("十")){
                    month = "10";
                }else if(m.equals("十一")){
                    month = "11";
                }else {
                    month = "12";
                }
            }else{
                month =m ;
                for(int i = 0;i<hanzim1.length;i++){
                    month = month.replace(hanzim1[i],String.valueOf(i+1));
                }
            }

            if(d.indexOf("三十")==0){
                if(d.equals("三十")){
                    day = "30";
                }else {
                    day = "31";
                }
            }else if(d.indexOf("二十")==0){
                if(d.equals("二十")){
                    day = "20";
                }else {
                    day = d;
                    for(int i=0;i<hanzid3.length;i++){
                        day= day.replace(hanzid3[i],String.valueOf(i+21));
                    }
                }
            }else if(d.indexOf("十")==0){
                if(d.equals("十")){
                    day = "10";
                }else {
                    day = d;
                    for(int i=0;i<hanzid2.length;i++){
                        day= day.replace(hanzid2[i],String.valueOf(i+11));
                    }
                }
            }else {
                day = d;
                for(int i=0;i<hanzid1.length;i++){
                    day= day.replace(hanzid1[i],String.valueOf(i+1));
                }
            }

            System.out.println(y+"-----------------------------"+month+"---------------------------"+day);
            String chujudate1 = y+"-"+month+"-"+day;
            System.out.println(chujudate1+"***********************************");
            bgl.setChujudate(Date.valueOf(chujudate1));
//            bg.setChujudate(Date.valueOf(chujudate));




            String[] ccc = alltablelist.get(5).split(",");
            String zuoluo = ccc[1];
            bgl.setZuoluo(zuoluo);
            bg.setZuoluo(zuoluo);

            String[] ddd = alltablelist.get(7).split(",");
            String chanquanren = ddd[1];
            bg.setChanquanren(chanquanren);


            ddd = null;
            ddd = alltablelist.get(8).split(",");
            String mianji = ddd[1];
            bg.setMianji(Float.parseFloat(mianji));

            String suo = ddd[3];
            bg.setSuo(suo);

            String zong = ddd[5];
            bg.setZong(zong);

            ddd = null;
            ddd = alltablelist.get(9).split(",");
            String jungong = ddd[1];
            bg.setNiandai(jungong);
            String yongtu = ddd[5];
            bg.setYongtu(yongtu);

            ddd = null;
            ddd = alltablelist.get(12).split(",");
            String proname = ddd[1];
            bg.setProname(proname);
            bgl.setBaogaotype("预评报告");


            BaoGaoDao bgd = new BaoGaoDao();
            if(bgd.findbglidbybunum(bgl.getBgnum())>0){
                model.addAttribute("error","数据库中已存在该报告编号，请核查一下！");
                return "zz/inputupfile";
            }else{
                bgd.insertbaogaolist(bgl);
                bgl.setId(bgd.findbglidbybunum(bgl.getBgnum()));
                bg.setBglid(bgl.getId());
                bg.setPoint("保留二位");
                bgd.insertbaogao(bg);
                model.addAttribute("success","上传导入成功");
                return "zz/input_ok";
            }

        }




    }

}