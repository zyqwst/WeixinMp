/**
 * 
 */
package com.github.binarywang.demo.wechat.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;

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
	public void getAllPrivateTemplate() {
		try {
			List<WxMpTemplate>  list = wxMpService.getTemplateMsgService().getAllPrivateTemplate();
			for(WxMpTemplate w : list) {
				System.out.println(w);
			}
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
	/** 发送模板消息
	 * @throws WxErrorException */
	@RequestMapping("/send")
	public void templateSend() throws WxErrorException {
		WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
				.toUser("osdrCw_8haFPBh4Ixn8UdY72rgno")
				.templateId("AxIYSwNcuArzsI4OXj_MBRMWL6yCBjtaVo4jrZKz91M")
				.url("http://www.baidu.com")
				.build();
		templateMessage.getData().add(new WxMpTemplateData("name", "张亚强", "#0000ff"));
		templateMessage.getData().add(new WxMpTemplateData("credate", DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss", Locale.getDefault()), "#0000ff"));
		wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
	}
}
