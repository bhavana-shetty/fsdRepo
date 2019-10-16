package com.mycompany.hibernate_demo_crud_demo.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_demo_crud_demo.model.Employee;



public class MyHibernateFactory {
	
	private static SessionFactory factory;
	private static Session session;
	
	public static SessionFactory getMySession()
	{
		factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		return factory;
				
	}
	

}
