package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControlPackage() {}
	
	// do the same for service and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Pointcut("forControlPackage() || forServicePackage() || forDaoPackage()")
	private void forAppflow() {}
	
	// add @Before advice
	@Before("forAppflow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @Before: Calling method: " + theMethod);
		
		// display the argument to the method 
		
		//  get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for(Object temp : args) {
			myLogger.info("====> Argument: " + temp);
		}
		
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppflow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @AfterReturning: from method: " + theMethod);
		
		// display data returned
		myLogger.info("=====>> Result: " + theResult);
	}
	
}
