package com.hnkypg.jsb.controller;

import com.google.gson.Gson;
import com.hnkypg.Util.*;
import com.hnkypg.dao.BaoGaoDao;
import com.hnkypg.dao.yanzDao;
import com.hnkypg.pojo.*;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by python on 2018-3-20.
 */

@Controller
@SessionAttributes("user")
public class erweimaController {


    //登录到信息录入页面
    @RequestMapping(value = "/ewmlist.do")
    public String ewmlist(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "zz/login";
        }else{
            return "yanzheng/list";
        }

    }

    //技术部登录到信息录入页面
    @RequestMapping(value = "/jsbewmlist.do")
    public String jsbewmlist(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "zz/login";
        }else{
            return "yanzheng/jsblist";
        }

    }


    //登录到信息录入页面
    @RequestMapping(value = "/ewminput.do")
    public String ewminput(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "zz/login";
        }else {
            return "yanzheng/input";
        }

    }

    //报告上传后的处理
    @RequestMapping(value = "/yzupdatefile.do")
    public String yzupdatefile(MultipartFile uploadFile, ModelMap model, HttpServletRequest request) throws Exception {
        String bgnum = request.getParameter("bgnum");
        String bgname = request.getParameter("bgname");
        String gujiashi = request.getParameter("gujiashi");
        String jigou = request.getParameter("jigou");
        Float zongjia = Float.valueOf(request.getParameter("zongjia"));
        Float mianji = Float.valueOf(request.getParameter("mianji"));
        Date chujudate = Date.valueOf(request.getParameter("chujudate"));
        String memo = request.getParameter("memo");

        CreateQRCode2 cqr = new CreateQRCode2();
        baogaoyanzheng bgyz = new baogaoyanzheng();

        if (bgnum.isEmpty()) {
            bgyz.setBgnum("");
        } else {
            bgyz.setBgnum(bgnum);
        }

        if (bgname.isEmpty()) {
            bgyz.setBgname("");
        } else {
            bgyz.setBgname(bgname);
        }

        if (gujiashi.isEmpty()) {
            bgyz.setGujiashi("");
        } else {
            bgyz.setGujiashi(gujiashi);
        }

        if (jigou.isEmpty()) {
            bgyz.setPinggujigou("");
        } else {
            bgyz.setPinggujigou(jigou);
        }

        if (zongjia < 0) {
            bgyz.setZongjia((float) 0);
        } else {
            bgyz.setZongjia(zongjia);
        }

        if (mianji < 0) {
            bgyz.setJianzhumianji((float) 0);
        } else {
            bgyz.setJianzhumianji(mianji);
        }

        if (chujudate == null) {
            bgyz.setChujudate(null);
        } else {
            bgyz.setChujudate(chujudate);
        }





        TripleDESTest tdt = new TripleDESTest();
        RandomStr rstr = new RandomStr();
        String password = rstr.getRandomStr(15);
        String dkey = rstr.getRandomStr(10);
        DESUtil desu = new DESUtil(dkey);
        String pkey = "";
        suoyin sy = new suoyin();

//        从对应表中找出来ID添加到最后
        yanzDao yzd = new yanzDao();
        int maxid = yzd.findmaxid();

        Boolean tiaojian = true;
        do {
            pkey = rstr.getRandomStr(8);
            pkey = pkey + "00000" + maxid;
            int count = yzd.findpkeyif(pkey);
            if (count == 0) {
                tiaojian = false;
            }

        } while (tiaojian);

        String enc1 = desu.encryptStr(password);
        String enc2 = desu.encryptStr(enc1);
//        String enc1 = tdt.getEncString(password, dkey);
//        String enc2 = tdt.getTwiceEncString(password, dkey);
        System.out.println(pkey + "+++++++++++++++++++++");
        System.out.println(dkey + "+++++++++++++++++++++");
        System.out.println(enc1 + "+++++++++++++++++++++");
        System.out.println(enc2 + "+++++++++++++++++++++");
        bgyz.setTwiceEncString(enc2);
        sy.setPkey(pkey);
        sy.setDkey(dkey);
        sy.setEncString(enc1);
        yzd.insertsuoyin(sy);


//        String enc = decn.encode(bgyz.getBgnum());

        String qrpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/yanzheng/qrcode");
        qrpath = qrpath + "/" + bgyz.getBgnum() + ".png";

        cqr.QRcode(pkey, qrpath);

        String leftpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/yanzheng/upload");
//        String fileName = uploadFile.getOriginalFilename();
        String fileName = bgyz.getBgnum() + ".docx";
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath, fileName);
        //保存
        uploadFile.transferTo(file);

        Map m1 = new HashMap();
        m1.put("leftpath", leftpath);
        m1.put("filename", fileName);
        m1.put("qrpath", qrpath);
        System.out.println(m1.get("leftpath") + "++++++++++++++++++++");
        System.out.println(m1.get("filename") + "++++++++++++++++++++");

        replace2 rep = new replace2();
        String jieguo = rep.replace(m1);


