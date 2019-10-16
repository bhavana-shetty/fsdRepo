package com.mycompany.Mapping_demo.one_to_one_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Instructor tempInstructor = new Instructor("bhav", "shetty", "bhav@lcode.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtjube.com", "Guitar2");

			tempInstructor.setInstructorDetail(tempInstructorDetail);

			session.getTransaction().begin();

			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
