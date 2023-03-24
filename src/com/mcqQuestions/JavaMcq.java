package com.mcqQuestions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.commonConnection.CommonConnection;

public class JavaMcq {
	
	static int score = 0;
	
	public static void questions(){
		Scanner scanner = new Scanner(System.in);
		
		
		try {
			Connection connection = CommonConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from java_mcq ");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			int count=0;
			
			while (resultSet.next()) {
				count++;
				
				String Quenstions = resultSet.getString(2);
				String option1 = resultSet.getString(3);
				String option2 = resultSet.getString(4);
				String option3 = resultSet.getString(5);
				String option4 = resultSet.getString(6);
				String answer = resultSet.getString(7);
				
				System.out.println("Answer the following Questions....\n");
				
				System.out.println(count + ". " + Quenstions);
                System.out.println("A. " + option1);
                System.out.println("B. " + option2);
                System.out.println("C. " + option3);
                System.out.println("D. " + option4);
           
                System.out.print("Enter Correct option: ");
        	    char choice = Character.toUpperCase(scanner.next().charAt(0));

        	    if (choice == answer.charAt(0)) {
        	    	
        	        System.out.println("Correct!");
        	        
        	        score++;
        	        
        	    } else {
        	        System.out.println("Incorrect....");
        	    }

        	    System.out.println();
        	    }

        	    
        	    System.out.println("Answers submitted.....\n");
			
		}
	            
	         catch (SQLException e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	}

	public static void getresult() {
		
		Scanner scanner = new Scanner(System.in);
		boolean result = false;
		
		do {
		System.out.println("Enter the username to check the result: ");
		String username = scanner.next();
		
	
		try {
			Connection connection = CommonConnection.getConnection();
			
			 PreparedStatement preparedStatement2 = connection.prepareStatement("update student_details set result=? where username=?");
     	    
     	    preparedStatement2.setInt(1, score);
     	    preparedStatement2.setString(2, username);
     	    preparedStatement2.execute();
     	    
     	    
			PreparedStatement preparedStatement = connection.prepareStatement("select * from student_details where username=?");
			
			preparedStatement.setString(1, username);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				System.out.println("\nFirst Name: " +resultSet.getString("firstname"));
				System.out.println("Last Name: " +resultSet.getString("lastname"));
				System.out.println("\nResult: " +resultSet.getString("result")+ " Out of 10");
				
				result = true;
				
			}else {
				System.out.println("Username is invalid...\n");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}while(!result);
}

}