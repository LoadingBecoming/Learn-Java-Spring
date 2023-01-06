package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
				String method = theJoinPoint.getSignature().toShortString();
				System.out.println("\n====>>> Excuting @After (finally) on method" + method);
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Excuting @AfterThrowing on method" + method);
		
		// log the exception
		System.out.println("\n====>>> The exception is: " + theExc);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
			
		// print on which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Excuting @AfterReturning on method" + method);
		
		// print on the results of the method call
		System.out.println("\n====>>> Result is: " + result);
	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpresstions.forDAOpackageNoGetterSetter()")                          
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=>>>>> Excuting @Before advice on method");
		
		
		// display the method signature
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methoSig);
		
		// display method argument
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object temp : args){
			System.out.println(temp);
			
			if(temp instanceof Account) {
				
				// downcast and print Account specific stuff
				Account account = (Account) temp;
				
				System.out.println("accountName: " + account.getName());
				System.out.println("accountLevel: " + account.getLevel());
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