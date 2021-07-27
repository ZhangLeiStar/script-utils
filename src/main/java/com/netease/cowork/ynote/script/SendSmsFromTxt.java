package com.netease.cowork.ynote.script;

import com.netease.cowork.ynote.script.dto.SendSmsDTO;
import com.netease.cowork.ynote.script.enums.SendMessageEnvEnum;
import com.netease.cowork.ynote.script.utils.ReadTxtUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 从txt文件读取信息并发送短信
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-27 10:05 上午
 */
@Slf4j
public class SendSmsFromTxt {
    public static void main(String[] args) {
        try {
            String path = "/Users/zhanglei19corp.netease.com/Desktop/sendMessage3.txt";
            ReadTxtUtils.readTxtAndDoSomeThing(path, SendSmsFromTxt::sendMessage);
        } catch (Exception e) {
            log.error("处理失败：{}", e.getMessage(), e);
        }
    }

    /**
     * 根据字符串发送短信
     * @param line txt一行数据
     */
    private static void sendMessage(String line) {
        String[] infos = line.split("\t");
        if (infos.length < 2) {
            log.error("格式有问题：" + line);
            return;
        }

        String SMS_HIGH_QUALITY_GOODS3_SELECT_1 = "【网易】您在有道云笔记618活动中领取的周边礼品已发货（邮政速递），快递单号：" + infos[1].trim() + "，感谢您的支持！";
        SendSmsDTO sendSmsDto = SendSmsDTO.builder()
                .productName("2021618")
                .apiToken("Ljb17ddvYNorzydov0+KCg==")
                .receiverPhoneNum(infos[0].trim())
                .sendEmailEnv(SendMessageEnvEnum.PROD)
                .smsContent(SMS_HIGH_QUALITY_GOODS3_SELECT_1)
                .build();
        try {
//            SendSMSUtils.sendSms(sendSmsDto);
            log.info("发送成功：" + line);
        } catch (Exception e) {
            log.error("发送失败：{}", line, e);
        }
    }
}
