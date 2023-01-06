package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpresstions.forDAOpackageNoGetterSetter()")                          
	public void beforeAddAccountAdvice() {
		System.out.println("\n=>>>>> Excuting @Before advice on method");
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