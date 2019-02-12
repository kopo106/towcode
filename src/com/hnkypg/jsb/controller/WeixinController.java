package com.hnkypg.jsb.controller;

import com.google.gson.Gson;
import com.hnkypg.Util.URLConnection;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Created by python on 2017-9-9.
 */
@Controller
public class WeixinController {

        @RequestMapping(value = "weixinlogin.do",method = RequestMethod.GET)
        public String testweixinlogin(HttpServletRequest request, HttpServletResponse response){
            return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7ae69c529e0c1994&" +
                    "redirect_uri=http://222.85.127.116:2020/jsb/oauth.do&" +
                    "response_type=code&scope=snsapi_base&state=1#wechat_redirect ";
        }

        @RequestMapping(value = "oauth.do",method = RequestMethod.GET)
        public String oauth(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
            //得到code
            String CODE = request.getParameter("code");
            String APPID = "wx7ae69c529e0c1994";
            String SECRET = "9b07bf0ec22a63c63a5d4d6de51e1dfa";
            //换取access_token 其中包含了openid
            String URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
            String pam ="appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code".replace("APPID", APPID).replace("SECRET", SECRET).replace("CODE", CODE);
            //URLConnectionHelper是一个模拟发送http请求的类
            String jsonStr = URLConnection.sendGet(URL,pam);
            //System.out.println(jsonStr);
            //out.print(jsonStr)

//            JSONObject jsonObj = new JSONObject.fromJSONString(jsonStr);

//            String openid = jsonObj.get("openid").toString();
            //有了用户的opendi就可以的到用户的信息了
            //地址为https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
            //得到用户信息之后返回到一个页面

            System.out.println(jsonStr);
            modelMap.addAttribute("info","通过验证近来访问的");
            return "testindex";
        }
}
