package com.forum.entity;

import java.util.Date;

/**
 * 
 *令牌实体类
 *
 */
public class LoginTicket {

	private Integer id;
	
	private String tel;
	// 令牌
	private String ticket;
	// 令牌属性 0为正常，1为失效
	private Integer status;
	//令牌有效期
	private Date expired;
	
	public LoginTicket() {
		this.id = 0;
		this.tel = "";
		this.ticket = "";
		this.status = 0;
		this.expired = null;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getExpired() {
		return expired;
	}
	public void setExpired(Date expired) {
		this.expired = expired;
	}
	
	
	
	
}
