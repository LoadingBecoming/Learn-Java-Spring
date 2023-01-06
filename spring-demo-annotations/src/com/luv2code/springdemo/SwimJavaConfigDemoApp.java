package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//read spring config file
		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext(CoachConfig.class);
		
		//get the bean from spring container
		Coach theCoach = Context.getBean("swimCoach", Coach.class);
		
		// call method on the bean
		System.out.println(theCoach.getGailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the text
		Context.close();
	}

}
