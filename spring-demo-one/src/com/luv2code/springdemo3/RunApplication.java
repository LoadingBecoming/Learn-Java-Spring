package com.luv2code.springdemo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//
		ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BaseCoach theCoach = Context.getBean("newCoach", BaseCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getName());
		System.out.println(theCoach.toString());
		Context.close();
	}

}
