package com.omoruyi.JPADemo2;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.omoruyi.JPADemo2.demo.Customer;

public class TestSystem {
	
	private static EntityManagerFactory EFM = Persistence.createEntityManagerFactory("pu");
	
	public static void main(String[] args) {
		
		addCustomer(1, "Osaretin", "Omofonmwan");
		addCustomer(2, "Omoruyi", "Omofonmwan");
		addCustomer(3, "Adebayo", "Uwensuyi");
		addCustomer(4, "Ajiboye", "Uwensuyi");
		addCustomer(5, "Shafiff", "TBA");
		
		getCustomer(1);
		getCustomers();
		changeFirstName(3, "Ade");
		deleteCustomer(2);
		EFM.close();
		
	}
	
	public static void addCustomer(int id, String fname, String lname) {
		EntityManager em = EFM.createEntityManager();
		EntityTransaction et = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			Customer cust = new Customer();
			cust.setId(id);
			cust.setfName(fname);
			cust.setlName(lname);
			
			em.persist(cust);
			et.commit();
		}catch(Exception ex) {
			if(et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void getCustomer(int id) {
		EntityManager em = EFM.createEntityManager();
		String query = "SELECT c FROM Customer c WHERE c.id = :custID";
		
		TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
		tq.setParameter("custID", id);
		Customer cust = null;
		
		try {
			cust = tq.getSingleResult();
			System.out.println(cust);
		}catch(NoResultException ex) {
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void getCustomers() {
		EntityManager em = EFM.createEntityManager();
		String strQuery = "SELECT c FROM Customer c";
		TypedQuery<Customer> tq = em.createQuery(strQuery, Customer.class);
		List<Customer> custs;
		
		try {
			custs = tq.getResultList();
			for(Customer c : custs) {
				System.out.println(c);
			}
			
		}catch(NoResultException ex){
			ex.printStackTrace();
		}finally {
			em.close();
		}	
	}
	
	public static void changeFirstName(int id, String fname) {
		EntityManager em = EFM.createEntityManager();
		EntityTransaction et = null;
		Customer cust = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			cust = em.find(Customer.class, id);
			cust.setfName(fname);
			
			em.persist(cust);
			et.commit();
		}catch(Exception ex) {
			if(et != null) {
				et.rollback();
			}
			
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public static void deleteCustomer(int id) {
		EntityManager em = EFM.createEntityManager();
		EntityTransaction et = null;
		Customer cust = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			cust = em.find(Customer.class, id);
			em.remove(cust);
			
			em.persist(cust);
			et.commit();
		}catch(Exception ex) {
			if(et != null) {
				et.rollback();
			}
			
			ex.printStackTrace();
		}finally {
			em.close();
		}
	}

}
