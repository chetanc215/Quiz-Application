package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.adminOperations.AdminOperations;
import com.commonConnection.CommonConnection;

public class AdminLogin {
	
	public static void adminLogin() throws SQLException{
		
Scanner scanner = new Scanner(System.in);
		
		boolean login = false;
		
		do {
			System.out.println("Please Login as Admin....\n");
			
			System.out.println("Enter username: ");
			String adminUsername = scanner.next();
			
			System.out.println("Enter the Password: ");
			String adminPassword = scanner.next();
			
			
			try {
				
				Connection connection = CommonConnection.getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where username=? and password=?");
				
				preparedStatement.setString(1, adminUsername);
				preparedStatement.setString(2, adminPassword);
				
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
		
		AdminOperations.adminOperations();
	}

	}

