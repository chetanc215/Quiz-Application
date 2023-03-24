package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.commonConnection.CommonConnection;
import com.mcqQuestions.JavaMcq;

public class UserLogin {
	
	public static void userLogin() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean login = false;
		
		do {
			System.out.println("Please Login as User....\n");
			
			System.out.println("Enter username: ");
			String enteredUsername = scanner.next();
			
			System.out.println("Enter the Password: ");
			String enteredPassword = scanner.next();
			
			
			try {
				
				Connection connection = CommonConnection.getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement("select * from student_details where username=? and password=?");
				
				preparedStatement.setString(1, enteredUsername);
				preparedStatement.setString(2, enteredPassword);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					
					System.out.println("Login Successful!...\n");
					login = true;
					
				} else {
					System.out.println("Invalid Input!...Try again!...\n");
					
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} while(!login);
		
		JavaMcq.questions();
		JavaMcq.getresult();
	}
}
