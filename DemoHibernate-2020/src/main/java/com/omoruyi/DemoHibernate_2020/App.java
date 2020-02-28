package com.omoruyi.DemoHibernate_2020;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
import org.hibernate.service.ServiceRegistry;

 
public class App  
{
    public static void main( String[] args )
    {
    	 
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    	SessionFactory sf = config.buildSessionFactory(registry);
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
    	Laptop l = session.load(Laptop.class, 1);
    	System.out.println(l);
    	
    }
}
