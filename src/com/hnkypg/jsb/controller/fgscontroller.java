package com.hnkypg.jsb.controller;

import com.google.gson.Gson;
import com.hnkypg.Util.bgutil;
import com.hnkypg.Util.jiaoyan;
import com.hnkypg.dao.BaoGaoDao;
import com.hnkypg.dao.TongJiDao;
import com.hnkypg.dao.UserDao;
import com.hnkypg.dao.fgsDao;
import com.hnkypg.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by python on 2017-8-16.
 */



@Controller
@SessionAttributes("user")
public class fgscontroller {

    //登录到主界面
    @RequestMapping(value = "/fgsindex.do")
    public String fgsindex(){

        return "ly/fgsindex";
    }


    //分公司录入界面
    @RequestMapping(value = "/lyinput.do",method = RequestMethod.GET)
    public String lyinput(HttpSession session, ModelMap model){

        return "ly/lyinput";
    }

    //分公司直接录入的报告处理
    @RequestMapping(value = "lyinputfix.do",method = RequestMethod.POST)
    public String lyinputfix(HttpServletRequest request, ModelMap model, HttpSession session){
        //校验录入信息
        jiaoyan jy = new jiaoyan();
        String info = jy.fgsinputpd(request);
        String bdwct =request.getParameter("bdwct");
        bgutil bgt = new bgutil();
        if(info.equals("success") == false){
            model.addAttribute("error",info);
            Map map = bgt.fgsbglerror(request);
            fgsbgl bgl = (fgsbgl) map.get("bgl");
            List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
            model.addAttribute("bgl",bgl);
            model.addAttribute("bgs",bgs);
            model.addAttribute("bdwct",bdwct);
            return "ly/lyinput";
        }
        //fgsBGL BG设置数据

        Map map = bgt.fgsfirstset(request);
        fgsbgl bgl = (fgsbgl) map.get("bgl");
        bgl.setCreater((User) session.getAttribute("user"));
        java.util.Date  date =new java.util.Date();
        java.sql.Date  data1 =new java.sql.Date(date.getTime());
        bgl.setCreatedate(data1);
        bgl.setShstate(1);
        List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");

        //判断该报告编码是否占用
        fgsDao fgsd = new fgsDao();
        //从数据库中获取有没有报告编码相同的记录数量，如果是大于0就是有错误返回重新处理，如果==0那么录入fgsbgl
        if(fgsd.findfgscountbybunum(bgl.getBgnum())>0){
            model.addAttribute("error","数据库中已存在该报告编号，请核查一下！");
            return "ly/fgsinput_error";
        }else{
            //录入报告记录清单
            fgsd.insertfgsbgl(bgl);
            //获取刚录入的BGL的ID设置给BG对应的bglid
            bgl.setId(fgsd.findfgsbglidbybunum(bgl.getBgnum()));
            for(int i =0; i<bgs.size();i++){
                bgs.get(i).setBglid(bgl.getId());
            }

            //插入BG信息到分公司bg表
            fgsd.insertfgsbgs(bgs);

            model.addAttribute("success","录入成功");
            return "ly/input_ok";
        }


    }



    //登录分公司查询页面
    @RequestMapping(value = "/fgsselect.do")
    public String fgsselect(){

        return "ly/select";
    }

