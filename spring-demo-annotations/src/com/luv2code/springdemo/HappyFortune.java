package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FotuneService{

	@Override
	public String myFortune() {
		// TODO Auto-generated method stub
		return "Today is my fortune";
	}

}
