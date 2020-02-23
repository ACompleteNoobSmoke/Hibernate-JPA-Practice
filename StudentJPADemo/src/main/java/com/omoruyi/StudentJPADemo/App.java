package com.omoruyi.StudentJPADemo;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.omoruyi.StudentJPADemo.model.Student;

/**
 * Hello world!
 *
 */
public class App {
	
	static Scanner scan = new Scanner(System.in);
	
	public Student createStudent() {
			Student newStudent = null;
			int id= 0;
			String name = "";
			String grade = "";
			String status = "";
			String hobby = "";
			
			try {
			System.out.println("**New Student Information**");
			
			while(id <= 0 || id > 999) {
				System.out.print("Enter Student ID: "); 
				id = scan.nextInt(); 
				scan.nextLine();
			}
			
			while(name.isBlank()) {
				System.out.print("Enter Student Name: ");
				name = scan.nextLine();
			}
			
			while(grade.isBlank()) {
				grade = getGrade().toString();
			}
			
			while(status.isBlank()) {
				status = getStatus().toString();
			}
			
			while(hobby.isBlank()) {
				System.out.print("Enter Student Hobby: ");
				hobby = scan.nextLine();
			}
			
			}catch(InputMismatchException e) {
				System.err.println("Incorrect Input");
				scan.nextLine();
			}
			
			newStudent = new Student();
			newStudent.setIDNumber(id);
			newStudent.setSName(name);
			newStudent.setSGrade(grade);
			newStudent.setSStatus(status);
			newStudent.setSHobby(hobby);
			
			return newStudent;
			
	}
	
	public SchoolYear getGrade() {
		SchoolYear tr = null;
		int choice = 0;
		
		while(choice < 1 || choice > 5) {
			try {
				int i = 0;
		 
				for (SchoolYear yr : SchoolYear.values()) { 
					System.out.println(++i + ". " + yr); 
					}
		 
					System.out.print("Pick School Year (1 - 5): "); 
					choice = scan.nextInt(); scan.nextLine();
		 
					 switch(choice) {
					 case 1: tr = SchoolYear.Freshman;
					 case 2: tr = SchoolYear.Sophomore;
					 case 3: tr = SchoolYear.Junior;
					 case 4: tr = SchoolYear.Senior;
					 case 5: tr = SchoolYear.Graduate;
					 }
		}catch(InputMismatchException e) {
			System.err.println("Incorrect Input");
			scan.nextLine();
		}
		}
		return tr;
		
	}
	
	public SchoolStatus getStatus() {
		SchoolStatus tr = null;
		int choice = 0;
		
		while(choice < 1 || choice > 2) {
			try {
				int i = 0;
		 
				for (SchoolStatus yr : SchoolStatus.values()) { 
					System.out.println(++i + ". " + yr); 
					}
		 
					System.out.print("Pick Student Status (1 - 2): "); 
					choice = scan.nextInt(); scan.nextLine();
		 
					 switch(choice) {
					 case 1: tr = SchoolStatus.Pass;
					 case 2: tr = SchoolStatus.Fail;
					 }
					 
		}catch(InputMismatchException e) {
			System.err.println("Incorrect Input");
			scan.nextLine();
		}
		}
		return tr;
		
	}
	
	public boolean option() {
		int choice = 0;
		while(choice < 1 || choice > 2) {
			try {
				System.out.println("\n*** Option ***");
				System.out.println("1. Enter New Student");
				System.out.println("2. Stop Program");
				System.out.print("Action: "); 
				choice = scan.nextInt();
				scan.nextLine();
			}catch(InputMismatchException e) {
				scan.nextLine();
			}
		}
		return choice == 1 ? true : false;
		
		
	}
	
	
	

	
    public static void main( String[] args ){
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	App a = new App();
    	
    	do {
    		em.getTransaction().begin(); //Specifies that the connection to the database is beginning.
        	em.persist(a.createStudent()); //Saves the data into a table format.
        	em.getTransaction().commit();//Ensures that the last persist action is saved directly to the database table.
    	}while(a.option());
    	
    	scan.close();
    	System.exit(0);
       
    }
}
