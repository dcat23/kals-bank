package com.blit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {public static Connection getConnection() throws SQLException {
	/*
	 * Traditionally, the Driver Manager had 
	 * to be made aware of the dialect Driver.
	 * This is no longer necessary usually but
	 * you will probably still encounter it.
	 */
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//credentials
	// todo: fix db name
	String location = "jdbc:mysql://localhost:3309/bilt";
	String username = "root";
	String password = "password";
	
	return DriverManager.getConnection(location, username, password);
}


}
