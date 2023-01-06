package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspects {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpresstions.forDAOpackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n=>>>> perform API Analytics");
	}
}
