package com.pg.service;

import com.pg.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pg.entity.Orders;
import com.pg.entity.User;
import com.pg.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface CartService extends IService<Cart> {
    public Boolean add(Cart cart);
    public List<CartVO> findVOListByUserId(Integer userId);
    public Boolean update(Integer id,Integer quantity,Float cost);
    public Boolean delete(Integer id);
    public Orders commit(String userAddress, String address, String remark, User user);
}
