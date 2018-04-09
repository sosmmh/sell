package com.imooc.enums;

import lombok.Getter;

/**
 * @Auther: Lixh
 * @Date: 2018/4/3 15:55
 * @Description:
 */
@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
