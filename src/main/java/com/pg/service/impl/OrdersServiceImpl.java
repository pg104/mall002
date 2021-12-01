package com.pg.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pg.entity.OrderDetail;
import com.pg.entity.Orders;
import com.pg.entity.Product;
import com.pg.mapper.OrderDetailMapper;
import com.pg.mapper.OrdersMapper;
import com.pg.mapper.ProductMapper;
import com.pg.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pg.vo.OrderDetailVO;
import com.pg.vo.OrdersVO;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<OrdersVO> findAllByUserId(Integer id) {
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        List<Orders> ordersList = ordersMapper.selectList(wrapper);
        List<OrdersVO> ordersVOList = new ArrayList<>();
        for (Orders orders : ordersList) {
            OrdersVO ordersVO = new OrdersVO();
            BeanUtils.copyProperties(orders,ordersVO);
            QueryWrapper<OrderDetail> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("order_id",orders.getId());
            List<OrderDetail> orderDetailList = orderDetailMapper.selectList(wrapper1);
            List<OrderDetailVO> orderDetailVOList = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetailList) {
                OrderDetailVO orderDetailVO = new OrderDetailVO();
                BeanUtils.copyProperties(orderDetail,orderDetailVO);
                Product product = productMapper.selectById(orderDetail.getProductId());
                BeanUtils.copyProperties(product,orderDetailVO);
                orderDetailVOList.add(orderDetailVO);
            }
            ordersVO.setOrderDetailVOList(orderDetailVOList);
            ordersVOList.add(ordersVO);
        }
        return ordersVOList;
    }
}
