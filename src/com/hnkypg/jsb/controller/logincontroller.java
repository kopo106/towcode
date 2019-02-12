package com.hnkypg.jsb.controller;

import com.google.gson.Gson;
import com.hnkypg.dao.BaoGaoDao;
import com.hnkypg.dao.LoginDao;
import com.hnkypg.dao.UserDao;
import com.hnkypg.pojo.BaoGao;
import com.hnkypg.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Controller
@SessionAttributes("user")
public class logincontroller {
    @RequestMapping(value = "/ewmlogin.do",method = RequestMethod.GET)
    public String loginewm(){return "zz/login";}

    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String login(){return "zz/login1";}

    @RequestMapping(value = "/logindo.do",method = RequestMethod.POST)
    public String logindo(String loginname,String password,ModelMap model){
        System.out.println(loginname);
        System.out.println(password);

        LoginDao ld = new LoginDao();
        User user = null ;
        try {
            user =ld.loginaaa(loginname,password);
        }catch (Exception e){
            return "zz/login1";
        }
//        if(user.getUsername().isEmpty()){
//            System.out.println("没有查询出来结果");
//        }
        if(user !=null){
            if(user.getBumen().equals("洛阳")||user.getBumen().equals("安阳")||user.getBumen().equals("平顶山")||user.getBumen().equals("新乡")||user.getBumen().equals("商丘")){
                model.addAttribute("user",user);
                return "ly/fgsindex";
            }else if(user.getBumen().equals("技术部")){
                model.addAttribute("user",user);
                return "zz/index";
            }else{
                model.addAttribute("user",user);
                return "yanzheng/list";
            }

        }else {
            System.out.println("有没有走这里啊");
            model.addAttribute("error","用户名密码错误");
            return "zz/login1";
        }

    }

    @RequestMapping(value = "/ewmloginfix.do",method = RequestMethod.POST)
    public String ewmloginfix(String loginname,String password,ModelMap model){
        System.out.println(loginname);
        System.out.println(password);

        LoginDao ld = new LoginDao();
        User user = null ;
        try {
            user =ld.loginaaa(loginname,password);
        }catch (Exception e){
            return "zz/login1";
        }

//        if(user.getUsername().isEmpty()){
//            System.out.println("没有查询出来结果");
//        }
        if(user !=null){
            if(user.getBumen().equals("技术部")){
                model.addAttribute("user",user);
                return "zz/index";
            }else{
                model.addAttribute("user",user);

                return "yanzheng/list";
            }

        }else {
            System.out.println("有没有走这里啊");
            model.addAttribute("error","用户名密码错误");
            return "zz/login";
        }

    }

    @RequestMapping(value = "/test.do",method = RequestMethod.GET)
    public String testab(){return "zz/test";}
    @RequestMapping(value = "/testfix.do",method = RequestMethod.POST)
    public String testfix(int bglid, ModelMap model){
        List<BaoGao> bgs = new ArrayList<>();
        BaoGaoDao bgd = new BaoGaoDao();
        bgs = bgd.findbgsbybglid(bglid);
        model.addAttribute("bgs",bgs);

        //插入bgl后 查询bgl id 然后设置给cts bgs 然后再插入bgs cts
        return "zz/testaaa";
    }

    @ResponseBody
    @RequestMapping(value = "/testa.do", method=RequestMethod.POST,produces = "application/json ;charset=UTF-8")
    public String testa(@RequestParam String query){
        UserDao ud = new UserDao();
        List<User> us= new ArrayList<User>();
        us = ud.selectUserListbyquery(query);
        List<String> ss = new ArrayList<>();
        String ub = null;
        for(int i=0;i<us.size();i++){
            ub=us.get(i).getUsername()+"---"+us.get(i).getBumen();
            ss.add(ub);
        }
        Gson gson = new Gson();
        String jsondata = gson.toJson(ss);
        System.out.println(jsondata);
        return jsondata;
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session,SessionStatus sessionStatus){
        session.removeAttribute("user");
        System.out.println("logout:"+session.getAttribute("user"));
        sessionStatus.setComplete();
        return "zz/login";
    }

}
