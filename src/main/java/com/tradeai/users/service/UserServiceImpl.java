package com.tradeai.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tradeai.users.data.UserRepository;
import com.tradeai.users.dto.UserDTO;
import com.tradeai.users.exception.UserServiceException;
import com.tradeai.users.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		
		ModelMapper mapper = new ModelMapper();
		
		User user = mapper.map(userDTO, User.class);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User userFromDB = repository.save(user);
		
		if (userFromDB != null ) {
			
			return userDTO;
			
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public UserDTO getUser(String UserId) {
		
		Optional<User> user = repository.findById(UserId);
		User User =  user.get();
		
		if ( User != null ) {
			
			ModelMapper mapper = new ModelMapper();
			UserDTO dto = mapper.map(User, UserDTO.class);
			
			return dto;
			
		}
		
		else {
			
			return null;
		}
		
		
	}
	



	@Override
	public void deleteUser(String userId) {

		repository.deleteById(userId);
		
		
	}
	
	
	

	@Override
	public List<UserDTO> getUsers() {


		Iterable<User> users = repository.findAll();
		
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		ModelMapper mapper = new ModelMapper();
		
		
		for (User user : users ) {
			
			UserDTO dto = mapper.map(user, UserDTO.class);
			dtoList.add(dto);
			
		}
		return dtoList;
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		ModelMapper mapper = new ModelMapper();
		
		User dataModel = mapper.map(user, User.class);
		
		Optional<User> userFromDb = repository.findById(dataModel.getUserId());
		
		User userFromDB = userFromDb.get();
		
		if (userFromDB != null ) {
			
			dataModel = repository.save(dataModel);
			
			UserDTO updatedUserDTO = mapper.map(dataModel, UserDTO.class);
			
			return updatedUserDTO;
			
		}
		
		else {
			
			throw new UserServiceException("The user you are trying to update does not exist");
		}

		
		
		
	}

}
