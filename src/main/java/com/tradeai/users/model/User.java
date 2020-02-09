package com.tradeai.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table (name = "user", schema = "users")
@Getter
@Setter


public class User {
	
	@Id
	@Column (name = "user_name")
	private String userId;
	
	@Column (name = "user_password")
	private String password;
	
	@Column (name = "user_type")
	private String type;
	



}
