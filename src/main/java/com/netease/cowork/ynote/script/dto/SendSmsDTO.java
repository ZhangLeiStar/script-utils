package com.netease.cowork.ynote.script.dto;

import com.netease.cowork.ynote.script.enums.SendMessageEnvEnum;
import lombok.Builder;
import lombok.Getter;

/**
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-20 12:09 下午
 */
@Builder
@Getter
public class SendSmsDTO {
    // 产品名
    private String productName;
    // 产品token
    private String apiToken;
    // 短信收件人
    private String receiverPhoneNum;
    // 短信内容
    private String smsContent;
    // 环境
    private SendMessageEnvEnum sendEmailEnv;
}
