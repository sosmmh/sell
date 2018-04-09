package com.imooc.converter;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Lixh
 * @Date: 2018/4/8 11:19
 * @Description:
 */
public class OrderDTO2OrderMasterConverter {

    public static OrderMaster convert(OrderDTO orderDTO) {

        OrderMaster orderMaster = new OrderMaster();

        BeanUtils.copyProperties(orderDTO, orderMaster);

        return orderMaster;
    }

    public static List<OrderMaster> convert(List<OrderDTO> orderDTOList) {

        return orderDTOList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
