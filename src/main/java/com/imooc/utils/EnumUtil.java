package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * @Auther: Lixh
 * @Date: 2018/4/8 17:20
 * @Description:
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
