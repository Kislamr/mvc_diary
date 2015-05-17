package com.kislamr.webapps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class DBConnectionUtil {
	static Connection dbcon = null;
	static private String loginUrl = "jdbc:postgresql://localhost/postdiarydb";
	static private String loginUser = "postgres";
	static private String loginPasswd = "qwe";
    
    public static Connection connect() {
	// Load the PostgreSQL driver
    try 
    {
          Class.forName("org.postgresql.Driver");
          dbcon = DriverManager.getConnection(loginUrl, loginUser, loginPasswd);
    }
    catch (ClassNotFoundException exception)
    {
           System.err.println("ClassNotFoundException: " + exception.getMessage());
    }
    catch (SQLException ex)
    {
           System.err.println("SQLException: " + ex.getMessage());
    }
	return dbcon;
    }

	public static Connection getDbcon() {
		return dbcon;
	}

	public static void setDbcon(Connection dbcon) {
		DBConnectionUtil.dbcon = dbcon;
	}
}
