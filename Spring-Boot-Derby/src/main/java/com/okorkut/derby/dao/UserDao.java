package com.okorkut.derby.dao;

import java.util.List;

import com.okorkut.derby.model.User;

public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}