    //获取分公司报告清单内容
    @ResponseBody
    @RequestMapping(value = "/fgsindexajax.do" , method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String fgsindexajax(@RequestParam int limit,@RequestParam int offset,@RequestParam String text,@RequestParam String select,@RequestParam String startdate,@RequestParam String enddate,ModelMap model){
        sreach s = new sreach();
        s.setLimit(limit);
        s.setOffset(offset);
        s.setSelect(select);
        if(startdate.length()>0){
            s.setStartdate(Date.valueOf(startdate));
        }
        if(enddate.length()>0){
            s.setEnddate(Date.valueOf(enddate));
        }

        s.setText(text);
        int counts =0 ;
        Gson gson = new Gson();
        List<fgsbgl> bgls= new ArrayList<>();
        fgsDao fgsd = new fgsDao();
        if(s.getSelect().equals("all")){
            if(s.getEnddate()!=null && s.getStartdate()!=null){
                if(s.getStartdate().getTime()>=s.getEnddate().getTime()){
                    model.addAttribute("error","截止日期不能小于起始日期");
                    return "index_error";
                }else {
                    bgls = fgsd.fgsbglistbydate(s);
                    counts = fgsd.fgsallcountsbydate(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = fgsd.fgsbglist(s);
                counts =fgsd.fgsallcounts();
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
                    bgls = fgsd.fgsfindbglsbybgnumanddate(s);
                    counts = fgsd.fgsallcountsbybgnumanddate(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = fgsd.fgsfindbglsbybgnum(s);
                counts = fgsd.fgsallcountsbybgnum(s);
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
                    bgls = fgsd.fgsselectbglbyzldate(s);
                    counts = fgsd.fgsallcountsbyzldate(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = fgsd.fgsbglistbyzuoluo(s);
                counts = fgsd.fgsallcountsbyzuoluo(s);
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
                    bgls = fgsd.fgsselectbglbypronameanddate(s);
                    counts = fgsd.fgsallcountbglbypronameandate(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = fgsd.fgsselectbglbyproname(s);
                counts = fgsd.fgsallcountbglbyproname(s);
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
                    bgls = fgsd.fgsselectbglbycqranddate(s);
                    counts = fgsd.fgscountbycqrandate(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = fgsd.fgsselectBaoGaoListbycqr(s);
                counts = fgsd.fgscountbycqr(s);
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

    //获取分公司报告子表内容
    @ResponseBody
    @RequestMapping(value = "/fgsindexchildajax.do", method=RequestMethod.GET,produces = "application/json ;charset=UTF-8")
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

    //登录到分公司报告编辑选择页面
    @RequestMapping(value = "/tofgsedit.do")
    public String tofgsedit(){

        return "ly/tofgsedit";
    }

    //进入编辑分公司报告
    @RequestMapping(value = "/fgsedit.do",method = RequestMethod.GET)
    public String fgsedit(int bglid, ModelMap model,HttpSession session){
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
//        if(user.getBumen().equals("技术部")){
//            return "zz/edit";
//        }else{
//            return "zz/edita";
//        }
        return "ly/fgsedit";

    }

    //编辑分公司报告内容
    @RequestMapping(value = "/fgsupdateedit.do",method = RequestMethod.POST)
    public String fgsupdateedit(HttpServletRequest request, ModelMap model,HttpSession session){
        fgsDao fgsd = new fgsDao();
//        fgsbgl bgl1=fgsd.fgsfindbglbyid(Integer.parseInt(request.getParameter("bglid")));
        jiaoyan jy = new jiaoyan();
        String info =jy.fgsinputpd(request);
        bgutil bgt = new bgutil();

        if(info.equals("success") == false){
            String bglid = request.getParameter("bglid");
            String bdwct =request.getParameter("bdwct");
            model.addAttribute("error",info);
            Map map = bgt.fgsbglerror(request);
            fgsbgl bgl = (fgsbgl) map.get("bgl");
            List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
            bgl.setId(Integer.parseInt(bglid));
            model.addAttribute("bgl",bgl);
            model.addAttribute("bgs",bgs);
            model.addAttribute("bdwct",bdwct);
            model.addAttribute("bglid",bglid);
            return "ly/fgsedit";
        }

        Map map = bgt.fgsfirstset(request);
        fgsbgl bgl = (fgsbgl) map.get("bgl");
        List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");

        bgl.setId(Integer.parseInt(request.getParameter("bglid")));
        bgl.setUpdater((User)session.getAttribute("user"));
        java.util.Date  date =new java.util.Date();
        java.sql.Date  data1 =new java.sql.Date(date.getTime());
        bgl.setUpdatetime(data1);
        fgsd.fgsupdatebglbybglid(bgl);

        for(int i =0; i<bgs.size();i++){
            bgs.get(i).setBglid(bgl.getId());
        }


        fgsd.fgsdelbgbybglid(bgl.getId());
        fgsd.insertfgsbgs(bgs);



        model.addAttribute("success","更新报告成功");
        return "ly/fgsedit_ok";

    }


    //进入转换分公司报告页面
    @RequestMapping(value = "/fgstrave.do",method = RequestMethod.GET)
    public String fgstrave(int bglid, ModelMap model,HttpSession session){
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

        return "ly/fgstrave";

    }



    //转换分公司报告性质
    @RequestMapping(value = "fgstraveedit.do",method = RequestMethod.POST)
    public String fgstraveedit(HttpServletRequest request,ModelMap model){
        jiaoyan jy = new jiaoyan();
        String info = jy.fgstravejy(request);
        if(info.equals("success") == false){
            model.addAttribute("error",info);
            return "ly/fgstrave_error";
        }
        bgutil bgt = new bgutil();
        Map map = bgt.fgstraveset(request);
        fgsbgl bgl = (fgsbgl) map.get("bgl");
        List<BaoGao> bgs = (List<BaoGao>)map.get("bgs");
        fgsDao fgsd = new fgsDao();

        fgsd.fgsupdatebglstatebyid(Integer.parseInt(request.getParameter("bglid")));
        bgl.setShstate(1);
        fgsd.insertfgsbgl(bgl);

        bgl.setId(fgsd.fgsfindbglidbystrave(bgl.getBgnum()));
        for(int i =0; i<bgs.size();i++){
            bgs.get(i).setBglid(bgl.getId());
        }

        fgsd.insertfgsbgs(bgs);

        model.addAttribute("success","预评已经转换成正式报告！");
        return "ly/fgstrave_ok";

    }

    //获取报告子表内容
    @ResponseBody
    @RequestMapping(value = "/fgslistchildajax.do", method=RequestMethod.GET,produces = "application/json ;charset=UTF-8")
    public String fgslistchildajax(@RequestParam int bglid){
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
    @RequestMapping(value = "/fgslistajax.do" , method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String fgslistajax(@RequestParam int limit,@RequestParam int offset,@RequestParam String text,@RequestParam String select,@RequestParam String startdate,@RequestParam String enddate,ModelMap model,@RequestParam String bumen){
        sreach s = new sreach();
        s.setLimit(limit);
        s.setOffset(offset);
        s.setSelect(select);
        s.setBumen(bumen);
        if(startdate.length()>0){
            s.setStartdate(Date.valueOf(startdate));
        }
        if(enddate.length()>0){
            s.setEnddate(Date.valueOf(enddate));
        }

        s.setText(text);
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
                    bgls = bgd.fgsbglbydatequyu(s);
                    counts = bgd.allcountsbydatequyu(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = bgd.bglistbyquyu(s);
                counts =bgd.allcountsbyquyu(s);
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
                    bgls = bgd.selectbglbyzldatequyu(s);
                    counts = bgd.allcountsbyzldatequyu(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = bgd.findbglsbybgnumquyu(s);
                counts = bgd.allcountsbybgnumquyu(s);
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
                    bgls = bgd.selectBaoGaoListbyzldatequyu(s);
                    counts = bgd.allcountsbyzldateqy(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = bgd.selectbglbyzuoluoqy(s);
                counts = bgd.allcountsbyzuoluoquy(s);
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
                    bgls = bgd.selectbglbypronameanddateqy(s);
                    counts = bgd.allcountbglbypronameandateqy(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = bgd.selectbglbypronameqy(s);
                counts = bgd.allcountbglbypronameqy(s);
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
                    bgls = bgd.selectbglbycqranddateqy(s);
                    counts = bgd.countbycqrandatequyu(s);
                }
            }else if(s.getStartdate()==null && s.getEnddate() ==null){
                bgls = bgd.selectbglbycqrquyu(s);
                counts = bgd.countbycqrquyu(s);
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
