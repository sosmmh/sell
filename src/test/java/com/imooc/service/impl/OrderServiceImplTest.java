package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Lixh
 * @Date: 2018/4/8 09:59
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDERID = "1523155323501386713";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("sosmmh");
        orderDTO.setBuyerAddress("百果园");
        orderDTO.setBuyerPhone("12345678911");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("00000");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("00001");
        o2.setProductQuantity(2);

        OrderDetail o3 = new OrderDetail();
        o3.setProductId("00002");
        o3.setProductQuantity(3);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDetailList.add(o3);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        Assert.assertEquals(ORDERID, orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0, 2);

        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);

        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);

        OrderDTO result = orderService.cancel(orderDTO);

        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);

        OrderDTO result = orderService.finish(orderDTO);

        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);

        OrderDTO result = orderService.paid(orderDTO);

        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list() {
        PageRequest pageRequest = new PageRequest(0, 2);

        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);

        Assert.assertTrue("查询所有订单列表", orderDTOPage.getTotalElements() > 0);
    }
}