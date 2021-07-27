package com.netease.cowork.ynote.script.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;

/**
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-27 10:31 上午
 */

public class ReadXLSDemo {

    public static void main(String args[]) throws IOException {
        URL url = ReadXLSDemo.class.getClassLoader().getResource("excel/student.xls");
        //读取文件流
        FileInputStream fis = new FileInputStream(url.getFile());
        //使用文件流创建一个HSS的模型
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        DataFormatter formatter = new DataFormatter();
        //获取第一个sheet
        HSSFSheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");
                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = formatter.formatCellValue(cell);
                System.out.println(text);
                // Alternatively, get the value and format it yourself
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.println(cell.getDateCellValue());
                        } else {
                            System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        System.out.println(cell.getCellFormula());
                        break;
                    case BLANK:
                    default:
                        System.out.println();
                        break;
                }
            }
        }
        // 创建1行
        Row row = sheet.createRow(5);
        // Aqua background
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        Cell cell = row.createCell(1);
        cell.setCellValue("X");
        cell.setCellStyle(style);

        try (OutputStream fileOut = new FileOutputStream("student1.xls")) {
            wb.write(fileOut);
        }
        wb.close();
    }
}