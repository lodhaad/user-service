package com.tradeai.users.service;

import java.util.List;

import com.tradeai.users.dto.UserDTO;



public interface UserService {
	
	public UserDTO addUser(UserDTO user);
	
	public UserDTO getUser(String userId);
	
	public void deleteUser (String email);
	
	public List<UserDTO> getUsers();
	
	public UserDTO updateUser(UserDTO user);

}