//        Word2Pdf w2p = new Word2Pdf();
//        w2p.wtop(leftpath, bgyz.getBgnum());
//        WordToPdf d = new WordToPdf();
//        d.wordToPDF(leftpath, bgyz.getBgnum());
//        String pdfname = bgyz.getBgnum() + ".pdf";

        System.out.println(jieguo + "++++++++++++++++++++");
        model.addAttribute("downloadurl", fileName);
//        model.addAttribute("downloadpdf", pdfname);


        bgyz.setStatus(1);
        java.util.Date date = new java.util.Date();
        java.sql.Date data1 = new java.sql.Date(date.getTime());
        bgyz.setCreatedate(data1);
        System.out.println(data1);
        yzd.insertbgyz(bgyz);

        return "yanzheng/input_result";
    }

    //下载模块
    @RequestMapping("/testHttpMessageDown.do")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        String leftpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/yanzheng/upload/result/");
        String testname = leftpath + request.getParameter("filename");
        System.out.println(testname + "++++++++++++++");
        File file = new File(testname);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }


    //扫码后的后台处理
    @RequestMapping(value = "/yanzheng.do")
    public String yanzheng(MultipartFile uploadFile, ModelMap model, HttpServletRequest request) throws Exception {
        String key = request.getParameter("key");

        yanzDao yzd = new yanzDao();

        suoyin sy = yzd.findpsw(key);
//        TripleDESTest tdt = new TripleDESTest();
        DESUtil desu = new DESUtil(sy.getDkey());
        String decn1 = desu.decryptStr(sy.getEncString());
        System.out.println("第一次解压后的字符串"+decn1);
        String onej = desu.encryptStr(decn1);
        String TwiceEncString = desu.encryptStr(onej);
//        String decn1 = tdt.getDecString(sy.getEncString(), sy.getDkey());
//        String TwiceEncString = tdt.getTwiceEncString(decn1, sy.getDkey());
//        DeEnCode decn = new DeEnCode();
//        EncrypDES3 dec = new EncrypDES3();
//        byte[] encontent = key.getBytes("utf-8");
//        String bgnum =  new String(dec.Decryptor(encontent));
//        String bgnum =  decn.decode(key);
        System.out.println(TwiceEncString + "++++++++++++++++++++");

        baogaoyanzheng bgyz = yzd.findbgyanzheng(TwiceEncString);
        model.addAttribute("bgyz", bgyz);

//        System.out.println("能不能扫描过来了呢"+ "++++++++"+bgyz.getBgname());
//        System.out.println("测试 状态值是多少");
        if (bgyz.getStatus() == 1) {

            return "yanzheng/yanzheng";
        } else {
            return "yanzheng/shixiao";
        }

    }


    //获取报告清单内容
    @ResponseBody
    @RequestMapping(value = "/ewmtablelist.do", method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String ewmtablelist(HttpServletRequest request, ModelMap model) {
        sreach s = new sreach();
        String l = request.getParameter("limit");
        String o = request.getParameter("offset");

        if (l == null && o == null) {
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            s.setSelect(request.getParameter("select"));
            if (startdate.length() > 0) {
                s.setStartdate(Date.valueOf(startdate));
            }
            if (enddate.length() > 0) {
                s.setEnddate(Date.valueOf(enddate));
            }

            s.setText(request.getParameter("text"));
            int counts = 0;
            Gson gson = new Gson();
            List<baogaoyanzheng> bgyzs = new ArrayList<baogaoyanzheng>();
            yanzDao yzd = new yanzDao();
            if (s.getSelect().equals("all")) {
                if (s.getEnddate() != null && s.getStartdate() != null) {
                    if (s.getStartdate().getTime() >= s.getEnddate().getTime()) {
                        model.addAttribute("error", "截止日期不能小于起始日期");
                        return "index_error";
                    } else {
                        bgyzs = yzd.findbgyzsbydate(s);
                        counts = yzd.countfindbgyzsbydate(s);
                        System.out.println("++++++++++++++++从这1走吗？");
                    }
                } else if (s.getStartdate() == null && s.getEnddate() == null) {
                    bgyzs = yzd.selectbgyzs();
                    counts = yzd.countfindbgyzs();
                    System.out.println("++++++++++++++++从这2走吗？");
                } else {
                    model.addAttribute("error", "日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            }
            String jsondata = gson.toJson(bgyzs);
            jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
//            System.out.println(jsondata);
//            System.out.println(counts);
            return jsondata;

        } else {
            int limit = Integer.parseInt(request.getParameter("limit"));
            int offset = Integer.parseInt(request.getParameter("offset"));

            List<baogaoyanzheng> bgyzs = new ArrayList<baogaoyanzheng>();
            yanzDao yzd = new yanzDao();
            s.setLimit(limit);
            s.setOffset(offset);
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            s.setSelect(request.getParameter("select"));
            if (startdate.isEmpty()) {
                s.setStartdate(null);
            } else {
                s.setStartdate(Date.valueOf(startdate));
            }
            if (enddate.isEmpty()) {
                s.setEnddate(null);
            } else {
                s.setEnddate(Date.valueOf(enddate));
            }

            s.setText(request.getParameter("text"));
            int counts = 0;

            if (s.getSelect().equals("all")) {
                if (s.getEnddate() != null && s.getStartdate() != null) {
                    if (s.getStartdate().getTime() >= s.getEnddate().getTime()) {
                        model.addAttribute("error", "截止日期不能小于起始日期");
                        return "index_error";
                    } else {

                    }
                } else if (s.getStartdate() == null && s.getEnddate() == null) {
                    bgyzs = yzd.findbgyzsbydateol(s);
                    counts = yzd.countfindbgyzsbydateol(s);
                    System.out.println(bgyzs.get(0).getCreatedate());
                } else {
                    model.addAttribute("error", "日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }


            } else if (s.getSelect().equals("bgnum")) {
                if (s.getEnddate() != null && s.getStartdate() != null) {
                    if (s.getStartdate().getTime() >= s.getEnddate().getTime()) {
                        model.addAttribute("error", "截止日期不能小于起始日期");
                        return "index_error";
                    } else {

                    }
                } else if (s.getStartdate() == null && s.getEnddate() == null) {

                } else {
                    model.addAttribute("error", "日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            } else if (s.getSelect().equals("zuoluo")) {
                if (s.getEnddate() != null && s.getStartdate() != null) {
                    if (s.getStartdate().getTime() >= s.getEnddate().getTime()) {
                        model.addAttribute("error", "截止日期不能小于起始日期");
                        return "index_error";
                    } else {

                    }
                } else if (s.getStartdate() == null && s.getEnddate() == null) {

                } else {
                    model.addAttribute("error", "日期必须选择起始和截止日期必须都选，不能只选一个");
                    return "index_error";
                }
            }
            System.out.println("+++++++++++++++++++++莫非这里走的？");
            Gson gson1 = new Gson();
            String jsondata = gson1.toJson(bgyzs);
            jsondata = "{ \"total\": " + counts + " ,\"rows\":" + jsondata + "}";
//            System.out.println(jsondata);
//            System.out.println(counts);
            return jsondata;
        }

    }

    //撤销报告状态值

    @RequestMapping(value = "/baogaochexiao.do", method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String baogaochexiao(HttpServletRequest request, ModelMap model) {

        int bgyzid = Integer.valueOf(request.getParameter("bgyzid"));
        yanzDao yzd = new yanzDao();
        yzd.updatebgyzstatus(bgyzid);

        return "yanzheng/list";
    }

    @RequestMapping(value = "/testresult.do", method = RequestMethod.GET, produces = "application/json ;charset=UTF-8")
    public String testresult(HttpServletRequest request, ModelMap model) {

        return "yanzheng/test";
    }


    @RequestMapping("/displayPDF.do")
    public void displayPDF(HttpServletResponse response) {
        try {
            File file = new File("e:\\test1.pdf");
            FileInputStream fileInputStream = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment;fileName=test.pdf");
            response.setContentType("multipart/form-data");
            OutputStream outputStream = response.getOutputStream();
            IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    报告登记系统转换

    @RequestMapping(value = "/ewmbglist.do")
    public String ewmbglist(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "zz/login1";
        }else {
            return "yanzheng/bglist";
        }

    }

    //从登记系统中直接转换添加二维码
    @RequestMapping(value = "/ewmbglistedit.do")
    public String ewmbglistedit(HttpSession session ,HttpServletRequest request,ModelMap model) {
        User user = (User) session.getAttribute("user");

        System.out.println("+++++++++"+user.getUsername()+"++++++++++++++");
        int bglid = Integer.valueOf(request.getParameter("bglid"));
        BaoGaoDao bgd = new BaoGaoDao();
        baogaoyanzheng bgz = new baogaoyanzheng();
        yanzDao yzd = new yanzDao();
        BaoGaoList bgl = bgd.findbglbyidss(bglid);
        float mianj = 0;

        if(yzd.findbgnumyanzif(bgl.getBgnum())==0){
            System.out.println("正常可以转换添加二维码");
        }else {
            model.addAttribute("error","该报告已经添加二维码了，不要重复添加");
            return "zz/select";
        }
        if(bgl.getBaogaotype().equals("正式报告")){
            bgz.setBgnum(bgl.getBgnum());
            bgz.setPinggujigou("河南开源房地产估价有限公司");
            bgz.setGujiashi(bgl.getGujiashi());
            bgz.setZongjia(bgl.getZongjias());
            bgz.setBgname(bgl.getZuoluo());
            bgz.setChujudate(bgl.getChujudate());
            List<BaoGao> bgs = bgd.findbgsbybglidss(bgl.getId());
            if(bgs.isEmpty()){
                model.addAttribute("error","bglid错误 请联系管理员处理！");
                return "zz/select";
            }else{
               for (int i = 0; i<bgs.size();i++){
                   mianj =  mianj + bgs.get(i).getMianji();
               }
               bgz.setJianzhumianji(mianj);
            }
            model.addAttribute("bgz",bgz);
            return "yanzheng/bglistedit";

        }else{
            model.addAttribute("error","只能对正式报告添加二维码，请选择正式报告");
            return "zz/select";
        }

    }



    //下载模块
    @RequestMapping("/Downloadpdf.do")
    public ResponseEntity<byte[]> Downloadpdf(HttpServletRequest request) throws IOException {
        String leftpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/yanzheng/upload/result/");
        int bgyzid = Integer.valueOf(request.getParameter("bgyzid")) ;
        yanzDao yzd = new yanzDao();
        baogaoyanzheng bgz = yzd.findbgyzbybgzid(bgyzid);
        String testname ="";
        if(bgz==null){
            System.out.println("出错了，无效二维码验证报告ID！");
        }else {
             testname = leftpath + bgz.getBgnum()+".docx";
        }

        System.out.println(testname + "++++++++++++++");
        File file = new File(testname);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }




    //测试
    @RequestMapping(value = "/testwordtopdf.do")
    public String testwordtopdf( MultipartFile uploadFile,ModelMap model, HttpServletRequest request,HttpSession session) throws Exception {
        String bgnum = request.getParameter("bgnum");
        String bgname = request.getParameter("bgname");
        String gujiashi = request.getParameter("gujiashi");
        String jigou = request.getParameter("jigou");
        Float zongjia = Float.valueOf(request.getParameter("zongjia"));
        Float mianji = Float.valueOf(request.getParameter("mianji"));
        Date chujudate = Date.valueOf(request.getParameter("chujudate"));

        CreateQRCode2 cqr = new CreateQRCode2();
        baogaoyanzheng bgyz = new baogaoyanzheng();

        if (bgnum.isEmpty()) {
            bgyz.setBgnum("");
        } else {
            bgyz.setBgnum(bgnum);
        }

        if (bgname.isEmpty()) {
            bgyz.setBgname("");
        } else {
            bgyz.setBgname(bgname);
        }

        if (gujiashi.isEmpty()) {
            bgyz.setGujiashi("");
        } else {
            bgyz.setGujiashi(gujiashi);
        }

        if (jigou.isEmpty()) {
            bgyz.setPinggujigou("");
        } else {
            bgyz.setPinggujigou(jigou);
        }

        if (zongjia < 0) {
            bgyz.setZongjia((float) 0);
        } else {
            bgyz.setZongjia(zongjia);
        }

        if (mianji < 0) {
            bgyz.setJianzhumianji((float) 0);
        } else {
            bgyz.setJianzhumianji(mianji);
        }

        if (chujudate == null) {
            bgyz.setChujudate(null);
        } else {
            bgyz.setChujudate(chujudate);
        }


        DeEnCode decn = new DeEnCode();
        TripleDESTest tdt = new TripleDESTest();
        RandomStr rstr = new RandomStr();
        String password = rstr.getRandomStr(15);
        String dkey = rstr.getRandomStr(10);
        DESUtil desu = new DESUtil(dkey);
        String pkey = "";
        suoyin sy = new suoyin();

//        从对应表中找出来ID添加到最后
        yanzDao yzd = new yanzDao();
        int maxid = yzd.findmaxid();

        Boolean tiaojian = true;
        do {
            pkey = rstr.getRandomStr(8);
            pkey = pkey + "00000" + maxid;
            int count = yzd.findpkeyif(pkey);
            if (count == 0) {
                tiaojian = false;
            }

        } while (tiaojian);

        String enc1 = desu.encryptStr(password);
        String enc2 = desu.encryptStr(enc1);
//        String enc1 = tdt.getEncString(password, dkey);
//        String enc2 = tdt.getTwiceEncString(password, dkey);
        System.out.println(pkey + "+++++++++++++++++++++");
        System.out.println(dkey + "+++++++++++++++++++++");
        System.out.println(enc1 + "+++++++++++++++++++++");
        System.out.println(enc2 + "+++++++++++++++++++++");
        bgyz.setTwiceEncString(enc2);
        sy.setPkey(pkey);
        sy.setDkey(dkey);
        sy.setEncString(enc1);
        yzd.insertsuoyin(sy);


//        String enc = decn.encode(bgyz.getBgnum());

        String qrpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/yanzheng/qrcode");
        qrpath = qrpath + "/" + bgyz.getBgnum() + ".png";

        cqr.QRcode(pkey, qrpath);

        String leftpath = request.getSession().getServletContext().getRealPath("/WEB-INF/views/yanzheng/upload");
//        String fileName = uploadFile.getOriginalFilename();
        String fileName = bgyz.getBgnum() + ".docx";
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(leftpath);
        System.out.println(fileName);
        File file = new File(leftpath, fileName);
        //保存
        uploadFile.transferTo(file);

        Map m1 = new HashMap();
        m1.put("leftpath", leftpath);
        m1.put("filename", fileName);
        m1.put("qrpath", qrpath);
        System.out.println(m1.get("leftpath") + "++++++++++++++++++++");
        System.out.println(m1.get("filename") + "++++++++++++++++++++");

        replace2 rep = new replace2();
        String jieguo = rep.replace(m1);


//        Word2Pdf w2p = new Word2Pdf();
//        w2p.wtop(leftpath, bgyz.getBgnum());
//        WordToPdf d = new WordToPdf();
//        d.wordToPDF(leftpath, bgyz.getBgnum());
//        String pdfname = bgyz.getBgnum() + ".pdf";

        System.out.println(jieguo + "++++++++++++++++++++");
        model.addAttribute("downloadurl", fileName);
//        model.addAttribute("downloadpdf", pdfname);


        bgyz.setStatus(1);
        java.util.Date date = new java.util.Date();
        java.sql.Date data1 = new java.sql.Date(date.getTime());
        bgyz.setCreatedate(data1);
        System.out.println(data1);
        yzd.insertbgyz(bgyz);
        return "zz/index";

    }

}