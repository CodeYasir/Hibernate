package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class CreateDemo {

  public static void main(String[] args) {

	 // create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
	 // create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// create student object and save it
			Instructor tempInstructor = session.get(Instructor.class, 1);
			Course tempCourses1 = new Course("Umar-The biggest");
			Course tempCourses2 = new Course("Ali-The knowledge gate");
			Course tempCourses3 = new Course("Khalid-sword of Allah");
			
			tempInstructor.addCourse(tempCourses1);
			tempInstructor.addCourse(tempCourses2);
			tempInstructor.addCourse(tempCourses3);
			
			session.save(tempCourses1);
			session.save(tempCourses2);
			session.save(tempCourses3);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





