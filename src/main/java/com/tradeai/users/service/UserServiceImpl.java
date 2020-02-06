package com.tradeai.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.users.data.UserRepository;
import com.tradeai.users.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String UserId) {
		
		Optional<User> user = repository.findById(UserId);
		return user.get();
	}

	@Override
	public User deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
