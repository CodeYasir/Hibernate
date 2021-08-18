package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;

public class CreateDemo {

  public static void main(String[] args) {

	 // create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
	 // create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
		// create a course
			Course tempCourse = session.get(Course.class, 10); 
			
		//  Add some reviews
			ArrayList<Review> reviews = new ArrayList<>();
			
			reviews.add(new Review("Cool course, job well done"));
			reviews.add(new Review("What a dumb course, you are an idiot!"));	
			
		//  Associate review with course and save	
			tempCourse.setReviews(reviews);
			session.save(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





