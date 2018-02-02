package com.albert.wechat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.albert.wechat.AuthorizationInterceptor;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
    	InterceptorRegistration addInterceptor = registry.addInterceptor(authorizationInterceptor);
        
        addInterceptor.excludePathPatterns("/error")
        				  .excludePathPatterns("/admin/login**")
        				  .addPathPatterns("/**");
    }

}
