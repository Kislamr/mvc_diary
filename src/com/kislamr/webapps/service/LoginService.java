package com.kislamr.webapps.service;

import com.kislamr.webapps.dao.UserDao;
import com.kislamr.webapps.dao.UserDaoImpl;
import com.kislamr.webapps.model.User;

public class LoginService {
	
	UserDao userDao = new UserDaoImpl();
	
	public boolean Authenticate(String userId, String password) {
		if (password == null || password.trim() == "") {
			return false;
		}
		System.out.println(userId);
		User fUser = userDao.getUserById(userId);
		
		if (fUser != null && password.equals(fUser.getUserPassword())) {
			return true;
		}
			return false;
	}
}
