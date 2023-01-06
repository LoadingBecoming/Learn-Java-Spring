package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session 
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();
				
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList(); 
			
			// display students 
			displayStudents(theStudents);
			
			// query student: lastName = "Duck"
			theStudents = session.createQuery("from Student s where s.lastName = 'Duck'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who has last name 'Duck'");
			displayStudents(theStudents);
			
			// query student: lastName = "Duck" or first Name = "Daffy"
			theStudents = session.createQuery("from Student s where s.lastName = 'Duck' or s.firstName = 'Paul'").getResultList();
			
			// display the students
			System.out.println("\n\nStudent who has first Name 'Paul' or last Name 'Duck' ");
			displayStudents(theStudents);
			
			//query student: email chứa Jonly@luv2code
			theStudents = session.createQuery("from Student s where s.email LIKE '%Jonly@luv2code%'").getResultList();
			
			//display students
			System.out.println("\n\nStudent who has email chua 'Jonly@luv2code' ");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close(); 
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
