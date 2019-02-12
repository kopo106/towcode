package com.hnkypg.jsb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
@Controller

public class Hellocontroller {
    @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
    public String printWelcom(ModelMap model){
        model.addAttribute("message","HelloWorld");
        model.addAttribute("content","这是我的第一个springmvc");
        return "zz/hello";
    }

    @RequestMapping(value = "/testmodal.do", method = RequestMethod.GET)
    public String testmodal(ModelMap model){
        model.addAttribute("message","HelloWorld");
        model.addAttribute("content","这是我的第一个springmvc");
        return "zz/test";
    }

    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public String result(ModelMap map , @RequestParam String name, @RequestParam int age){
        map.addAttribute("name",name);
        map.addAttribute("age",age);
        return "zz/result";
        //传参数不能传汉字 只能英文
    }


//    @RequestMapping(value = "/add_user",method = RequestMethod.GET)
//    public String adduser(ModelMap map){
//        User user =new User();
//        user.setAge(19);
//        map.addAttribute(user);
//        return "add_user";
//    }
}
