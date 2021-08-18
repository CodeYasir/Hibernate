package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.demo.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Student.class)
				                     .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
	try {
	    // start transaction
		session.beginTransaction();
		
		// Read Queries
		   List<Student> st = session.createQuery("from Student").getResultList();
		   displayResult(st);
		
		   List<Student> s2 = session.createQuery("from Student s where s.lastName='Ali'").getResultList();
		   displayResult(s2);
		
		   List<Student> s3 = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
		   displayResult(s3);
		
		// update Queries
		   session.createQuery("update Student set lastName='Hussain' where id=3").executeUpdate();
		
		// delete Queries
		   session.createQuery("delete from Student where id=4").executeUpdate();
		
		// commit the transaction
		   session.getTransaction().commit();		
		}
     finally {
			session.close();
		}
	}

	private static void displayResult(List<Student> theStudent) {
		for(Student temp : theStudent) {
			System.out.println(temp);
		}
	}

}
