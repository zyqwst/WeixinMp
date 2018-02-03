package com.albert.wechat.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;
/**
* @ClassName: WeixinAdminProperties 
* @Description: 后台管理
* @author albert
* @date 2018年2月3日 上午10:45:18 
*
 */
@ConfigurationProperties(prefix = "wechat.admin")
public class WeixinAdminProperties {
	private String secretKey;

	public String getSecretKey() {
		return secretKey;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	@Override
	public String toString() {
	  return ToStringBuilder.reflectionToString(this,
	      ToStringStyle.MULTI_LINE_STYLE);
	}
}
