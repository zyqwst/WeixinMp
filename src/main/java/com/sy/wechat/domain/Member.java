package com.sy.wechat.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_MEMBER")
@Entity
public class Member implements EntityBase{
    /**
     * 
     */
    private static final long serialVersionUID = -7370840797211106407L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long companyId;
    private Long storeId;
    private String code;
    private String name;
    private String sex;
    private Date birthday;
    private String phone;
    private String address;
    private String qq;
    private String email;
    private String wechat;
    private Integer status;
    private String password;
    private Long levelId;
    private Long areaId;
    private String helpCode;
    private String workplace;
    private Long creEmpId;
    private Date creDate;
    private Long modEmpId;
    private Date modDate;
    private String taboosRemark;
    
    private String openId;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCompanyId() {
        return companyId;
    }
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getWechat() {
        return wechat;
    }
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
	/**
	 * @return the levelId
	 */
	public Long getLevelId() {
		return levelId;
	}
	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getAreaId() {
        return areaId;
    }
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
    public String getHelpCode() {
        return helpCode;
    }
    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }
    public String getWorkplace() {
        return workplace;
    }
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
	public Long getCreEmpId() {
		return creEmpId;
	}
	public void setCreEmpId(Long creEmpId) {
		this.creEmpId = creEmpId;
	}
	public Date getCreDate() {
		return creDate;
	}
	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}
	public Long getModEmpId() {
		return modEmpId;
	}
	public void setModEmpId(Long modEmpId) {
		this.modEmpId = modEmpId;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getTaboosRemark() {
		return taboosRemark;
	}
	public void setTaboosRemark(String taboosRemark) {
		this.taboosRemark = taboosRemark;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
    
}
