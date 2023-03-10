package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			// get the Instructor detail object
			int theId = 3;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInsstructorDetail: " + tempInstructorDetail);
			
			// print the associate
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			
			// now delete instructorDetail 
			System.out.println("Deleting tempInstructor: " + tempInstructorDetail);
			
			
			//remove the associated object reference
			// break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close(); 
		}
	}

}
