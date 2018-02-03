/**
 * 
 */
package com.albert.wechat.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albert.wechat.cache.CacheReponsitory;
import com.albert.wechat.config.WeixinAdminProperties;
import com.albert.wechat.domain.Employee;
import com.albert.wechat.domain.LoginEntity;
import com.albert.wechat.domain.RestEntity;
import com.albert.wechat.exceptions.WeixinMpException;
import com.albert.wechat.service.CommonService;
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
public class AdminController {
	@Resource
	CommonService commonService;
	@Resource
	CacheReponsitory cache;
	@Resource
	HttpServletRequest request;
	
	@Resource
	WeixinAdminProperties properties;
	
	@Resource
	private HttpServletResponse response;
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
		return "login";
	}
	
	
}
