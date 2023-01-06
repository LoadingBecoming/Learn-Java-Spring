package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspects {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpresstions.forDAOpackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n=>>>> log To Cloud Async");
	}
}
