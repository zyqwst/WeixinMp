/**
 * 
 */
package com.github.binarywang.demo.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.chanjar.weixin.mp.api.WxMpService;

/** 
* @ClassName: WxAdminController 
* @Description: 
* @author albert
* @date 2018年1月30日 下午4:36:28 
*  
*/
@RestController
@RequestMapping("/wechat/admin")
public class WxAdminController {
	@Autowired
	private WxMpService wxService;
	public void all(String content) {
		
	}
}
