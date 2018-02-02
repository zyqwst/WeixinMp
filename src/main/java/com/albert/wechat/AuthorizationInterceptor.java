package com.albert.wechat;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.albert.wechat.cache.CacheReponsitory;
import com.albert.wechat.exceptions.UnAuthorizedException;
import com.albert.wechat.utils.CommonUtils;


@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	
	private 
	@Resource
	CacheReponsitory cache;
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if(request.getRequestURI().startsWith("/admin")) {
        		Map<String,String> map = new HashMap<>();
        		if(request.getCookies()==null) throw new UnAuthorizedException("无访问权限");
        		for(Cookie c : request.getCookies()) {
        			map.put(c.getName(), c.getValue());
        		}
        		if(map.get(CommonUtils.ALBERT_X_HEADER)==null) throw new UnAuthorizedException("无访问权限");
        }else {
        		String authorization = request.getHeader(CommonUtils.ALBERT_X_HEADER);
	        if(StringUtils.isBlank(authorization)) throw new UnAuthorizedException("无访问权限");
	        if(cache.get(CommonUtils.ADMIN_CACHE, authorization)==null) throw new UnAuthorizedException("无访问权限");
    		}	
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	super.afterCompletion(request, response, handler, ex);
    	System.out.println("=================afterCompletion:"+response.getStatus());
    }
}
