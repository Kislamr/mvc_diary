package com.kislamr.webapps.dao;

import java.util.ArrayList;

import com.kislamr.webapps.model.User;


public interface UserDao {

	User getUserById(String userId);
	
	ArrayList<User> getListOfUsers();

	void addUser(String userId, String userName, String userPassword);

	void removeUser(String userId);
}
