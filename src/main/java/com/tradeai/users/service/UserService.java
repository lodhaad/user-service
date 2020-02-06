package com.tradeai.users.service;

import java.util.List;

import com.tradeai.users.model.User;

public interface UserService {
	
	public User addUser(User user);
	public User getUser(String userId);
	public User deleteUser (String email);
	public List<User> getUsers();

}
