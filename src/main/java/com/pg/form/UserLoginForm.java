package com.pg.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author pg
 * @Date 2021/11/25
 */
@Data
public class UserLoginForm {
    @NotEmpty(message = "登录名不能为空")
    private String loginName;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
