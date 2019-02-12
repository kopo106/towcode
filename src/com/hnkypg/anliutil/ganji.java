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
public class ganji {
    public static List<anli> ganji(WorksheetPart sheet, DataFormatter formatter, String inputfilepath) throws Docx4JException {

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
                        text = text.substring(0,10);
                        al.setGuapai(text);
                    }
                }else if(i==2){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setChaoxiang(1);
                    }else {
                        if (text.indexOf("南") != -1) {
                            al.setChaoxiang(2);
                        } else if (text.equals("北向")) {
                            al.setChaoxiang(4);
                        } else {
                            al.setChaoxiang(1);
                        }
                    }
                }else if(i==3){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setZong(6);
                        al.setSuo(1);
                    }else {
                        weizhi = text.substring(0, 1);
                        zongs = text.substring(text.indexOf("共") + 1, text.length());
                        if (zongs.indexOf("）") != -1) {
                            zongs = zongs.replaceAll("）", "");
                            zongs = zongs.replaceAll("层", "");
                            zong = Float.parseFloat(zongs);
                            if (zong < 1) {
                                zong = 1;
                                suo = 1;
                            } else {
                                if (weizhi.equals("高")) {
                                    suo = zong - 1;
                                    suo = (float) (Math.round(suo * 1) / 1);
                                    if (suo < 1) {
                                        suo = 1;
                                    }
                                } else if (weizhi.equals("中")) {
                                    suo = zong / 3 * 2 - 1;
                                    suo = (float) (Math.round(suo * 1) / 1);
                                    if (suo < 1) {
                                        suo = 1;
                                    }
                                } else {
                                    suo = zong / 3 - 1;
                                    suo = (float) (Math.round(suo * 1) / 1);
                                    if (suo < 1) {
                                        suo = 1;
                                    }
                                }
                            }
                        } else {
                            zongs = zongs.replaceAll("层", "");
                            zong = Float.parseFloat(zongs);
                            suo = 1;
                        }
                        al.setSuo(suo);
                        al.setZong(zong);
                        System.out.println(zong + "--+++--" + suo);
                    }
                }else if(i==4){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    text=text.replaceAll("\\s*", "");
                    if(text.isEmpty()){
                        al.setShi(0);
                        al.setTing(0);
                        al.setWei(0);
                        System.out.println("全走这里了吗");
                    }else{
                        if(text.indexOf("室")!=-1&&text.indexOf("厅")!=-1&&text.indexOf("卫")!=-1){
                            shi = Integer.parseInt(text.substring(0,text.indexOf("室")));
                            al.setShi(shi);
                            ting =Integer.parseInt(text.substring(text.indexOf("室")+1,text.indexOf("厅")));
                            al.setTing(ting);
                            wei = Integer.parseInt(text.substring(text.indexOf("厅")+1,text.indexOf("卫")));
                            al.setWei(wei);
                        }else if(text.indexOf("室")!=-1&&text.indexOf("厅")!=-1){
                            shi = Integer.parseInt(text.substring(0,text.indexOf("室")));
                            al.setShi(shi);
                            ting =Integer.parseInt(text.substring(text.indexOf("室")+1,text.indexOf("厅")));
                            al.setTing(ting);
                            al.setWei(1);
                        }else if(text.indexOf("室")!=-1&&text.indexOf("卫")!=-1){
                            shi = Integer.parseInt(text.substring(0,text.indexOf("室")));
                            al.setShi(shi);
                            wei =Integer.parseInt(text.substring(text.indexOf("室")+1,text.indexOf("卫")));
                            al.setWei(wei);
                            al.setTing(0);
                        }else if(text.indexOf("室")!=-1){
                            shi = Integer.parseInt(text.substring(0,text.indexOf("室")));
                            al.setShi(shi);
                            al.setTing(0);
                            al.setWei(0);
                        }else{
                            al.setShi(0);
                            al.setTing(0);
                            al.setWei(0);
                        }
                    }

                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getShi()+"++"+al.getTing()+"++"+al.getWei());
                }else if(i==5){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setMianji(0);
                    }else{
                        if(text.indexOf("㎡")!=-1){
                            text = text.replace("㎡","");
                            al.setMianji(Float.parseFloat(text));
                        }else{
                            al.setMianji(0);
                        }
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getMianji());
                }else if(i==6){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setZongjia(0);
                    }else {
                        al.setZongjia(Float.parseFloat(text));

                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getZongjia());
                }else if(i==7){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setDanjia(0);
                    }else{
                        if(text.indexOf("元/㎡")!=-1){
                            text = text.replace("元/㎡","");
                            System.out.println(text);
                            al.setDanjia(Float.parseFloat(text));
                        }else{
                            al.setDanjia(0);
                        }
                    }
                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + al.getDanjia());
                }else if(i==8){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setUrl("");
                    }else if(text.length()<400){
                        if(text.indexOf("http://")!=-1||text.indexOf("https://")!=-1){
                            al.setUrl(text);
                        }else{
                            al.setUrl("");
                        }

                    }else{
                        al.setUrl("");
                    }
                }else{
                    System.out.println("采集错误数据");
                }
                al.setJungong("");
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
