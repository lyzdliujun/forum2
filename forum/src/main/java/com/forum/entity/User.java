package com.forum.entity;

import java.io.Serializable;

public class User implements Serializable{

	
	private static final long serialVersionUID = -2775842734146510115L;
	private int id;
	private String tel;
	private String password;
	private String salt;
	private String name;
	// 头像连接
	private String headLink;
	
	// 无参构造函数
	public User() {
		// 给个初始值
		this.id = 0;
		this.tel = "";
		this.password = "";
		this.salt = "";
		this.name = "";
		this.headLink = "";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getHeadLink() {
		return headLink;
	}

	public void setHeadLink(String headLink) {
		this.headLink = headLink;
	}
	
	
	
	
}
