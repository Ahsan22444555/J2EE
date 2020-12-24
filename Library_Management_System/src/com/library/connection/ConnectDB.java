package com.library.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {
	
	
	
	public Connection connection() {
		
	try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "jJ101106");
            return con;
	}
	
	catch(Exception e) {
		System.out.println("Hello Server! ");
		e.printStackTrace();
	}
	return null;
}
}
