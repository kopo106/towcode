package com.hnkypg.anliutil;

import com.hnkypg.pojo.anli;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.parts.SpreadsheetML.WorksheetPart;
import org.xlsx4j.org.apache.poi.ss.usermodel.DataFormatter;
import org.xlsx4j.sml.SheetData;
import org.xlsx4j.sml.Worksheet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by python on 2017-8-5.
 */
public class anjuke {
    public static List<anli> ajk(WorksheetPart sheet, DataFormatter formatter, String inputfilepath) throws Docx4JException {

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
        int huxing =0;
        int louceng = 0;
        int niandai = 0;
        int cxiang =0;

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
                    }else {
                        text=text.replaceAll("\\s*", "");
                        al.setProname(text);
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else if(i==1){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                       al.setGuapai("");
                    }else{
                        text =  text.substring(text.indexOf("发布时间：")+5);
                        text = text.replace("年","-");
                        text = text.replace("月","-");
                        text = text.replace("日","");
                        al.setGuapai(text);
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else if (i==2){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.indexOf("年")!=-1){
                        text = text.replace("年","");
                        al.setJungong(text);
                    }else{
                        al.setJungong("");
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getJungong());
                }else if (i==3){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setChaoxiang(1);
                    }else{
                        if(text.indexOf("南")!=-1){
                            al.setChaoxiang(2);
                        }else if(text.equals("北")){
                            al.setChaoxiang(4);
                        }else {
                            al.setChaoxiang(1);
                        }
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getChaoxiang());
                }else if (i==4){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setZong(6);
                        al.setSuo(1);
                    }else{
                        weizhi = text.substring(0,1);
                        zongs = text.substring(text.indexOf("共")+1,text.length());
                        if(zongs.indexOf(")")!=-1){
                            zongs = zongs.replaceAll("\\)","");
                            zongs = zongs.replaceAll("层","");
                            zong = Float.parseFloat(zongs);
                            if(zong<1){
                                zong = 1;
                                suo = 1;
                            }else {
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
                        }else{
                            zongs = zongs.replaceAll("层","");
                            zong = Float.parseFloat(zongs);
                            suo = 1;
                        }
                        al.setSuo(suo);
                        al.setZong(zong);
                        System.out.println(zong +"--+++--"+suo);
                    }
                }else if(i==5){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    text=text.replaceAll("\\s*", "");
                    if(text.substring(0,text.indexOf("室")).isEmpty()){
                        al.setShi(0);
                    }else{
                        shi = Integer.parseInt(text.substring(0,text.indexOf("室")));
                        al.setShi(shi);
                    }
                    if(text.substring(text.indexOf("室")+1,text.indexOf("厅")).isEmpty()){
                        al.setTing(0);
                    }else{
                        ting =Integer.parseInt(text.substring(text.indexOf("室")+1,text.indexOf("厅")));
                        al.setTing(ting);
                    }
                    if(text.substring(text.indexOf("厅")+1,text.indexOf("卫")).isEmpty()){
                        al.setWei(0);
                    }else{
                        wei = Integer.parseInt(text.substring(text.indexOf("厅")+1,text.indexOf("卫")));
                        al.setWei(wei);
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else if(i==6){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setMianji(0);
                    }else{
                        if(text.indexOf("平方米")!=-1){
                            al.setMianji(Float.parseFloat(text.replace("平方米","")));
                        }else{
                            al.setMianji(0);
                        }
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getMianji());
                }else if(i==7){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setZongjia(0);
                    }else{
                        al.setZongjia(Float.parseFloat(text));
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getZongjia());
                }else if(i==8){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setDanjia(0);
                    }else{
                        text=text.replaceAll("\\s*", "");
                        if(text.indexOf("元/m²")!=-1){
                            al.setDanjia(Float.parseFloat(text.replaceAll("元/m²","")));
                        }else{
                            al.setDanjia(0);
                        }
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getDanjia());
                }else if(i==9){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setUrl("");
                    }else{
                        if(text.indexOf("http://")!=-1||text.indexOf("https://")!=-1){
                            al.setUrl(text);
                        }else{
                            al.setUrl("");
                        }

                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else{
                    System.out.println("采集错误");
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
