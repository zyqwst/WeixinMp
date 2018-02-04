/**
 * 
 */
package com.albert.wechat.controller.admin;

import org.apache.commons.lang3.StringUtils;
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
import com.albert.wechat.exceptions.ServiceException;
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
	public RestEntity memberAuto(@RequestBody Member member) {
		if(StringUtils.isBlank("member.getName()")) throw new ServiceException("参数为空");
		Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "name"));
		Page<String> page = commonService.findPageBySql(String.class, "select name from t_member where name like ? ", new Value().add("%"+member.getName()+"%").getParams(), pageable);
		System.out.println(page.getContent().size());
		return RestEntity.success(page);
	}
}
