package com.omoruyi.StudentJPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
	
	
	public Student createStudent() {
			System.out.println("New Student Information")
	}
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQL");
	EntityManager em = emf.createEntityManager();
	
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }
}
