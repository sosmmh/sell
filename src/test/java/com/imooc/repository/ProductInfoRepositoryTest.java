package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther: Lixh
 * @Date: 2018/4/2 17:24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("000045");
        productInfo.setProductDescription("好吃");
        productInfo.setProductIcon("http://123.jpg");
        productInfo.setProductName("皮蛋");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        productInfo.setProductStock(100);
        repository.save(productInfo);
    }

    @Test
    public void findOneTest() {
        System.out.println(repository.findOne("123456"));
    }

    @Test
    public void findByProductStatus() {
        System.out.println(repository.findByProductStatus(0));
    }
}