package com.pg.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author pg
 * @Date 2021/11/25
 */
@Data
public class UserRegisterForm {
    @NotEmpty(message = "登录名不能为空")
    private String loginName;
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotNull(message = "性别不能为空")
    private Integer gender;
    @NotEmpty(message = "邮箱不能为空")
    private String email;
    @NotEmpty(message = "手机不能为空")
    private String mobile;
}
