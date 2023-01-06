package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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