package com.netease.cowork.ynote.script.utils;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.netease.cowork.ynote.script.excel.ExcelReader;
import com.netease.cowork.ynote.script.excel.ExcelWriter;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用POI读取 poi(5.0.0),poi-ooxml(5.0.0),poi-ooxml-schemas(4.1.2),xmlbeans(5.0.1)
 * 参考：https://poi.apache.org/components/spreadsheet/quick-guide.html
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-20 11:43 上午
 */
@Slf4j
public class ExcelProcessor {
    private ExcelReader reader;
    private ExcelWriter writer;

    public ExcelProcessor(String filepath) throws IOException {
        reader = new ExcelReader(filepath);
        writer = new ExcelWriter(filepath);
    }

    /**
     * 读取Excel表格某一sheet的表头】
     * @return String 表头内容的数组
     */
    public String[] readExcelTitle(int sheetIndex) throws Exception {
        return reader.readExcelTitle(sheetIndex);
    }

    /**
     * 读取excel，并按行处理
     * @return Map 包含单元格数据内容的Map对象
     */
    public void readExcelAndDoSomething(int sheetIndex, Consumer<List<Object>> consumer) throws Exception {
        reader.readExcelAndDoSomething(sheetIndex, consumer);
    }

    public static void main(String[] args) {
        try {
            String filepath = ExcelProcessor.class.getClassLoader().getResource("excel/student.xls").getPath();
            ExcelProcessor excelReader = new ExcelProcessor(filepath);

            String[] title = excelReader.readExcelTitle(0);
            Stream.of(title).forEach(System.out::print);

            excelReader.readExcelAndDoSomething(0, System.out::println);
        } catch (Exception e) {
            log.error("执行异常!", e);
        }
    }
}

