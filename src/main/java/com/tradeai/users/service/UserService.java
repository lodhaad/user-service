package com.tradeai.users.service;

import java.util.List;

import com.tradeai.users.dto.UserDTO;
import com.tradeai.users.model.User;

public interface UserService {
	
	public UserDTO addUser(UserDTO user);
	public UserDTO getUser(String userId);
	public UserDTO deleteUser (String email);
	public List<UserDTO> getUsers();

}
