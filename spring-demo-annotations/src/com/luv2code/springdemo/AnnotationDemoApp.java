package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//read spring config file
		ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		Coach theCoach = Context.getBean("tennisCoach", Coach.class);
		
		// call method on the bean
		System.out.println(theCoach.getGailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the text
		Context.close();
	}

}
