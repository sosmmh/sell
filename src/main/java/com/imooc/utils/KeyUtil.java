package com.imooc.utils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Random;

/**
 * @Auther: Lixh
 * @Date: 2018/4/8 09:33
 * @Description:
 */
public class KeyUtil {

    /** 生成唯一主键 */
    public static String getUniqueKey() {

        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);

    }
}
