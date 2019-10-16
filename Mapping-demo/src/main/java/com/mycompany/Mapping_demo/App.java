package com.mycompany.Mapping_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.Mapping_demo.model.Instructor;
import com.mycompany.Mapping_demo.model.InstructorDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
     			   addAnnotatedClass(Instructor.class). addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
      	  
     	   Session session=factory.getCurrentSession();
     	  InstructorDetails d = new InstructorDetails(null, null);
          d.setYoutubeChannel("http://youtube.com/myChannel");
          d.setHobby("Singing");
         
          Instructor i = new Instructor();
          i.setFirstName("Bhavana");
          i.setLastName("Shetty");
          i.setEmail("bhav@gmail.com");
          i.setInstructorDetailID(d);
          session.getTransaction().begin();
         // session.persist(d);
         // session.persist(i);
          session.save(i);//since i is cascade all by saving i, d also will be saved
          session.getTransaction().commit();
          session.close();
          
    }
}
