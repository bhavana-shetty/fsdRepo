package com.mycompany.Mapping_demo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			Instructor tempInstructor = 
					new Instructor("bhavana", "Patel", "madhu@luv2code.com");
			
			InstructorDetails tempInstructorDetail =
					new InstructorDetails("http://www.youtube.com",
							"Guitar");		
			
			
			tempInstructor.setInstructorDetailID(tempInstructorDetail);
			
			
			session.beginTransaction();
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
