package com.commonConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonConnection {
	
	public static Connection getConnection() throws SQLException {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/question_bank","root","Chet@n215");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
		
	}

}
