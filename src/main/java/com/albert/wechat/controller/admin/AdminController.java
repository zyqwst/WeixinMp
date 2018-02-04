/**
 * 
 */
package com.albert.wechat.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albert.wechat.domain.Employee;
import com.albert.wechat.domain.LoginEntity;
import com.albert.wechat.domain.RestEntity;
import com.albert.wechat.exceptions.WeixinMpException;
import com.albert.wechat.utils.CommonUtils;
import com.albert.wechat.utils.JwtUtil;
import com.albert.wechat.utils.Value;

import me.chanjar.weixin.common.util.crypto.SHA1;

/** 
* @ClassName: IndexController 
* @Description: 
* @author albert
* @date 2018年1月31日 下午3:17:31 
*  
*/
@Controller
@RequestMapping("admin")
public class AdminController extends AdminBaseController{
	@GetMapping(value= {"","index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("layout")
	public String layout() {
		return "layout";
	}
	@PostMapping("login")
	@ResponseBody
	public RestEntity login(@RequestBody LoginEntity loginEntity) {
		if(StringUtils.isBlank(loginEntity.getUname()) || StringUtils.isBlank(loginEntity.getUpwd()) || loginEntity.getTimestamp()==null) throw new WeixinMpException("用户名或密码为空");
		loginEntity.setEmp(null);
		loginEntity.setToken(null);
		List<Employee> list = commonService.findAll(Employee.class, " where code=? and status=1 ", new Value().add(loginEntity.getUname()).getParams());
		
		if(CollectionUtils.isEmpty(list) || list.size()>1) throw new WeixinMpException("用户名或密码错误");
		
		String s = SHA1.gen(loginEntity.getUname()+list.get(0).getPassword()+loginEntity.getTimestamp());
		if(!s.equals(loginEntity.getUpwd())) throw new WeixinMpException("用户名或密码错误");
		commonService.detach(list.get(0));
		list.get(0).setPassword(null);
		loginEntity.setEmp(list.get(0));
		String token = JwtUtil.createJWT(System.currentTimeMillis()+"", "com.albert", list.get(0).getName(),
				-1, properties.getSecretKey());
		cache.getCache(CommonUtils.ADMIN_CACHE).put(token, list.get(0));
		response.addHeader(CommonUtils.ALBERT_X_HEADER, token);
		return RestEntity.success("login success");
	}
	@GetMapping("login")
	public String login() {
		Map<String,String> map = new HashMap<>();
		if(request.getCookies()==null) {
			return "login";
		}
		for(Cookie c : request.getCookies()) {
			map.put(c.getName(), c.getValue());
		}
		if(map.get(CommonUtils.ALBERT_X_HEADER)==null) return "login";
		try {
			JwtUtil.parseJWT(map.get(CommonUtils.ALBERT_X_HEADER), properties.getSecretKey());
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
		ValueWrapper obj = cache.get(CommonUtils.ADMIN_CACHE, map.get(CommonUtils.ALBERT_X_HEADER));
		if(obj==null) return "login";
		request.setAttribute("employee", obj.get());
		return "redirect:/admin";
	}
	@GetMapping("logout")
	public String logout(@CookieValue String access_token) {
		evictCacheVal(access_token);
		return "login";
	}
	
}
