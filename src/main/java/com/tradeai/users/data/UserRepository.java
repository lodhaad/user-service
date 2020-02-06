package com.tradeai.users.data;

import org.springframework.data.repository.CrudRepository;

import com.tradeai.users.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
