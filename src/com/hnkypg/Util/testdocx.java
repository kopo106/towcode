package com.hnkypg.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.wml.CTBorder;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.STBorder;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblBorders;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Tr;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.SpreadsheetMLPackage;
import org.docx4j.openpackaging.parts.SpreadsheetML.WorkbookPart;
import org.docx4j.openpackaging.parts.SpreadsheetML.WorksheetPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xlsx4j.org.apache.poi.ss.usermodel.DataFormatter;
import org.xlsx4j.sml.Cell;
import org.xlsx4j.sml.Row;
import org.xlsx4j.sml.SheetData;
import org.xlsx4j.sml.Worksheet;
/**
 * Created by python on 2018-3-20.
 */
public class testdocx {
    private static WordprocessingMLPackage  wordMLPackage;
    private static ObjectFactory factory;

    /**
     *  首先我们创建包和对象工厂, 因此在类的随处我们都可以使用它们. 然后我们创建一个表格并添加
     *  边框. 接下来我们创建一个表格行并在第一个域添加一些文本.
     *  对于第二个域, 我们用与前面一样的图片创建一个段落并添加进去. 最后把行添加到表格中, 并将
     *  表格添加到包中, 然后保存这个包.
     */
    public static void main (String[] args) throws Exception {
        //创建工厂来创建一个WORD文件
        wordMLPackage = WordprocessingMLPackage.createPackage();
        factory = Context.getWmlObjectFactory();

        //给表格1添加边框
        Tbl table = factory.createTbl();
//        addBorders(table);
        //给表格1添加第一行内容
        Tr tr = factory.createTr();

        P paragraphOfText = wordMLPackage.getMainDocumentPart().createParagraphOfText("真的吗？");
        addTableCell(tr, paragraphOfText);

        P paragraphOfText1 = wordMLPackage.getMainDocumentPart().createParagraphOfText("真的吗？");
        addTableCell(tr, paragraphOfText1);
        //把行写进表格1中，每一行处理一次，然后换行
        table.getContent().add(tr);

        //给表格1第二行添加图片
        Tr tr1 = factory.createTr();
        File file = new File("f://image.jpg");
        File file1 = new File("f://image.jpg");
        P paragraphWithImage = addInlineImageToParagraph(createInlineImage(file));
        addTableCell(tr1, paragraphWithImage);

        P paragraphWithImage1 = addInlineImageToParagraph(createInlineImage(file1));
        addTableCell(tr1, paragraphWithImage1);
        //把行写进表格1中，每一行处理一次，然后换行
        table.getContent().add(tr1);
        //把表格1添加到文档中
        wordMLPackage.getMainDocumentPart().addObject(table);





//        wordMLPackage.getMainDocumentPart().addObject(table1);
        //保存word文件
        wordMLPackage.save(new java.io.File("f://HelloWord8.docx"));
    }

    /**
     * 用给定的段落作为内容向给定的行中添加一个单元格.
     *
     * @param tr
     * @param paragraph
     */
    private static void addTableCell(Tr tr, P paragraph) {
        Tc tc1 = factory.createTc();
        tc1.getContent().add(paragraph);
        tr.getContent().add(tc1);
    }

    /**
     *  向新的段落中添加内联图片并返回这个段落.
     *  这个方法与前面例子中的方法没有区别.
     *
     * @param inline
     * @return
     */
    private static P addInlineImageToParagraph(Inline inline) {
        // Now add the in-line image to a paragraph
        ObjectFactory factory = new ObjectFactory();
        P paragraph = factory.createP();
        R run = factory.createR();
        paragraph.getContent().add(run);
        Drawing drawing = factory.createDrawing();
        run.getContent().add(drawing);
        drawing.getAnchorOrInline().add(inline);
        return paragraph;
    }

    /**
     * 使用给定的文件创建一个内联图片.
     * 跟前面例子中一样, 我们将文件转换成字节数组, 并用它创建一个内联图片.
     *
     * @param file
     * @return
     * @throws Exception
     */
    private static Inline createInlineImage(File file) throws Exception {
        byte[] bytes = convertImageToByteArray(file);

        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);

        int docPrId = 1;
        int cNvPrId = 2;

        return imagePart.createImageInline("Filename hint", "Alternative text", docPrId, cNvPrId, false);
    }

    /**
     * 将图片从文件转换成字节数组.
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static byte[] convertImageToByteArray(File file) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(file );
        long length = file.length();
        // You cannot create an array using a long, it needs to be an int.
        if (length > Integer.MAX_VALUE) {
            System.out.println("File too large!!");
        }
        byte[] bytes = new byte[(int)length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read
        if (offset < bytes.length) {
            System.out.println("Could not completely read file "+file.getName());
        }
        is.close();
        return bytes;
    }

    /**
     * 给表格添加简单的黑色边框.
     *
     * @param table
     */
    private static void addBorders(Tbl table) {
        table.setTblPr(new TblPr());
        CTBorder border = new CTBorder();
        border.setColor("auto");
        border.setSz(new BigInteger("4"));
        border.setSpace(new BigInteger("0"));
        border.setVal(STBorder.SINGLE);

        TblBorders borders = new TblBorders();
        borders.setBottom(border);
        borders.setLeft(border);
        borders.setRight(border);
        borders.setTop(border);
        borders.setInsideH(border);
        borders.setInsideV(border);
        table.getTblPr().setTblBorders(borders);
    }

    //读取表格后设置表格数据值

    private static void displayContent(WorksheetPart sheet, DataFormatter formatter) throws Docx4JException {

        Worksheet ws = sheet.getContents();
        SheetData data = ws.getSheetData();
        System.out.println(data.getRow().size());

        for (Row r : data.getRow() ) {
            System.out.println("row " + r.getR() );

            for (Cell c : r.getC() ) {

//	            CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//	            System.out.print(cellRef.formatAsString());
//	            System.out.print(" - ");

                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = formatter.formatCellValue(c);
                System.out.println(c.getR() + " contains " + text);

            }
        }
    }

    public static List setlistvalue(WorksheetPart sheet, DataFormatter formatter) throws Docx4JException {
        List list = new ArrayList();
        Worksheet ws = sheet.getContents();
        SheetData data = ws.getSheetData();
        System.out.println(data.getRow().size());
        for (Row r : data.getRow() ) {
            String[] value = new String[r.getC().size()];
            System.out.println("row " + r.getR() );
//			System.out.println(key );
            for (int i =0;i<r.getC().size();i++) {
                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = formatter.formatCellValue(r.getC().get(i));
                System.out.println(r.getC().get(i).getR() + " contains " + text);
                value[i] = text;
            }
            list.add(value);
        }
        return list;

    }

}
