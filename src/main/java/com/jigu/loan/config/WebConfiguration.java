package com.jigu.loan.config;

import com.jigu.loan.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(securityInterceptor);
        interceptor.excludePathPatterns("/admin/user/login",
                "/client/**");//debug
//                "/client/follower/checkFollower/**",
//                "/client/follower/uploadFollowerInfo");
        interceptor.addPathPatterns("/**");
    }
}
