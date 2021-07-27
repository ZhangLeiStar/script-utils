package com.netease.cowork.ynote.script.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

import com.netease.cowork.sendplatform.sdk.SendManager;
import com.netease.cowork.sendplatform.sdk.vo.RequestParams;
import com.netease.cowork.ynote.script.dto.SendSmsDTO;
import com.netease.cowork.ynote.script.enums.SendMessageEnvEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 发送短信工具脚本
 * @author zhanglei19@corp.netease.com
 * @date 2021-07-20 11:39 上午
 */
@Slf4j
public class SendSMSUtils {
    /**
     * 发送短信
     */
    public static void sendSms(SendSmsDTO sendSmsDTO) {
        RequestParams requestParams = new RequestParams();
        requestParams.setProductName(sendSmsDTO.getProductName());
        requestParams.setApiToken(sendSmsDTO.getApiToken());
        requestParams.setReceiverPhoneNum(sendSmsDTO.getReceiverPhoneNum());
        requestParams.setMsgContent(sendSmsDTO.getSmsContent());
        // 设置环境
        if ("test".equals(sendSmsDTO.getSendEmailEnv().getEnv())) {
            requestParams.setEnv(false);
        }
        SendManager.getDefault().sendSmsMsg(requestParams);
    }
}
