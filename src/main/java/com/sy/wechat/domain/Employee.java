/**
 * 
 */
package com.sy.wechat.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @ClassName: Employee 
* @Description: 
* @author albert
* @date 2018年2月2日 下午2:58:41 
*  
*/
@Table(name= "t_employee")
@Entity
public class Employee implements EntityBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1666912635824991817L;
	@Id
	private Long id ;
	private String code;
	private String name;
	private Integer status;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
