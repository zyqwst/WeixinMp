/**
 * 
 */
package com.albert.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @ClassName: WxSupportController 
* @Description: 
* @author albert
* @date 2018年2月7日 下午9:53:20 
*  
*/
@RequestMapping("/wechat/support")
@RestController
public class WxSupportController extends WechatBaseController {
	@GetMapping("clubService")
	public String test() {
		return "<div style='backgroud:blue'>服务器端返回的数据</div>";
	}
}
