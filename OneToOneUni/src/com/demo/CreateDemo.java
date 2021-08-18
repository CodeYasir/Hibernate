package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class CreateDemo {

  public static void main(String[] args) {

	 // create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
	 // create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
		// save Instructor also save details
			Instructor tempInstructor = new Instructor("Paul", "Doe", "paul@luv2code.com");
			InstructorDetail tempDetail = new InstructorDetail("www.youtube.com", "Cricket");
			tempInstructor.setInstructorDetail(tempDetail);
			session.save(tempInstructor);
			
		// Read detail from loading instructor
			Instructor tempInstructor1 = session.get(Instructor.class, 2);
			InstructorDetail tempDetail1 = tempInstructor1.getInstructorDetail();
			System.out.println(tempDetail1);	
			
		//  Delete instructor also delete details
			Instructor tempInstructor2 = session.get(Instructor.class, 1);
			session.delete(tempInstructor2);	
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





