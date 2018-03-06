/**
 * 
 */
package com.sy.wechat.controller;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sy.wechat.domain.Member;
import com.sy.wechat.utils.Value;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

/** 
* @ClassName: WechatWebController 
* @Description: 微信网页
* @author albert
* @date 2018年2月12日 上午10:57:16 
*  
*/
@Controller
@RequestMapping("/wechat/web")
public class WechatWebController extends WechatBaseController {

	  @Autowired
	  private WxMpService wxService;
	/**
	   * 与账户有关的router
	   * @param model
	   * @param router
	   * @param code
	   * @return
	   * @throws WxErrorException
	   */
	  @RequestMapping("/account/{router}")
	  public String web(Model model,@PathVariable("router") String router,@RequestParam(defaultValue="blank") String code) throws WxErrorException {
		  String url = adminProps.getHostUrl() + request.getRequestURI();
		  logger.info("code:{},router:{}",code,router);
		  WxJsapiSignature s = wxService.createJsapiSignature(url);
		  logger.info("jsapiticket:{}",wxService.getJsapiTicket());
		  logger.info("JsAPI===>nonceStr:{},timestamp:{},url:{},signature:{}",s.getNonceStr(),s.getTimestamp(),s.getUrl(),s.getSignature());
		  model.addAttribute("wxJsapiSignature", s);
		  WxMpOAuth2AccessToken access_token = wxService.oauth2getAccessToken(code);
		  model.addAttribute("openId",access_token.getOpenId());
		  model.addAttribute("router","account/"+router);
		  Member member = commonService.findEntity(Member.class, " where openId=? ", new Value().add(access_token.getOpenId()).getParams());
		  response.addCookie(new Cookie("bind", member==null?"-1":"1"));
		  response.addCookie(new Cookie("member", member==null?"":member.getName()));
		  
		  response.addCookie(new Cookie("test", "fuck"));
		  
		  return "portal";
	  }
	  @RequestMapping("/show/{router}")
	  public String show(Model model,@PathVariable("router") String router) throws WxErrorException {
		  String url = adminProps.getHostUrl() + request.getRequestURI();
//		  model.addAttribute("openId",access_token.getOpenId());
		  model.addAttribute("router","show/"+router);
//		  Member member = commonService.findEntity(Member.class, " where openId=? ", new Value().add(access_token.getOpenId()).getParams());
//		  response.addCookie(new Cookie("bind", member==null?"-1":"1"));
//		  response.addCookie(new Cookie("member", member==null?"":member.getName()));
//		  
		  response.addCookie(new Cookie("test", "fuck"));
		  
		  return "portal";
	  }
	  private String test(String url) {
		 return wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, null);
	  }

}
