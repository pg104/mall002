package com.pg.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pg.entity.User;
import com.pg.entity.UserAddress;
import com.pg.enums.ResponseEnum;
import com.pg.exception.MMallException;
import com.pg.form.UserLoginForm;
import com.pg.form.UserRegisterForm;
import com.pg.service.CartService;
import com.pg.service.OrdersService;
import com.pg.service.UserAddressService;
import com.pg.service.UserService;
import com.pg.utils.RegexValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserAddressService userAddressService;

    /**
     * 用户注册
     * @param userRegisterForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public String register(UserRegisterForm userRegisterForm, BindingResult bindingResult){
        //非空校验
        if (bindingResult.hasErrors()){
            log.info("【用户注册】用户信息不能为空");
            throw new MMallException(ResponseEnum.USER_INFO_NULL);
        }
        userService.register(userRegisterForm);
        return "redirect:/login";
    }

    /**
     * 用户登录
     * @param userLoginForm
     * @param bindingResult
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(@Valid UserLoginForm userLoginForm, BindingResult bindingResult, HttpSession session){
        //非空校验
        if (bindingResult.hasErrors()){
            log.info("【用户登录】用户信息不能为空");
            throw new MMallException(ResponseEnum.USER_INFO_NULL);
        }
        User login = userService.login(userLoginForm);
        session.setAttribute("user",login);
        return "redirect:/productCategory/main";
    }

    /**
     * 返回当前用户的订单列表
     * @param session
     * @return
     */
    @GetMapping("/orderList")
    public ModelAndView ordersList(HttpSession session){
        //判断是否为登录用户
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【查询订单】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderList");
        modelAndView.addObject("orderList",ordersService.findAllByUserId(user.getId()));
        modelAndView.addObject("cartList",cartService.findVOListByUserId(user.getId()));
        return modelAndView;
    }

    /**
     * 返回当前用户的地址列表
     * @param session
     * @return
     */
    @GetMapping("/addressList")
    public ModelAndView addressList(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            log.info("【查询地址】当前为未登录状态");
            throw new MMallException(ResponseEnum.NOT_LOGIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userAddressList");
        QueryWrapper<UserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",user.getId());
        modelAndView.addObject("addressList",userAddressService.list(wrapper));
        modelAndView.addObject("cartList",cartService.findVOListByUserId(user.getId()));
        return modelAndView;
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}

