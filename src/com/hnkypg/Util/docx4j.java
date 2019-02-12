package com.hnkypg.Util;
import com.hnkypg.anliutil.anjuke;
import com.hnkypg.anliutil.ganji;
import com.hnkypg.anliutil.sofang;
import com.hnkypg.dao.AnliDao;
import com.hnkypg.pojo.anli;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.SpreadsheetMLPackage;
import org.docx4j.openpackaging.parts.SpreadsheetML.WorkbookPart;
import org.docx4j.openpackaging.parts.SpreadsheetML.WorksheetPart;
import org.xlsx4j.org.apache.poi.ss.usermodel.DataFormatter;
import org.xlsx4j.sml.SheetData;
import org.xlsx4j.sml.Worksheet;
/**
 * Created by python on 2017-8-4.
 */
public class docx4j {
    public static void main (String[] args) throws Exception {
        sofang sf = new sofang();
        anjuke ajk = new anjuke();
        ganji gj = new ganji();
        //读取Execl文件
        String inputfilepath =  "G:/桌面/案例/2018-1/2018-1-19/郑州市/2018-1-19/赶集网.xlsx";
        String inputlj ="G:/桌面/案例/2017-8/8-4/";
        // Open a document from the file system
        SpreadsheetMLPackage xlsxPkg = SpreadsheetMLPackage.load(new java.io.File(inputfilepath));

        WorkbookPart workbookPart = xlsxPkg.getWorkbookPart();
        WorksheetPart sheet = workbookPart.getWorksheet(0);

        DataFormatter formatter = new DataFormatter();

       /*
        * 获取excel文件中的表格内容 然后存入到LIST里
        * */


        List<anli> als = new ArrayList<>();

        if(inputfilepath.indexOf("58")!=-1){
            //58
            als = five(sheet,formatter,inputfilepath);
        }else if(inputfilepath.indexOf("安居")!=-1){
            //anjuke
             als = ajk.ajk(sheet,formatter,inputfilepath);
        }else if(inputfilepath.indexOf("赶集网")!=-1){
            //ganjiwang
            als = gj.ganji(sheet,formatter,inputfilepath);
        }else{
            //sofang
             als = sf.so(sheet,formatter,inputfilepath);
        }

        //写入数据库中
        AnliDao ald = new AnliDao();
        ald.insertAnli(als);

    }

    public static void traverseFolder2(String path) {
        List<String> fs = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");

            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        String aaa = file2.getAbsolutePath().toString();
                        System.out.println(aaa);
                        fs.add(aaa);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }

    }

    private static List<anli> five(WorksheetPart sheet, DataFormatter formatter,String inputfilepath) throws Docx4JException {

        Worksheet ws = sheet.getContents();
        SheetData data = ws.getSheetData();
        System.out.println(data.getRow().size());
        int chaoxiang = 0;
        String weizhi = null;
        String zongs = null;
        float zong = 0;
        float suo = 0;
        int shi = 0;
        int ting =0;
        int wei =0;
        float danjia =0;
        float mianji = 0;
        float zongjia =0;

        String[] iii = inputfilepath.split("/");
        String quyu = iii[5];
        java.sql.Date da = new java.sql.Date(new java.util.Date().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        da = java.sql.Date.valueOf(sdf.format(da));
        List<anli> als = new ArrayList();
        for (int k =1;k<data.getRow().size();k++ ) {
            System.out.println("row " + data.getRow().get(k).getR() );
            anli al = new anli();

            for(int i =0; i< data.getRow().get(k).getC().size();i++){

                if(i==0){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setProname("");
                    }else{
                        text=text.replaceAll("\\s*", "");
                        al.setProname(text);
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else if(i==1){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setGuapai("");
                    }else{
                        text=text.substring(0,10);
                        al.setGuapai(text);
                    }

                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else if(i==2){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setJungong("");
                    }else{
                        text=text.replace("年", "");
                        al.setJungong(text);
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else if(i==3){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));

                    if(text.equals("北")){
                        chaoxiang = 4;
                    }else if(text.indexOf("南")!=-1){
                        chaoxiang = 2;
                    }else{
                        chaoxiang = 1;
                    }
                    al.setChaoxiang(chaoxiang);


                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + chaoxiang);
                }else if(i==4){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.indexOf("共")!=-1){
                        weizhi =text.substring(0, 1);
                        if(text.indexOf("共") == 0){
                            zongs = text.substring(text.indexOf("共")+1);
                            zong = Float.parseFloat(zongs.replace("层", ""));
                            suo = 1;
                        }else{
                            zongs = text.substring(text.length()-text.indexOf("共"));
                            if(zongs.indexOf("共")!=-1){
                                zongs = zongs.replaceAll("共", "");
                                zong = Float.parseFloat(zongs.replace("层", ""));
                            }else{
                                zong = Float.parseFloat(zongs.replace("层", ""));
                            }
                            if(weizhi.equals("高")){
                                suo = zong-1;
                                suo =(float)(Math.round(suo*1)/1);
                                if(suo<1){
                                    suo=1;
                                }
                            }else if(weizhi.equals("中")){
                                suo = zong/3*2-1;
                                suo =(float)(Math.round(suo*1)/1);
                                if(suo<1){
                                    suo=1;
                                }
                            }else{
                                suo = zong/3-1;
                                suo =(float)(Math.round(suo*1)/1);
                                if(suo<1){
                                    suo=1;
                                }
                            }
                        }
                        al.setZong(zong);
                        al.setSuo(suo);
                        System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + zong+"+++"+suo);
                    }else{
                        al.setZong(0);
                        al.setSuo(0);
                    }

                }else if(i==5){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.indexOf("室")!=-1&&text.indexOf("厅")!=-1&&text.indexOf("卫")!=-1){
                        shi =Integer.parseInt(text.substring(0,1)) ;
                        ting = Integer.parseInt(text.substring(2,3)) ;
                        wei = Integer.parseInt(text.substring(4,5)) ;
                        al.setShi(shi);
                        al.setTing(ting);
                        al.setWei(wei);
                    }else {
                        al.setShi(0);
                        al.setTing(0);
                        al.setWei(0);
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + shi+"+++"+ting+"+++"+wei);
                }else if(i==6){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setMianji(0);
                        System.out.println("错误信息采集");
                    }else{
                        if(text.indexOf("㎡")!=1){
                            mianji =Float.parseFloat(text.replaceAll("㎡","")) ;
                            al.setMianji(mianji);
                        }else{
                            al.setMianji(0);
                        }
                    }

                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + mianji);
                }else if(i==7){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setZongjia(0);
                        al.setDanjia(0);
                    }else{
//						zongjia = text.indexOf("万");

                        zongjia = Float.parseFloat(text.substring(0,text.indexOf("万")));
                        danjia = Float.parseFloat(text.substring(text.indexOf("单价")+2,text.indexOf("元")));
                        al.setZongjia(zongjia);
                        al.setDanjia(danjia);
                    }

                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + zongjia+"+++"+danjia);
                }else{
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    al.setUrl(text);
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }
                al.setFangwojiegou("");
                al.setFangwoleixing("");
                al.setJingguan("");
                al.setZhuangxiu("");
                al.setQuyu(quyu);
                al.setDate(da);
            }
            als.add(al);
        }
        return als;
    }
}
