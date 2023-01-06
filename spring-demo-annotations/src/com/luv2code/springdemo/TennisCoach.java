package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
//	public TennisCoach() {
//		System.out.println(">> TennisCoach: Inside default constructor");
//	}
	@Autowired
	@Qualifier("happyFortune")
	private FotuneService fotuneService;
	
//	@Autowired
//	public TennisCoach (FotuneService fotuneService) {
//		this.fotuneService = fotuneService;
//	}
	public TennisCoach() {
		
	}
	
//	@Autowired
//	public void setFortuneService(FotuneService fotuneService) {
//		this.fotuneService = fotuneService;
//	}
	
	@Override
	public String getGailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fotuneService.myFortune();
	}

}
