/**
 * 
 */
package com.albert.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @ClassName: IndecController 
* @Description: 
* @author albert
* @date 2018年1月30日 下午4:29:28 
*  
*/
@Controller
public class IndecController {
	@RequestMapping(value= {"","admin"})
	public String index() {
		return "index";
	}
}
