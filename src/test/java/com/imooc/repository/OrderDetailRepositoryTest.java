package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: Lixh
 * @Date: 2018/4/3 16:45
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("00001");
        orderDetail.setProductName("皮蛋");
        orderDetail.setProductQuantity(1);
        orderDetail.setProductPrice(new BigDecimal(2.3));

        repository.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
        System.out.println(repository.findByOrderId("123456"));
    }
}