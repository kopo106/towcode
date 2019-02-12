package com.hnkypg.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.docx4j.TraversalUtil;
import org.docx4j.XmlUtils;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.finders.RangeFinder;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.io.SaveToZipFile;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.org.apache.poi.util.IOUtils;
import org.docx4j.wml.Body;
import org.docx4j.wml.CTBookmark;
import org.docx4j.wml.Document;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
public class replace2 {

    public String replace(Map map) throws Exception {
        // 模板文件路径
        String templatePath = map.get("leftpath")+"/"+map.get("filename");
        // 生成的文件路径
        String targetPath = map.get("leftpath")+"/result/"+map.get("filename");
        // 书签名
        String bookmarkName = "tow_code";
        // 图片路径
        String imagePath = (String) map.get("qrpath");

        // The image to add
 		File file = new File(imagePath);

 		System.out.println(templatePath);
 		
 		// Our utility method wants that as a byte array
 		InputStream is = new FileInputStream(file );
         long length = file.length();    
         // You cannot create an array using a long type.
         // It needs to be an int type.
         if (length > Integer.MAX_VALUE) {
         	System.out.println("File too large!!");
         }
         byte[] bytes = new byte[(int)length];
         int offset = 0;
         int numRead = 0;
         while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
             offset += numRead;
         }
         // Ensure all the bytes have been read in
         if (offset < bytes.length) {
             System.out.println("Could not completely read file "+file.getName());
         }
         is.close();

        // 载入模板文件
        WordprocessingMLPackage wPackage = WordprocessingMLPackage.load(new FileInputStream(templatePath));
        // 提取正文
        MainDocumentPart mainDocumentPart = wPackage.getMainDocumentPart();
        @SuppressWarnings("deprecation")
		Document wmlDoc = (Document) mainDocumentPart.getJaxbElement();
        Body body = wmlDoc.getBody();
        // 提取正文中所有段落
        List<Object> paragraphs = body.getContent();
        // 提取书签并创建书签的游标
        RangeFinder rt = new RangeFinder("CTBookmark", "CTMarkupRange");
        new TraversalUtil(paragraphs, rt);

        // 遍历书签
        for (CTBookmark bm:rt.getStarts()) {
            // 这儿可以对单个书签进行操作，也可以用一个map对所有的书签进行处理
            if (bm.getName().equals(bookmarkName)){
                // 读入图片并转化为字节数组，因为docx4j只能字节数组的方式插入图片
            	// Image 1: no width specified
//                org.docx4j.wml.P p = newImage( wPackage, bytes, 
//                		filenameHint, altText, 
//            			id1, id2 );
//                wPackage.getMainDocumentPart().addObject(p);
                // 创建一个行内图片
                BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wPackage, bytes);

                // createImageInline函数的前四个参数我都没有找到具体啥意思，，，，
                // 最有一个是限制图片的宽度，缩放的依据
                Inline inline = imagePart.createImageInline(null, null, 0,1, false, 1600);
                // 获取该书签的父级段落
                P p = (P)(bm.getParent());

                ObjectFactory factory = new ObjectFactory();
                // R对象是匿名的复杂类型，然而我并不知道具体啥意思，估计这个要好好去看看ooxml才知道
                R run = factory.createR();
                // drawing理解为画布？
                Drawing drawing = factory.createDrawing();
                drawing.getAnchorOrInline().add(inline);
                run.getContent().add(drawing);
                p.getContent().add(run);
            }
        }
        wPackage.save(new FileOutputStream(targetPath));

        return "替换成功看看！";
    }   
    
	/**
	 * Create image, without specifying width
	 */
	public static P newImage( WordprocessingMLPackage wordMLPackage,
			byte[] bytes,
			String filenameHint, String altText, 
			int id1, int id2) throws Exception {
		
        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);
		
        Inline inline = imagePart.createImageInline( filenameHint, altText, 
    			id1, id2, false);
        
        // Now add the inline in w:p/w:r/w:drawing
		ObjectFactory factory = Context.getWmlObjectFactory();
		P  p = factory.createP();
		R  run = factory.createR();
		p.getContent().add(run);        
		Drawing drawing = factory.createDrawing();
		run.getContent().add(drawing);		
		drawing.getAnchorOrInline().add(inline);
		
		return p;
		
	}	
	
	/**
	 * Create image, specifying width in twips
	 */
	public static P newImage( WordprocessingMLPackage wordMLPackage,
			byte[] bytes,
			String filenameHint, String altText, 
			int id1, int id2, long cx) throws Exception {
		
        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);
		
        Inline inline = imagePart.createImageInline( filenameHint, altText, 
    			id1, id2, cx, false);
        
        // Now add the inline in w:p/w:r/w:drawing
		ObjectFactory factory = Context.getWmlObjectFactory();
		P  p = factory.createP();
		R  run = factory.createR();
		p.getContent().add(run);        
		Drawing drawing = factory.createDrawing();
		run.getContent().add(drawing);		
		drawing.getAnchorOrInline().add(inline);
		
		return p;
		
	}	

}
