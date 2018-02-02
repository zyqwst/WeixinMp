/**
 * 
 */
package com.albert.wechat.domain;

import me.chanjar.weixin.common.util.ToStringUtils;

/** 
* @ClassName: LoginEntity 
* @Description: 
* @author albert
* @date 2018年2月2日 下午2:57:31 
*  
*/
public class LoginEntity {
	
	private String token;
	
	private String uname;
	
	private String upwd;
	
	private Long timestamp;
	
	private Employee emp;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}


	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	@Override
	  public String toString() {
	    return ToStringUtils.toSimpleString(this);
	  }

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
}
