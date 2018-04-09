package com.imooc.dto;

import lombok.Data;

/**
 * @Auther: Lixh
 * @Date: 2018/4/8 09:43
 * @Description:
 */
@Data
public class CartDTO {

    /** 商品ID */
    private String productId;

    /** 数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
