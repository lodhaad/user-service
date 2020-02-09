package com.tradeai.users.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.users.data.UserRepository;
import com.tradeai.users.dto.UserDTO;
import com.tradeai.users.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		
		ModelMapper mapper = new ModelMapper();
		User user = mapper.map(userDTO, User.class);

		User userFromDB = repository.save(user);
		
		return userDTO;
	}

	@Override
	public UserDTO getUser(String UserId) {
		
		Optional<User> user = repository.findById(UserId);
		User User =  user.get();
		
		ModelMapper mapper = new ModelMapper();
		UserDTO dto = mapper.map(User, UserDTO.class);
		
		return dto;
	}

	@Override
	public UserDTO deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
