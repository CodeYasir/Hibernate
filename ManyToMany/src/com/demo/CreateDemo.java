package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;
import com.demo.entity.Student;

public class CreateDemo {

  public static void main(String[] args) {

	 // create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
	 // create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			              
			
	    // create a course
	       Course tempCourse = new Course("Pacman - How To Score One Million Points");
				
	    // create the students
	       Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
	       Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		
	    // associate students with courses     
	       tempCourse.addStudent(tempStudent1);
	       tempCourse.addStudent(tempStudent2);
	
	    // Save both students and courses    
	       session.save(tempCourse);
	       session.save(tempStudent1);
		   session.save(tempStudent2);

			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





