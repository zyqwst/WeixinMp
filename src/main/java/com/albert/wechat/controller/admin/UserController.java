/**
 * 
 */
package com.albert.wechat.controller.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.albert.wechat.domain.Member;
import com.albert.wechat.domain.RestEntity;
import com.albert.wechat.utils.Value;

/** 
* @ClassName: UserManageController 
* @Description: 
* @author albert
* @date 2018年2月4日 下午2:16:50 
*  
*/
@Controller
@RequestMapping("/admin/user")
public class UserController extends AdminBaseController{
	@GetMapping
	public String index() {
		return "pages/user";
	}
	@PostMapping
	@ResponseBody
	public RestEntity query(Long id,String name) {
		
		return RestEntity.success();
	}
	@PostMapping("memberAuto")
	@ResponseBody
	public RestEntity memberAuto(@RequestBody String name) {
		System.out.println(name);
		Pageable pageable = new PageRequest(0, 100, new Sort(Sort.Direction.ASC, "name"));
		Page<Member> page = commonService.findPage(Member.class, " where name like ? ", new Value().add("%"+name+"%").getParams(), pageable);
		List<Member> alls = commonService.findAll(Member.class, " where name like ? ", new Value().add("%"+name+"%").getParams());
		System.out.println(page.getContent().size());
		System.out.println(alls.size());
		return RestEntity.success(page);
	}
}
