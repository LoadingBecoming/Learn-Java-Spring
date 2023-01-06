package com.luv2code.springdemo2;

public class GolfCoach implements Coach{
	
	private FortuneService fortuneService;
	public GolfCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
