package com.netease.cowork.ynote.script.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-27 2:21 下午
 */
public class ExcelWriter {
    private Workbook wb;

    public ExcelWriter(String filePath) throws IOException {
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
}
