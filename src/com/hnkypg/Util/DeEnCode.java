package com.hnkypg.Util;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * Created by python on 2018-3-21.
 */
public class DeEnCode {

//    private static final String key0 = "hennankaiyujlkjaoiew23423423dfanpinggu";
//    private static final String key1 = "hennankaiyujlkjaoiedfanpinggu";
//    private static final String key2 = "hennankaiyujl";
//    private static final Charset charset = Charset.forName("UTF-8");
//    private static byte[] keyBytes = key0.getBytes(charset);
//    private static byte[] keyBytes1 = key1.getBytes(charset);
//    private static byte[] keyBytes2 = key2.getBytes(charset);


    public  String getRandomString(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }


    public  String encode(String enc){
        String key ="ADDSFIEeeadf023423982334dsf242";
        Charset charset = Charset.forName("UTF-8");
        byte[] keyBytes = key.getBytes(charset);
        byte[] b = enc.getBytes(charset);
        for(int i=0,size=b.length;i<size;i++){
            for(byte keyBytes0:keyBytes){
                b[i] = (byte) (b[i]^keyBytes0);
            }
        }
        return new String(b);
    }


    public  String decode(String dec){
        String key ="ADDSFIEeeadf023423982334dsf242";
        Charset charset = Charset.forName("UTF-8");
        byte[] keyBytes = key.getBytes(charset);

        byte[] e = dec.getBytes(charset);
        byte[] dee = e;
        for(int i=0,size=e.length;i<size;i++){
            for(byte keyBytes0:keyBytes){
                e[i] = (byte) (dee[i]^keyBytes0);
            }
        }
        return new String(e);
    }


}
