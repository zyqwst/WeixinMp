/**
 * 
 */
package com.albert.wechat.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cache.Cache.ValueWrapper;

import com.albert.wechat.cache.CacheReponsitory;
import com.albert.wechat.config.WeixinAdminProperties;
import com.albert.wechat.service.CommonService;
import com.albert.wechat.utils.CommonUtils;

/** 
* @ClassName: AdminBaseController 
* @Description: 
* @author albert
* @date 2018年2月4日 下午3:09:46 
*  
*/
public abstract class AdminBaseController {
	@Resource
	CommonService commonService;
	@Resource
	CacheReponsitory cache;
	@Resource
	HttpServletRequest request;
	
	@Resource
	WeixinAdminProperties properties;
	
	@Resource
	HttpServletResponse response;
	ValueWrapper cacheVal(String key) {
		return cache.get(CommonUtils.ADMIN_CACHE, key);
	}
	
	void cacheVal(Object key,Object value) {
		cache.put(CommonUtils.ADMIN_CACHE, key, value);
	}
	void evictCacheVal(Object key) {
		cache.evict(CommonUtils.ADMIN_CACHE, key);
	}
}
