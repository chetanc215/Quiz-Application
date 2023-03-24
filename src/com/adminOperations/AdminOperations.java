package com.adminOperations;

import java.util.Scanner;

public class AdminOperations {
	
	public static void adminOperations() {
		
		Scanner scanner = new Scanner(System.in);
		   boolean loginSystem = false;
		   boolean exit = false;
		   
		   while(!exit) {
			   
		   
			do {
		    
		    System.out.println("Please choose an option:\n");
		    
		    System.out.println("Enter 1 for  All Students result data in Ascending order");
		    System.out.println("Enter 2 to Fetch Students details by Roll No");
		    System.out.println("Enter 3 to See all Questions from Database");
		    System.out.println("Enter 4 to Logout");
		    
		    System.out.print("Option: ");
		    int option = scanner.nextInt();
		    
		    switch(option) {
		    
		        case 1:
		        	AdminCases.studentsTable();
		        	 loginSystem=true;
		            break;
		        case 2:
		            AdminCases.studentDetails();
		            loginSystem=true;
		            break;
		        case 3:
		        	AdminCases.questionBank();
		        	loginSystem=true;
		        	break;
		           
		        case 4:
		        	System.out.println("Successfully Logged out!");
		        	exit=true;
		        	break;
		        	
		        default:
		            System.out.println("Invalid option selected.");

				
			}
			
			
		}while(!loginSystem);
			
		   }
	}
		
	}


