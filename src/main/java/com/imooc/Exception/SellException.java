package com.imooc.Exception;

import com.imooc.enums.ResultEnum;

/**
 * @Auther: Lixh
 * @Date: 2018/4/4 14:51
 * @Description:
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);

        this.code = code;
    }
}
