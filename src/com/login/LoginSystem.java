package com.login;

import java.sql.SQLException;
import java.util.Scanner;

import com.registration.Registration;

public class LoginSystem {
	
	public static void loginSystem() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
	   boolean loginSystem = false;
	   
		do {
			
	    System.out.println("Welcome to the login system!\n");
	    
	    System.out.println("Please choose an option:\n");
	    
	    System.out.println("Enter 1 for user Registration");
	    System.out.println("Enter 2 for User login");
	    System.out.println("Enter 3 for Admin Login \n");
	    System.out.print("Option: ");
	    int option = scanner.nextInt();
	    
	    switch(option) {
	    
	        case 1:
	        	Registration.userRegistration();
	        	 loginSystem=true;
	            break;
	            
	        case 2:
	            UserLogin.userLogin();
	            loginSystem=true;
	            break;
	            
	        case 3:   
	        	AdminLogin.adminLogin();
	        	loginSystem=true;
	        	
	        	
	        	break;
	            
	        default:
	            System.out.println("Invalid option selected.");

		

			
		}
		
		
	}while(!loginSystem);
}
	
}


