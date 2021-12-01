package com.pg.service;

import com.pg.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pg.form.UserLoginForm;
import com.pg.form.UserRegisterForm;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pg
 * @since 2021-11-25
 */
public interface UserService extends IService<User> {
    public User register(UserRegisterForm userRegisterForm);
    public User login(UserLoginForm userLoginForm);

}
