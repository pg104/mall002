package com.pg.vo;

import com.pg.entity.OrderDetail;
import lombok.Data;

import java.util.List;

/**
 * @Author pg
 * @Date 2021/12/1
 */
@Data
public class OrdersVO {
    private Integer id;
    private String loginName;
    private String userAddress;
    private Float cost;
    private String serialnumber;
    private List<OrderDetailVO> orderDetailVOList;
}
