package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class ReadDemo {

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
			
			// create student object and save it
			InstructorDetail tempDetail = session.get(InstructorDetail.class, 2);
			System.out.println(tempDetail);
			
			Instructor tempInstructor = tempDetail.getInstructor();
			System.out.println(tempInstructor.toString());
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





