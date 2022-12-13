//To create a connection with database using singleton design pattern
package com.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	                                                        //db name
	private static String url = "jdbc:mysql://localhost:3306/depart_store";
	private static String user = "root";
	private static String pass = "baljot123";
	//Create an object of Connection
	private static Connection conn = null;
    
	//private constructor so that object of this cannot be declared
	private DBConnection() {
    
	}

	//Thread safe get connection function by using synchronized
	public static synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, pass);

		}
		return conn;

	}
}



