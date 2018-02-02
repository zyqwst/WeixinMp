/**
 * 
 */
package com.albert.wechat.cache;

import javax.annotation.Resource;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/** 
* @ClassName: EhcacheReponsitoryImpl 
* @Description: Ehcache 缓存实现
* @author albert
* @date 2017年6月26日 下午1:06:16 
*  
*/
@Component
public class EhcacheReponsitoryImpl implements CacheReponsitory {
	@Resource
	private CacheManager cacheManager;
	
	@Override
	public Cache getCache(String cacheName) {
		return cacheManager.getCache(cacheName);
	}
	
	@Override
	public void put(String cacheName, Object key, Object value) {
		cacheManager.getCache(cacheName).put(key, value);
	}

	
	@Override
	public ValueWrapper get(String cacheName, Object key) {
		return cacheManager.getCache(cacheName).get(key);
	}

	
	@Override
	public void evict(String cacheName, Object key) {
		cacheManager.getCache(cacheName).evict(key);
	}

	
	@Override
	public void clear(String cacheName) {
		cacheManager.getCache(cacheName).clear();
	}

}
