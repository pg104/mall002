package com.pg.configuration;

import com.pg.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author pg
 * @Date 2021/11/30
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new UserFilter());
        filterRegistrationBean.addUrlPatterns("/cart/*","/user/orderList","/user/addressList");
        return filterRegistrationBean;
    }
}
