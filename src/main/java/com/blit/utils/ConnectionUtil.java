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
	String location = "jdbc:mysql://localhost:3306/bilt";
	String username = "root";
	String password = "kalCfc,24";
	
	return DriverManager.getConnection(location, username, password);
}


}
