package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.commonConnection.CommonConnection;
import com.login.LoginSystem;
import com.login.UserLogin;

public class Registration {

	public static void userRegistration() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		int rollno;
		String firstname;
		String lastname;
		String username;
		String password;
		
		boolean registration=false;
		
		do {
		
		System.out.println("Enter the Roll Number: ");
		rollno = scanner.nextInt();
			
		System.out.println("Enter the First Name: ");
		firstname = scanner.next();
		
		System.out.println("Enter the Last Name: ");
		lastname = scanner.next();
		
		System.out.println("Enter new Username (case sensitive): ");
		username = scanner.next();
		
		System.out.println("Enter new Password (case sensitive): ");
		password = scanner.next();
		
		System.out.println("\n If you want to confirm registration press Y or Press N to repeat....");
		char ch =Character.toUpperCase(scanner.next().charAt(0));
		
		if(ch=='Y') {
		registration=true;
		}else if (ch=='N') {
			System.out.println("Enter the details again....\n");
		}
			
		}while(!registration);
		
		try {
		Connection connection = CommonConnection.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into student_details(rollno, firstname, lastname, username, password)values(?,?,?,?,?)");
		
		preparedStatement.setInt(1, rollno);
		preparedStatement.setString(2, firstname);
		preparedStatement.setString(3, lastname);
		preparedStatement.setString(4, username);
		preparedStatement.setString(5, password);
		
		
		preparedStatement.execute();
		
		
		System.out.println("Registration Successful.....\n");
	
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		
		LoginSystem.loginSystem();
	}
}

