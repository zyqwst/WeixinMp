/**
 * 
 */
package com.albert.wechat.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albert.wechat.domain.RestEntity;

/** 
* @ClassName: UserManageController 
* @Description: 
* @author albert
* @date 2018年2月4日 下午2:16:50 
*  
*/
@Controller
@RequestMapping("/admin/user")
public class UserController {
	@GetMapping
	public String index() {
		return "pages/user";
	}
	@PostMapping
	@ResponseBody
	public RestEntity query(Long id,String name) {
		
		return RestEntity.success();
	}
}
