package com.jsp.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {
	String url="jdbc:mysql://localhost:3306/javabatch";
	String username="root";
	String password="vipul1234";
	Connection connection =null;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e1) {
			//e1.printStackTrace();
			System.out.println("Executed");
		}
		try {
			connection =DriverManager.getConnection(url, username, password);
		}
		catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("Executed");
		}
		return connection;
	}
}