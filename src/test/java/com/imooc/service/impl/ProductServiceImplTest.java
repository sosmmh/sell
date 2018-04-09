package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: Lixh
 * @Date: 2018/4/2 17:48
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    private final String PRODUCTID = "00000";

    @Test
    public void findOne() {
        System.out.println(productService.findOne("123456"));
    }

    @Test
    public void findUpAll() {
        System.out.println(productService.findUpAll());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        System.out.println(productInfoPage.getContent());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("00000");
        productInfo.setCategoryType(1);
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setProductPrice(new BigDecimal(6.2));
        productInfo.setProductName("香蕉");
        productInfo.setProductIcon("http://123.jpg");
        productInfo.setProductDescription("好吃");
        productService.save(productInfo);
    }

    @Test
    public void onSale(){
        ProductInfo result = productService.onSale(PRODUCTID);

        Assert.assertEquals(ProductStatusEnum.UP.getCode(), result.getProductStatus());
    }

    @Test
    public void offSale(){
        ProductInfo result = productService.offSale(PRODUCTID);

        Assert.assertEquals(ProductStatusEnum.DOWN.getCode(), result.getProductStatus());
    }
}