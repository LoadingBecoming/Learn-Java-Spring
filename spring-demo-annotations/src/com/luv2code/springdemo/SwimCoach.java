package com.luv2code.springdemo;


public class SwimCoach implements Coach{
	
	private FotuneService fotuneService;
	
	public SwimCoach(FotuneService fotuneService) {
		 this.fotuneService = fotuneService;
	}
	
	@Override
	public String getGailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim is so good";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fotuneService.myFortune();
	}

}
