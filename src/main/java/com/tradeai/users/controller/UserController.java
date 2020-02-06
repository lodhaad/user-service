package com.tradeai.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.users.model.User;
import com.tradeai.users.service.UserService;
import com.tradeai.users.ui.model.response.UserRestResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(path = "/{userId}", produces = {
			MediaType.APPLICATION_JSON_VALUE ,  MediaType.APPLICATION_XML_VALUE })
	
	public ResponseEntity<UserRestResponse> getUser(@PathVariable String userId){
		
		User user = service.getUser(userId);
		
		UserRestResponse restResponse = new UserRestResponse();
		restResponse.setUserName(user.getUserId());
		restResponse.setType(user.getType());
		
		
		return new ResponseEntity<UserRestResponse>(restResponse, HttpStatus.OK);
		
		
		
		
		
		
	}
	
	

}
