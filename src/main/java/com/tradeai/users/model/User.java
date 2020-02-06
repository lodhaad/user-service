package com.tradeai.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "user", schema = "users")
public class User {
	
	@Id
	@Column (name = "user_name")
	private String userId;
	
	@Column (name = "user_password")
	private String password;
	
	@Column (name = "user_type")
	private String type;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
