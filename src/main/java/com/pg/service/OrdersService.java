package com.pg.service;

import com.pg.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pg.vo.OrdersVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface OrdersService extends IService<Orders> {
    public List<OrdersVO> findAllByUserId(Integer id);
}
