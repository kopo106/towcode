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
public class sofang {

    public static List<anli> so(WorksheetPart sheet, DataFormatter formatter, String inputfilepath) throws Docx4JException {

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
                    }else{
                        text=text.replaceAll("\\s*", "");
                        al.setProname(text);
                    }

                }else if(i==1){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setGuapai("");
                    }else{
                        text=text.substring(0,10);
                        al.setGuapai(text);
                    }

                }else if(i==2){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    text=text.replaceAll("\\s*", "");
                    String[] aaa = text.split("\\|");
                    System.out.println(text);
                    if(text.isEmpty()){
                        al.setJungong("");
                        al.setZong(0);
                        al.setSuo(0);
                        al.setShi(0);
                        al.setTing(0);
                        al.setWei(0);
                        al.setChaoxiang(0);
                    }else{
                        for(int j=0; j<aaa.length;j++){
                            System.out.println(aaa[j]);
                            if(aaa[j].indexOf("室")!=-1&&text.indexOf("厅")!=-1){
                                System.out.println("shi"+text.substring(0,aaa[j].indexOf("室"))+"shi");
                                System.out.println("ting"+text.substring(aaa[j].indexOf("室")+1,aaa[j].indexOf("厅"))+"ting");
                                shi =Integer.parseInt(text.substring(0,aaa[j].indexOf("室"))) ;

                                ting = Integer.parseInt(text.substring(aaa[j].indexOf("室")+1,aaa[j].indexOf("厅"))) ;

                                al.setShi(shi);
                                al.setTing(ting);
                                al.setWei(1);
                                huxing =1;
                                System.out.println(shi+"+++"+ting+"+++"+wei);
                            }else if(aaa[j].indexOf("层")!=-1){

                                weizhi =aaa[j].substring(0, 1);
                                System.out.println(weizhi);
                                System.out.println(aaa[j].indexOf("共"));
                                if(aaa[j].indexOf("共")<3){
                                    zongs = aaa[j].substring(aaa[j].indexOf("共"));
                                    zongs = zongs.replaceAll("\\(","");
                                    zongs = zongs.replaceAll("\\)","");

                                    System.out.println(zongs+"走的这里吗？");
                                    zong = Float.parseFloat(zongs.replace("层", ""));
                                    suo = 1;
                                }else{
//                                    System.out.println(aaa[j]);
//                                    System.out.println( aaa[j].length()+"++++++"+aaa[j].indexOf("共"));
                                    zongs = aaa[j].substring(aaa[j].indexOf("共"),aaa[j].length());
                                    System.out.println(aaa[j].length()+"---------------+"+aaa[j].indexOf("共"));
                                    System.out.println(zongs);
                                    if(zongs.indexOf("共")!=-1){

                                        if(zongs.indexOf(")")!=-1){
                                            zongs = zongs.replaceAll("共", "");
                                            zongs = zongs.replaceAll("\\)", "");
                                            zong = Float.parseFloat(zongs.replace("层", ""));
                                        }else{
                                            zongs = zongs.replaceAll("共", "");
                                            zong = Float.parseFloat(zongs.replace("层", ""));
                                        }
                                    System.out.println(zong + "++++++++++++++" + suo);

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
                                louceng =1;
                                System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + zong+"+++"+suo);
                            }else if(aaa[j].indexOf("向")!=-1){
                                if(aaa[j].equals("北")){
                                    chaoxiang = 4;
                                }else if(aaa[j].indexOf("南")!=-1){
                                    chaoxiang = 2;
                                }else{
                                    chaoxiang = 1;
                                }
                                al.setChaoxiang(chaoxiang);
                                cxiang =1;
                            }else if(aaa[j].indexOf("年")!=-1){

                                al.setJungong(aaa[j].replace("建筑年代：", ""));
                                niandai = 1;
                            }
                            if(huxing ==0){
                                al.setShi(0);
                                al.setTing(0);
                                al.setWei(0);
                            }
                            if(louceng == 0){
                                al.setZong(6);
                                al.setSuo(1);
                            }
                            if(cxiang == 0){
                                al.setChaoxiang(1);
                            }
                            if(niandai == 0){
                                al.setJungong("");
                            }
                        }
                    }

                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else if(i==3){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setMianji(0);
                    }else {
                        mianji =Float.parseFloat(text.replaceAll("㎡","")) ;
                        al.setMianji(mianji);
                    }
                }else if(i==4){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setZongjia(0);
                    }else {
                        zongjia = Float.parseFloat(text);
                        al.setZongjia(zongjia);
                    }
                }else if(i==5){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setDanjia(0);
                    }else{
                        text = text.replace("元/㎡","");
                        danjia = Float.parseFloat(text);
                        al.setDanjia(danjia);
                    }
                }else if(i==6){
                    String text = formatter.formatCellValue(data.getRow().get(k).getC().get(i));
                    if(text.isEmpty()){
                        al.setUrl("");
                    }else{
                        al.setUrl(text);
                    }

                    System.out.println(data.getRow().get(k).getC().get(i).getR() + " contains " + text);
                }else {
                    System.out.println("是不是错误呢");
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
