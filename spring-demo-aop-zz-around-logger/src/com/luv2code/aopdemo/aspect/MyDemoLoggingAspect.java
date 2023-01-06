package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Excuting @Around on method" + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, lets execute method 
		Object result = theProceedingJoinPoint.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		
		myLogger.info("\n====>>>> Duration: " +  duration / 1000.0 + "second" );
		return result;
	}
	
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
				String method = theJoinPoint.getSignature().toShortString();
				myLogger.info("\n====>>> Excuting @After (finally) on method" + method);
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Excuting @AfterThrowing on method" + method);
		
		// log the exception
		myLogger.info("\n====>>> The exception is: " + theExc);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
			
		// print on which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Excuting @AfterReturning on method" + method);
		
		// print on the results of the method call
		myLogger.info("\n====>>> Result is: " + result);
	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpresstions.forDAOpackageNoGetterSetter()")                          
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n=>>>>> Excuting @Before advice on method");
		
		
		// display the method signature
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methoSig);
		
		// display method argument
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object temp : args){
			myLogger.info(temp.toString());
			
			if(temp instanceof Account) {
				
				// downcast and print Account specific stuff
				Account account = (Account) temp;
				
				myLogger.info("accountName: " + account.getName());
				myLogger.info("accountLevel: " + account.getLevel());
			}
		}
	}
}


//Chú ý:

// excution( (modifier) returnType 			packet 					class  method())
// excution(           *			com.luv2code.aopdemo.dao.		  *.	*(..)		

// modifier: không bắt buộc 
//add*() : mọi phương thức bắt đầu bằng add
// *: tất cả kiểu trả về => phụ thuộc kiểu trả về (bắt buộc)


// (): method không đối số
// (*): tất cả các đối số
// (..): không hoặc tất cả đối số