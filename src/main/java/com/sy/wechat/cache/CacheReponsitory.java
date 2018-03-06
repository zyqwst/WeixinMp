/**
 * 
 */
package com.sy.wechat.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;

/** 
* @ClassName: CacheReponsitory 
* @Description: 缓存reponsitory
* @author albert
* @date 2017年6月26日 下午12:59:07 
*  
*/
public interface CacheReponsitory {
	
	public Cache getCache(String cacheName);
	
	public void put(String cacheName,Object key,Object value);
	public ValueWrapper get(String cacheName,Object key);
	public void evict(String cacheName,Object key);
	public void clear(String cacheName); 
}
