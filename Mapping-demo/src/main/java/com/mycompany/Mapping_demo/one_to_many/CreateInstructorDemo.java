package com.mycompany.Mapping_demo.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

	
		Session session = factory.getCurrentSession();

		try {

			Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

			tempInstructor.setInstructorDetail(tempInstructorDetail);

			session.beginTransaction();

			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
		}
	}

}