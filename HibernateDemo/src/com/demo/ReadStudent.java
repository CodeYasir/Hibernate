package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class ReadStudent {

  public static void main(String[] args) {

	 // create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
	 // create session
		Session session = factory.getCurrentSession();
		
		try {			
		    int sid=1;
			
			// start a transaction
			session.beginTransaction();
			
			// Retrieve student object and display it
			Student tempStudent= session.get(Student.class, sid);
			System.out.println(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
		    }
		finally {
			factory.close();
		}
	}

}





