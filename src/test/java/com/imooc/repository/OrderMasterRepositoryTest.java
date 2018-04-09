package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther: Lixh
 * @Date: 2018/4/3 16:22
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345676");
        orderMaster.setBuyerPhone("1342523223");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerName("唐建");
        orderMaster.setBuyerAddress("登高邨");
        orderMaster.setOrderAmount(new BigDecimal(3.2));
        repository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 2);
        repository.findByBuyerOpenid(OPENID, pageRequest);
    }

}