package com.kislamr.webapps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kislamr.webapps.model.User;
import com.kislamr.webapps.util.DBConnectionUtil;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
	}

	ArrayList<User> listOfUser = new ArrayList<User>();

	Connection db = DBConnectionUtil.connect();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	@Override
	public User getUserById(String userId) {
		try {
			ps = db.prepareStatement("select * from users where userid = ?");
			ps.setString(1, userId);
			rs = ps.executeQuery();

			if (rs.next()) {
				User fUser = new User();
				fUser.setUserId(rs.getString(1));
				fUser.setUserName(rs.getString(2));
				fUser.setUserPassword(rs.getString(3));
				return fUser;
			} else {
				return null;
			}

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

	@Override
	public ArrayList<User> getListOfUsers() {
		try {
			st = db.createStatement();
			ps = db.prepareStatement("SELECT * FROM users");
			rs = ps.executeQuery();

			while (rs.next()) {
				User fUser = new User();
				fUser.setUserId(rs.getString(1));
				fUser.setUserName(rs.getString(2));
				fUser.setUserPassword(rs.getString(3));
				listOfUser.add(fUser);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return listOfUser;
	}

	@Override
	public void addUser(String userId, String userName, String userPassword) {
		try {
			ps = db.prepareStatement("INSERT INTO users (userid, username, userpassword) VALUES (?, ?, ?)");
			ps.setString(1, userId);
			ps.setString(2, userName);
			ps.setString(3, userPassword);
			rs = ps.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void removeUser(String userId) {
		try {
			ps = db.prepareStatement("DELETE FROM users WHERE userid = ?");
			ps.setString(1, userId);
			rs = ps.executeQuery();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
}
