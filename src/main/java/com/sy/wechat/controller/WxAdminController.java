/**
 * 
 */
package com.sy.wechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

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
	private WxMpService wxMpService;
	/**获取所有模板消息*/
	@RequestMapping("/getAllPrivateTemplate")
	public String getAllPrivateTemplate() {
		try {
			List<WxMpTemplate>  list = wxMpService.getTemplateMsgService().getAllPrivateTemplate();
			for(WxMpTemplate w : list) {
				System.out.println(w);
			}
			return "success";
		} catch (WxErrorException e) {
			e.printStackTrace();
			return "failed";
		}
	}
	/** 发送模板消息
	 * @throws WxErrorException */
	@RequestMapping("/send")
	public String templateSend(@RequestParam(required=true) String name,@RequestParam(required=true) String created) throws WxErrorException {
		WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
				.toUser("osdrCw_8haFPBh4Ixn8UdY72rgno")
				.templateId("_18DCkHFxe3YQ27J5I6wyrJFjXPyP4RZRp-LH4gq8q8")
				.url("http://www.sviip.com")
				.build();
		templateMessage.getData().add(new WxMpTemplateData("name", name, "#0000ff"));
		templateMessage.getData().add(new WxMpTemplateData("credate", created, "#0000ff"));
		wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		return "success";
	}
	/**
	 * @throws WxErrorException 
	 * 给用户添加备注
	 */
	@RequestMapping("/updatemark")
	public String updateMark() throws WxErrorException {
		wxMpService.getUserService().userUpdateRemark("osdrCw_8haFPBh4Ixn8UdY72rgno", "测试albert");
		return "success";
	}
}
