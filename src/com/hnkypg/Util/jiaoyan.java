package com.hnkypg.Util;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by python on 2017-6-19.
 */
public class jiaoyan {

    public String  inputpd(HttpServletRequest request){
        String input_error = null;
        String input_success = "success";
        String[] bdwct = null;
        String i = request.getParameter("bdwct");
        if(i.length()<1){
            input_error="请添加标的物";
            return input_error;
        }

        if(request.getParameter("bumen").length()<1){
            input_error = "部门不能不选择";
            return input_error;
        }
        if(request.getParameter("bgnum").length()<1){
            input_error = "报告编号不能为空";
            return input_error;
        }
        if(request.getParameter("baogaotype").length()<1){
            input_error ="报告类型不能为空";
            return input_error;
        }
        if(request.getParameter("laiyuan").length()<1){
            input_error ="来源不能为空";
            return input_error;
        }
        if(request.getParameter("shidian").length()<1){
            input_error ="价值时点不能为空";
            return input_error;
        }
        if(request.getParameter("chujudate").length()<1){
            input_error ="出具日期不能为空";
            return input_error;
        }
        if(Date.valueOf(request.getParameter("chujudate")).getTime()<Date.valueOf(request.getParameter("shidian")).getTime()){
            input_error ="价值时点不能大于出具时间，请重新选择！";
            return input_error;
        }
        if(request.getParameter("baogaotype").equals("预评报告")){
            if(request.getParameter("zhuanxie").length()<1&&request.getParameter("jszhuanxie").length()<1){
                input_error ="撰写人员和技术撰写人员不能都为空";
                return input_error;
            }else if(request.getParameter("zhuanxie").length()>0 && request.getParameter("jszhuanxie").length()>0){
                input_error ="撰写人员和技术撰写人员只能存在一个";
                return input_error;
            }

            if(request.getParameter("shenhe").length()<1){
                input_error ="审核人员不能为空";
                return input_error;
            }
            if(request.getParameter("kancha").length()<1 && request.getParameter("shidikc").length()<1){
                input_error ="照片勘察人员和实地勘察人员不能都为空";
                return input_error;
            }else if(request.getParameter("kancha").length()>0 && request.getParameter("shidikc").length()>0){
                input_error ="照片勘察人员和实地勘察人员只能存在一个";
                return input_error;
            }

            if(request.getParameter("jiazhigoutong").length()<1){
                input_error ="价值沟通人员不能为空";
                return input_error;
            }
            if(request.getParameter("dingjia").length()<1){
                input_error ="定价人员不能为空";
                return input_error;
            }
        }else if(request.getParameter("baogaotype").equals("正式报告")){
            if(request.getParameter("zhuanxie").length()<1&&request.getParameter("jszhuanxie").length()<1){
                input_error ="撰写人员和技术撰写人员不能都为空";
                return input_error;
            }else if(request.getParameter("zhuanxie").length()>0 && request.getParameter("jszhuanxie").length()>0){
                input_error ="撰写人员和技术撰写人员只能存在一个";
                return input_error;
            }

            if(request.getParameter("kancha").length()<1 && request.getParameter("shidikc").length()<1){
                input_error ="照片勘察人员和实地勘察人员不能都为空";
                return input_error;
            }else if(request.getParameter("kancha").length()>0 && request.getParameter("shidikc").length()>0){
                input_error ="照片勘察人员和实地勘察人员只能存在一个";
                return input_error;
            }
            if(request.getParameter("shenhe").length()<1){
                input_error = "审核人员不能为空";
                return input_error;
            }
            if(request.getParameter("gujiashi").length()<1){
                input_error = "正式报告：必须有估价师";
                return input_error;
            }

            if(request.getParameter("jiazhigoutong").length()<1){
                input_error ="价值沟通人员不能为空";
                return input_error;
            }
            if(request.getParameter("dingjia").length()<1){
                input_error ="定价人员不能为空";
                return input_error;
            }
        }else if(request.getParameter("baogaotype").equals("分公司报告审核")){
            if(request.getParameter("shenhe").length()<1){
                input_error ="分公司报告审核人员不能为空";
                return input_error;
            }
        }


        if((i.indexOf(",")!=-1)){
            bdwct = i.split(",");
            for(int j = 0; j < bdwct.length;j++){
                if(request.getParameter("chanquanren"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的产权人不能为空";
                    return input_error;
                }
                if(request.getParameter("zuoluo"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的坐落不能为空";
                    return input_error;
                }
                if(request.getParameter("mianji"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的面积不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("mianji"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的面积不能为0";
                    return input_error;
                }
                if(request.getParameter("danjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的单价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("danjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的单价不能为0";
                    return input_error;
                }
                if(request.getParameter("zongjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的总价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
                float zongJ =Float.parseFloat(request.getParameter("danjia"+bdwct[j]))*Float.parseFloat(request.getParameter("mianji"+bdwct[j]))/10000;
                float num = 0;
                if(request.getParameter("point"+bdwct[j]).equals("保留二位")){
                    num = (float)(Math.round(zongJ*100))/100;
                }else if(request.getParameter("point"+bdwct[j]).equals("保留一位")){
                    num = (float)(Math.round(zongJ*10))/10;
                }else {
                    num = (float)(Math.round(zongJ*1))/1;
                }

                if(num != Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))){
                    input_error = "第"+(j+1)+"个标的物的总价不等于面积乘以单价，请重新确认下";
                    return input_error;
                }
                if (num==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
            }
        }else{
            if(request.getParameter("chanquanren"+i).length()<1){
                input_error = "标的物的产权人不能为空";
                return input_error;
            }
            if(request.getParameter("zuoluo"+i).length()<1){
                input_error = "标的物的坐落不能为空";
                return input_error;
            }
            if(request.getParameter("mianji"+i).length()<1){
                input_error = "标的物的面积不能为空";
                return input_error;
            }
            if(request.getParameter("danjia"+i).length()<1){
                input_error = "标的物的单价不能为空";
                return input_error;
            }
            if(request.getParameter("zongjia"+i).length()<1){
                input_error = "标的物的总价不能为空";
                return input_error;
            }
            float zongJ =Float.parseFloat(request.getParameter("danjia"+i))*Float.parseFloat(request.getParameter("mianji"+i))/10000;
            float num = 0;
            if(request.getParameter("point"+i).equals("保留二位")){
                num = (float)(Math.round(zongJ*100))/100;
            }else if(request.getParameter("point"+i).equals("保留一位")){
                num = (float)(Math.round(zongJ*10))/10;
            }else {
                num = (float)(Math.round(zongJ*1))/1;
            }

            if(num != Float.parseFloat(request.getParameter("zongjia"+i))){
                input_error = "标的物的总价不等于面积乘以单价，请重新确认下";
                return input_error;
            }

            if (num==0){
                input_error = "标的物的总价不能为0";
                return input_error;
            }
        }
        return input_success;


    }

    public String  travejy(HttpServletRequest request){
        String input_error = null;
        String input_success = "success";
        String[] bdwct = null;
        String i = request.getParameter("bdwct");
        if(i.length()<1){
            input_error="请添加标的物";
            return input_error;
        }

        if(request.getParameter("bumen").length()<1){
            input_error = "部门不能不选择";
            return input_error;
        }
        if(request.getParameter("bgnum").length()<1){
            input_error = "报告编号不能为空";
            return input_error;
        }
        if(request.getParameter("baogaotype").length()<1){
            input_error ="报告类型不能为空";
            return input_error;
        }
        if(request.getParameter("laiyuan").length()<1){
            input_error ="来源不能为空";
            return input_error;
        }
        if(request.getParameter("shidian").length()<1){
            input_error ="价值时点不能为空";
            return input_error;
        }
        if(request.getParameter("chujudate").length()<1){
            input_error ="出具日期不能为空";
            return input_error;
        }
        if(Date.valueOf(request.getParameter("chujudate")).getTime()<Date.valueOf(request.getParameter("shidian")).getTime()){
            input_error ="价值时点不能大于出具时间，请重新选择！";
            return input_error;
        }
        if(request.getParameter("baogaotype").equals("预评报告")){
            input_error ="预评转正评报告，请选择正式报告报告类型！";
            return input_error;
        }else if(request.getParameter("baogaotype").equals("正式报告")){
            if(request.getParameter("zhuanxie").length()<1&&request.getParameter("jszhuanxie").length()<1){
                input_error ="撰写人员和技术撰写人员不能都为空";
                return input_error;
            }else if(request.getParameter("zhuanxie").length()>0 && request.getParameter("jszhuanxie").length()>0){
                input_error ="撰写人员和技术撰写人员只能存在一个";
                return input_error;
            }

            if(request.getParameter("shidikc").length()>0){
                input_error ="正式报告 实地勘察人员不能重复统计";
                return input_error;
            }
            if(request.getParameter("kancha").length()>0 ){
                input_error ="正式报告 照片勘察人员不能重复统计";
                return input_error;
            }
            if(request.getParameter("shenhe").length()>0){
                input_error = "正式报告不要审核人员";
                return input_error;
            }
            if(request.getParameter("gujiashi").length()<1){
                input_error = "正式报告：必须有估价师";
                return input_error;
            }

            if(request.getParameter("jiazhigoutong").length()>0){
                input_error ="价值沟通人员不能为空";
                return input_error;
            }
            if(request.getParameter("dingjia").length()>0){
                input_error ="定价人员不能为空";
                return input_error;
            }
        }else if(request.getParameter("baogaotype").equals("分公司报告审核")){
            input_error ="预评转正评报告，请选择正式报告报告类型！";
            return input_error;
        }


        if((i.indexOf(",")!=-1)){
            bdwct = i.split(",");
            for(int j = 0; j < bdwct.length;j++){
                if(request.getParameter("chanquanren"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的产权人不能为空";
                    return input_error;
                }
                if(request.getParameter("zuoluo"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的坐落不能为空";
                    return input_error;
                }
                if(request.getParameter("mianji"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的面积不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("mianji"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的面积不能为0";
                    return input_error;
                }
                if(request.getParameter("danjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的单价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("danjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的单价不能为0";
                    return input_error;
                }
                if(request.getParameter("zongjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的总价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
                float zongJ =Float.parseFloat(request.getParameter("danjia"+bdwct[j]))*Float.parseFloat(request.getParameter("mianji"+bdwct[j]))/10000;
                float num = 0;
                if(request.getParameter("point"+bdwct[j]).equals("保留二位")){
                    num = (float)(Math.round(zongJ*100))/100;
                }else if(request.getParameter("point"+bdwct[j]).equals("保留一位")){
                    num = (float)(Math.round(zongJ*10))/10;
                }else {
                    num = (float)(Math.round(zongJ*1))/1;
                }

                if(num != Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))){
                    input_error = "第"+(j+1)+"个标的物的总价不等于面积乘以单价，请重新确认下";
                    return input_error;
                }
                if (num==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
            }
        }else{
            if(request.getParameter("chanquanren"+i).length()<1){
                input_error = "标的物的产权人不能为空";
                return input_error;
            }
            if(request.getParameter("zuoluo"+i).length()<1){
                input_error = "标的物的坐落不能为空";
                return input_error;
            }
            if(request.getParameter("mianji"+i).length()<1){
                input_error = "标的物的面积不能为空";
                return input_error;
            }
            if(request.getParameter("danjia"+i).length()<1){
                input_error = "标的物的单价不能为空";
                return input_error;
            }
            if(request.getParameter("zongjia"+i).length()<1){
                input_error = "标的物的总价不能为空";
                return input_error;
            }
            float zongJ =Float.parseFloat(request.getParameter("danjia"+i))*Float.parseFloat(request.getParameter("mianji"+i))/10000;
            float num = 0;
            if(request.getParameter("point"+i).equals("保留二位")){
                num = (float)(Math.round(zongJ*100))/100;
            }else if(request.getParameter("point"+i).equals("保留一位")){
                num = (float)(Math.round(zongJ*10))/10;
            }else {
                num = (float)(Math.round(zongJ*1))/1;
            }

            if(num != Float.parseFloat(request.getParameter("zongjia"+i))){
                input_error = "标的物的总价不等于面积乘以单价，请重新确认下";
                return input_error;
            }

            if (num==0){
                input_error = "标的物的总价不能为0";
                return input_error;
            }
        }
        return input_success;


    }

    public String  fgsinputpd(HttpServletRequest request){
        String input_error = null;
        String input_success = "success";
        String[] bdwct = null;
        String i = request.getParameter("bdwct");
        if(i.length()<1){
            input_error="请添加标的物";
            return input_error;
        }

        if(request.getParameter("bumen").length()<1){
            input_error = "部门不能不选择";
            return input_error;
        }
        if(request.getParameter("bgnum").length()<1){
            input_error = "报告编号不能为空";
            return input_error;
        }
        if(request.getParameter("baogaotype").length()<1){
            input_error ="报告类型不能为空";
            return input_error;
        }
        if(request.getParameter("laiyuan").length()<1){
            input_error ="来源不能为空";
            return input_error;
        }
        if(request.getParameter("shidian").length()<1){
            input_error ="价值时点不能为空";
            return input_error;
        }
        if(request.getParameter("chujudate").length()<1){
            input_error ="出具日期不能为空";
            return input_error;
        }
        if(Date.valueOf(request.getParameter("chujudate")).getTime()<Date.valueOf(request.getParameter("shidian")).getTime()){
            input_error ="价值时点不能大于出具时间，请重新选择！";
            return input_error;
        }


        if((i.indexOf(",")!=-1)){
            bdwct = i.split(",");
            for(int j = 0; j < bdwct.length;j++){
                if(request.getParameter("chanquanren"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的产权人不能为空";
                    return input_error;
                }
                if(request.getParameter("zuoluo"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的坐落不能为空";
                    return input_error;
                }
                if(request.getParameter("mianji"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的面积不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("mianji"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的面积不能为0";
                    return input_error;
                }
                if(request.getParameter("danjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的单价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("danjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的单价不能为0";
                    return input_error;
                }
                if(request.getParameter("zongjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的总价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
                float zongJ =Float.parseFloat(request.getParameter("danjia"+bdwct[j]))*Float.parseFloat(request.getParameter("mianji"+bdwct[j]))/10000;
                float num = 0;
                if(request.getParameter("point"+bdwct[j]).equals("保留二位")){
                    num = (float)(Math.round(zongJ*100))/100;
                }else if(request.getParameter("point"+bdwct[j]).equals("保留一位")){
                    num = (float)(Math.round(zongJ*10))/10;
                }else {
                    num = (float)(Math.round(zongJ*1))/1;
                }

                if(num != Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))){
                    input_error = "第"+(j+1)+"个标的物的总价不等于面积乘以单价，请重新确认下";
                    return input_error;
                }
                if (num==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
            }
        }else{
            if(request.getParameter("chanquanren"+i).length()<1){
                input_error = "标的物的产权人不能为空";
                return input_error;
            }
            if(request.getParameter("zuoluo"+i).length()<1){
                input_error = "标的物的坐落不能为空";
                return input_error;
            }
            if(request.getParameter("mianji"+i).length()<1){
                input_error = "标的物的面积不能为空";
                return input_error;
            }
            if(request.getParameter("danjia"+i).length()<1){
                input_error = "标的物的单价不能为空";
                return input_error;
            }
            if(request.getParameter("zongjia"+i).length()<1){
                input_error = "标的物的总价不能为空";
                return input_error;
            }
            float zongJ =Float.parseFloat(request.getParameter("danjia"+i))*Float.parseFloat(request.getParameter("mianji"+i))/10000;
            float num = 0;
            if(request.getParameter("point"+i).equals("保留二位")){
                num = (float)(Math.round(zongJ*100))/100;
            }else if(request.getParameter("point"+i).equals("保留一位")){
                num = (float)(Math.round(zongJ*10))/10;
            }else {
                num = (float)(Math.round(zongJ*1))/1;
            }

            if(num != Float.parseFloat(request.getParameter("zongjia"+i))){
                input_error = "标的物的总价不等于面积乘以单价，请重新确认下";
                return input_error;
            }

            if (num==0){
                input_error = "标的物的总价不能为0";
                return input_error;
            }
        }
        return input_success;


    }

    public String  fgstravejy(HttpServletRequest request){
        String input_error = null;
        String input_success = "success";
        String[] bdwct = null;
        String i = request.getParameter("bdwct");
        if(i.length()<1){
            input_error="请添加标的物";
            return input_error;
        }

        if(request.getParameter("bumen").length()<1){
            input_error = "部门不能不选择";
            return input_error;
        }
        if(request.getParameter("bgnum").length()<1){
            input_error = "报告编号不能为空";
            return input_error;
        }
        if(request.getParameter("baogaotype").length()<1){
            input_error ="报告类型不能为空";
            return input_error;
        }
        if(request.getParameter("laiyuan").length()<1){
            input_error ="来源不能为空";
            return input_error;
        }
        if(request.getParameter("shidian").length()<1){
            input_error ="价值时点不能为空";
            return input_error;
        }
        if(request.getParameter("chujudate").length()<1){
            input_error ="出具日期不能为空";
            return input_error;
        }
        if(Date.valueOf(request.getParameter("chujudate")).getTime()<Date.valueOf(request.getParameter("shidian")).getTime()){
            input_error ="价值时点不能大于出具时间，请重新选择！";
            return input_error;
        }
        if(request.getParameter("baogaotype").equals("预评报告")){
            input_error ="预评转正评报告，请选择正式报告报告类型！";
            return input_error;
        }else if(request.getParameter("baogaotype").equals("正式报告")){

            if(request.getParameter("gujiashi").length()<1){
                input_error = "正式报告：必须有估价师";
                return input_error;
            }

        }


        if((i.indexOf(",")!=-1)){
            bdwct = i.split(",");
            for(int j = 0; j < bdwct.length;j++){
                if(request.getParameter("chanquanren"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的产权人不能为空";
                    return input_error;
                }
                if(request.getParameter("zuoluo"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的坐落不能为空";
                    return input_error;
                }
                if(request.getParameter("mianji"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的面积不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("mianji"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的面积不能为0";
                    return input_error;
                }
                if(request.getParameter("danjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的单价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("danjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的单价不能为0";
                    return input_error;
                }
                if(request.getParameter("zongjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的总价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
                float zongJ =Float.parseFloat(request.getParameter("danjia"+bdwct[j]))*Float.parseFloat(request.getParameter("mianji"+bdwct[j]))/10000;
                float num = 0;
                if(request.getParameter("point"+bdwct[j]).equals("保留二位")){
                    num = (float)(Math.round(zongJ*100))/100;
                }else if(request.getParameter("point"+bdwct[j]).equals("保留一位")){
                    num = (float)(Math.round(zongJ*10))/10;
                }else {
                    num = (float)(Math.round(zongJ*1))/1;
                }

                if(num != Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))){
                    input_error = "第"+(j+1)+"个标的物的总价不等于面积乘以单价，请重新确认下";
                    return input_error;
                }
                if (num==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
            }
        }else{
            if(request.getParameter("chanquanren"+i).length()<1){
                input_error = "标的物的产权人不能为空";
                return input_error;
            }
            if(request.getParameter("zuoluo"+i).length()<1){
                input_error = "标的物的坐落不能为空";
                return input_error;
            }
            if(request.getParameter("mianji"+i).length()<1){
                input_error = "标的物的面积不能为空";
                return input_error;
            }
            if(request.getParameter("danjia"+i).length()<1){
                input_error = "标的物的单价不能为空";
                return input_error;
            }
            if(request.getParameter("zongjia"+i).length()<1){
                input_error = "标的物的总价不能为空";
                return input_error;
            }
            float zongJ =Float.parseFloat(request.getParameter("danjia"+i))*Float.parseFloat(request.getParameter("mianji"+i))/10000;
            float num = 0;
            if(request.getParameter("point"+i).equals("保留二位")){
                num = (float)(Math.round(zongJ*100))/100;
            }else if(request.getParameter("point"+i).equals("保留一位")){
                num = (float)(Math.round(zongJ*10))/10;
            }else {
                num = (float)(Math.round(zongJ*1))/1;
            }

            if(num != Float.parseFloat(request.getParameter("zongjia"+i))){
                input_error = "标的物的总价不等于面积乘以单价，请重新确认下";
                return input_error;
            }

            if (num==0){
                input_error = "标的物的总价不能为0";
                return input_error;
            }
        }
        return input_success;


    }

    public String  fgsshjy(HttpServletRequest request){
        String input_error = null;
        String input_success = "success";
        String[] bdwct = null;
        String i = request.getParameter("bdwct");
        if(i.length()<1){
            input_error="请添加标的物";
            return input_error;
        }

        if(request.getParameter("bumen").length()<1){
            input_error = "部门不能不选择";
            return input_error;
        }
        if(request.getParameter("bgnum").length()<1){
            input_error = "报告编号不能为空";
            return input_error;
        }
        if(request.getParameter("baogaotype").length()<1){
            input_error ="报告类型不能为空";
            return input_error;
        }
        if(request.getParameter("laiyuan").length()<1){
            input_error ="来源不能为空";
            return input_error;
        }
        if(request.getParameter("shidian").length()<1){
            input_error ="价值时点不能为空";
            return input_error;
        }
        if(request.getParameter("chujudate").length()<1){
            input_error ="出具日期不能为空";
            return input_error;
        }
        if(Date.valueOf(request.getParameter("chujudate")).getTime()<Date.valueOf(request.getParameter("shidian")).getTime()){
            input_error ="价值时点不能大于出具时间，请重新选择！";
            return input_error;
        }

        if(request.getParameter("bumen").equals("新乡市")){
            if(request.getParameter("baogaotype").equals("预评报告")){

                if(request.getParameter("shenhe").length()<1){
                    input_error = "审核人员不能为空";
                    return input_error;
            }else{
                    if(request.getParameter("shenhe").length()<1){
                        input_error = "审核人员不能为空";
                        return input_error;
                    }

                    if(request.getParameter("gujiashi").length()<1){
                        input_error = "估价师不能为空";
                        return input_error;
                    }
                }
            }

        }else{
            if(request.getParameter("baogaotype").equals("预评报告")){

                if(request.getParameter("shenhe").length()<1){
                    input_error ="审核人员不能为空";
                    return input_error;
                }
                if(request.getParameter("kancha").length()<1 && request.getParameter("shidikc").length()<1){
                    input_error ="照片勘察人员和实地勘察人员不能都为空";
                    return input_error;
                }else if(request.getParameter("kancha").length()>0 && request.getParameter("shidikc").length()>0){
                    input_error ="照片勘察人员和实地勘察人员只能存在一个";
                    return input_error;
                }

                if(request.getParameter("jiazhigoutong").length()<1){
                    input_error ="价值沟通人员不能为空";
                    return input_error;
                }
                if(request.getParameter("dingjia").length()<1){
                    input_error ="定价人员不能为空";
                    return input_error;
                }
            }else if(request.getParameter("baogaotype").equals("正式报告")){


                if(request.getParameter("kancha").length()<1 && request.getParameter("shidikc").length()<1){
                    input_error ="照片勘察人员和实地勘察人员不能都为空";
                    return input_error;
                }else if(request.getParameter("kancha").length()>0 && request.getParameter("shidikc").length()>0){
                    input_error ="照片勘察人员和实地勘察人员只能存在一个";
                    return input_error;
                }
                if(request.getParameter("shenhe").length()<1){
                    input_error = "审核人员不能为空";
                    return input_error;
                }
                if(request.getParameter("gujiashi").length()<1){
                    input_error = "正式报告：必须有估价师";
                    return input_error;
                }

                if(request.getParameter("jiazhigoutong").length()<1){
                    input_error ="价值沟通人员不能为空";
                    return input_error;
                }
                if(request.getParameter("dingjia").length()<1){
                    input_error ="定价人员不能为空";
                    return input_error;
                }
            }
        }



        if((i.indexOf(",")!=-1)){
            bdwct = i.split(",");
            for(int j = 0; j < bdwct.length;j++){
                if(request.getParameter("chanquanren"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的产权人不能为空";
                    return input_error;
                }
                if(request.getParameter("zuoluo"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的坐落不能为空";
                    return input_error;
                }
                if(request.getParameter("mianji"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的面积不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("mianji"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的面积不能为0";
                    return input_error;
                }
                if(request.getParameter("danjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的单价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("danjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的单价不能为0";
                    return input_error;
                }
                if(request.getParameter("zongjia"+bdwct[j]).length()<1){
                    input_error = "第"+(j+1)+"个标的物的总价不能为空";
                    return input_error;
                }else if(Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
                float zongJ =Float.parseFloat(request.getParameter("danjia"+bdwct[j]))*Float.parseFloat(request.getParameter("mianji"+bdwct[j]))/10000;
                float num = 0;
                if(request.getParameter("point"+bdwct[j]).equals("保留二位")){
                    num = (float)(Math.round(zongJ*100))/100;
                }else if(request.getParameter("point"+bdwct[j]).equals("保留一位")){
                    num = (float)(Math.round(zongJ*10))/10;
                }else {
                    num = (float)(Math.round(zongJ*1))/1;
                }

                if(num != Float.parseFloat(request.getParameter("zongjia"+bdwct[j]))){
                    input_error = "第"+(j+1)+"个标的物的总价不等于面积乘以单价，请重新确认下";
                    return input_error;
                }
                if (num==0){
                    input_error = "第"+(j+1)+"个标的物的总价不能为0";
                    return input_error;
                }
            }
        }else{
            if(request.getParameter("chanquanren"+i).length()<1){
                input_error = "标的物的产权人不能为空";
                return input_error;
            }
            if(request.getParameter("zuoluo"+i).length()<1){
                input_error = "标的物的坐落不能为空";
                return input_error;
            }
            if(request.getParameter("mianji"+i).length()<1){
                input_error = "标的物的面积不能为空";
                return input_error;
            }
            if(request.getParameter("danjia"+i).length()<1){
                input_error = "标的物的单价不能为空";
                return input_error;
            }
            if(request.getParameter("zongjia"+i).length()<1){
                input_error = "标的物的总价不能为空";
                return input_error;
            }
            float zongJ =Float.parseFloat(request.getParameter("danjia"+i))*Float.parseFloat(request.getParameter("mianji"+i))/10000;
            float num = 0;
            if(request.getParameter("point"+i).equals("保留二位")){
                num = (float)(Math.round(zongJ*100))/100;
            }else if(request.getParameter("point"+i).equals("保留一位")){
                num = (float)(Math.round(zongJ*10))/10;
            }else {
                num = (float)(Math.round(zongJ*1))/1;
            }

            if(num != Float.parseFloat(request.getParameter("zongjia"+i))){
                input_error = "标的物的总价不等于面积乘以单价，请重新确认下";
                return input_error;
            }

            if (num==0){
                input_error = "标的物的总价不能为0";
                return input_error;
            }
        }
        return input_success;


    }


    public String  upfilejy(HttpServletRequest request){
        String input_error = null;
        String input_success = "success";

        if(request.getParameter("bumen").length()<1){
            input_error = "部门不能不选择";
            return input_error;
        }


        if(request.getParameter("laiyuan").length()<1){
            input_error ="来源不能为空";
            return input_error;
        }



        if(request.getParameter("zhuanxie").length()<1&&request.getParameter("jszhuanxie").length()<1){
            input_error ="撰写人员和技术撰写人员不能都为空";
            return input_error;
        }else if(request.getParameter("zhuanxie").length()>0 && request.getParameter("jszhuanxie").length()>0){
            input_error ="撰写人员和技术撰写人员只能存在一个";
            return input_error;
        }

        if(request.getParameter("shenhe").length()<1){
            input_error ="审核人员不能为空";
            return input_error;
        }
        if(request.getParameter("kancha").length()<1 && request.getParameter("shidikc").length()<1){
            input_error ="照片勘察人员和实地勘察人员不能都为空";
            return input_error;
        }else if(request.getParameter("kancha").length()>0 && request.getParameter("shidikc").length()>0){
            input_error ="照片勘察人员和实地勘察人员只能存在一个";
            return input_error;
        }

        if(request.getParameter("jiazhigoutong").length()<1){
            input_error ="价值沟通人员不能为空";
            return input_error;
        }
        if(request.getParameter("dingjia").length()<1){
            input_error ="定价人员不能为空";
            return input_error;
        }




        return input_success;


    }


}
