package com.netease.cowork.ynote.script.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanglei19@corp.netease.com
 * @date 2021-05-19 12:21 下午
 */
@Getter
@AllArgsConstructor
public enum SendMessageEnvEnum {
    TEST("test", "测试环境"),
    PROD("prod", "线上环境");


    private final String env;
    private final String description;

    /**
     * 根据名字查到枚举，未找到是返回null
     * @param env 枚举名
     * @return 查找到的枚举
     */
    public static SendMessageEnvEnum findByEnv(String env) {
        return Arrays.stream(SendMessageEnvEnum.values())
                .filter(serverTypeEnum -> serverTypeEnum.getEnv().equals(env))
                .findAny().orElse(null);
    }
}

