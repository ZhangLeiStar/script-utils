package com.netease.cowork.ynote.script.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-20 4:27 下午
 */
@Slf4j
public class ReadTxtUtils {
    /**
     * 读取Txt文件内容并处理
     * @param consumer 处理方法
     */
    public static void readTxtAndDoSomeThing(String path, Consumer<String> consumer) {
        try {
            // 读取Txt文件
            File filename = new File(path);
            // 读取文件流
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line;
            int count = 0;
            // 按行读取Txt文本
            while((line = br.readLine()) != null) {
                consumer.accept(line);
                count++;
            }
            log.info("txt文件处理成功，共处理：" + count + "行");
        } catch (IOException e) {
            log.error("处理文件失败，原因是：{}", e.getMessage(), e);
        }
    }
}
