/**
 * 
 */
package com.sy.wechat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sy.wechat.config.WeixinAdminProperties;
import com.sy.wechat.service.CommonService;

/** 
* @ClassName: WechatBaseController 
* @Description: 
* @author albert
* @date 2018年2月4日 下午3:09:46 
*  
*/
public abstract class WechatBaseController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	HttpServletRequest request;
	@Resource
	CommonService commonService;
	
	@Resource
	WeixinAdminProperties adminProps;
	
	@Resource
	HttpServletResponse response;
	
}
