package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session 
		Session session = factory.getCurrentSession();
		
		// UPDATE OBJECT
		
		try {
			int StudentId = 1;
			
						
			// now  get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
						
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + StudentId);
						
			Student myStudent = session.get(Student.class, StudentId);
						
			System.out.println("update Student...");
			myStudent.setFirstName("Scooby");
			
			// commit transaction
			session.getTransaction().commit();
			
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all student
			System.out.println("Update email fot all student");
			session.createQuery("update Student set email = 'foo@email.com'").executeUpdate();
			
			// commit transaction
						session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close(); 
		}
	}

}
