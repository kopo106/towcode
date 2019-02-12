package com.hnkypg.Util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class CreateQRCode3 {
    public static void main(String[] args) throws Exception{
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
        qrcode.setQrcodeVersion(7);//版本

        EncrypDES3 decn = new EncrypDES3();
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String key = "HKF2017001086adewe";
        byte[] encontent = decn.Encrytor(key);
        //生成二维码中要存储的信息
        String qrData = "http://qrcode.baiandma.top:6007/towcode/yanzheng.do?key="+ new String(encontent);
        System.out.println(qrData+"++++++++++++++++++++");
        //设置一下二维码的像素
        int width = 300;
        int height = 300;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘图
        Graphics2D gs = bufferedImage.createGraphics();
        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);//清除下画板内容

        //设置下偏移量,如果不加偏移量，有时会导致出错。
        int pixoff = 2;

        byte[] d = qrData.getBytes("gb2312");
        if(d.length > 0 && d.length <120){
            boolean[][] s = qrcode.calQrcode(d);
            for(int i=0;i<s.length;i++){
                for(int j=0;j<s.length;j++){
                    if(s[j][i]){
                        gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
                    }
                }
            }
        }
        gs.dispose();
        bufferedImage.flush();
        ImageIO.write(bufferedImage, "png", new File("E:/qrcode.png"));
    }
}