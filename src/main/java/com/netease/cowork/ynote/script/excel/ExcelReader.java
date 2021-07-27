package com.netease.cowork.ynote.script.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel读取器
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-27 2:21 下午
 */
public class ExcelReader {
    private Workbook wb;

    /**
     * 使用文件目录构建Reader
     * @param filePath 文件目录
     * @throws IOException
     */
    public ExcelReader(String filePath) throws IOException {
        if (filePath == null) {
            throw new FileNotFoundException("文件路径为空！");
        }
        String ext = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = new FileInputStream(filePath);
        if (".xls".equals(ext)) {
            wb = new HSSFWorkbook(is);
        } else if (".xlsx".equals(ext)) {
            wb = new XSSFWorkbook(is);
        } else {
            throw new IOException("不支持的文件格式！");
        }
    }

    public String[] readExcelTitle(int sheetIndex) throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = row.getCell(i).getStringCellValue();
        }
        return title;
    }

    public void readExcelAndDoSomething(int sheetIndex, Consumer<List<Object>> consumer) throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        Sheet sheet = wb.getSheetAt(sheetIndex);
        // 循环处理行
        for (Row row : sheet) {
            List<Object> rowValues = new ArrayList<>();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        rowValues.add(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            rowValues.add(cell.getDateCellValue());
                        } else {
                            rowValues.add(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        rowValues.add(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        rowValues.add(cell.getCellFormula());
                        break;
                    case BLANK:
                    default:
                        rowValues.add("");
                        break;
                }
            }
            consumer.accept(rowValues);
        }
    }
}
