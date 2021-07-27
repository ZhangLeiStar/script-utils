package com.netease.cowork.ynote.script;

import com.netease.cowork.ynote.script.dto.SendSmsDTO;
import com.netease.cowork.ynote.script.enums.SendMessageEnvEnum;
import com.netease.cowork.ynote.script.utils.ReadTxtUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 从Txt文件中读取相应信息发送短信或邮件脚本
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-20 11:38 上午
 */
@Slf4j
public class MessageSendTest {
    @Test
    public void testSendMessage() {
        try {
            String path = "/Users/zhanglei19corp.netease.com/Desktop/sendMessage3.txt";
            ReadTxtUtils.readTxtAndDoSomeThing(path, MessageSendTest::sendMessage);
        } catch (Exception e) {
            log.error("处理失败：{}", e.getMessage(), e);
        }
    }

    /**
     * 发送短信
     * @param line
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
