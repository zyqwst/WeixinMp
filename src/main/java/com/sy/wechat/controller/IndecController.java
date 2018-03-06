/**
 * 
 */
package com.sy.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: IndecController 
* @Description: 
* @author albert
* @date 2018年1月30日 下午4:29:28 
*  
*/
@Controller
public class IndecController {
	@GetMapping(value= {""})
	@ResponseBody
	public String index() {
		return "启动成功";
	}
}
