package com.adminOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.commonConnection.CommonConnection;

public class AdminCases {
	
	public static void  studentsTable() {
		
		try {
			Connection connection = CommonConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from student_details order by result asc");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				System.out.println("Roll Number: \t" +resultSet.getString(1));
				System.out.println("First Name: \t" +resultSet.getString(2));
				System.out.println("Last Name: \t" +resultSet.getString(3));
				System.out.println("Marks: \t\t" +resultSet.getInt(6));
				System.out.println();
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void studentDetails() {
		Scanner scanner = new Scanner(System.in);
		boolean details=false;
		
		do {
			
			System.out.println("Enter the Roll Number: ");
			int rollno1 = scanner.nextInt();
			
		
		try {
			Connection connection = CommonConnection.getConnection();
			
			PreparedStatement  preparedStatement = connection.prepareStatement("select * from student_details where rollno=?");
			
			preparedStatement.setInt(1, rollno1);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
			    System.out.println("Roll Number: \t" +resultSet.getInt("rollno"));
				System.out.println("Result: \t" +resultSet.getInt("result"));
				
				details=true;
				
			} else {
				System.out.println("Invalid Roll Number....Please Enter again!...");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}while(!details);

}
	
	public static void questionBank() {
		
		try {
			Connection connection = CommonConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from java_mcq");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				System.out.println("Question: " +resultSet.getString("Questions"));
				System.out.println("A: " +resultSet.getString("option1"));
				System.out.println("B: " +resultSet.getString("option2"));
				System.out.println("C: " +resultSet.getString("option3"));
				System.out.println("D: " +resultSet.getString("option4"));
				System.out.println();
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
