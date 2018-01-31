/**
 * 
 */
package com.albert.wechat.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping(value= {"/","index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("layout")
	public String layout() {
		return "layout";
	}
}
