/**
 * 
 */
package com.albert.wechat.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albert.wechat.domain.RestEntity;
import com.albert.wechat.service.CommonService;

/** 
* @ClassName: IndexController 
* @Description: 
* @author albert
* @date 2018年1月31日 下午3:17:31 
*  
*/
@Controller
@RequestMapping("admin")
public class IndexController {
	@Resource
	CommonService commonService;
	@GetMapping(value= {"/","index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("layout")
	public String layout() {
		return "layout";
	}
	@RequestMapping("exception")
	public String testException(){
		List<RestEntity> list = commonService.findAllBySql(RestEntity.class, " select * from t_dao", null);
		return "d";
	}
}
