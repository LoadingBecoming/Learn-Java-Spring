package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

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
	/*		
			//create the objects
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
																		"Luv 2 code!!!");
			//associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
	*/		
			
			//create the objects
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com",
																		"Guitar");
			//associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the objects	
			//
			// Note: this will ALSO save the detail object
			// because of cascadeType.All
			//
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close(); 
		}
	}

}
