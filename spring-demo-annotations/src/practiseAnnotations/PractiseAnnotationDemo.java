package practiseAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PractiseAnnotationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// read spring config file
		ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get been from container
		Coach theCoach = Context.getBean("pingPongCoach", Coach.class);
		
		//call method
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//Close context
		Context.close();
	}

}
