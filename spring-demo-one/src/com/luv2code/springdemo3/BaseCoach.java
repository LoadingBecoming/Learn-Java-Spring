package com.luv2code.springdemo3;

public class BaseCoach implements Coach{
	
	private takeFortune takeFortune;
	private String name;
	
	//Constructor injection
	
//	public BaseCoach(takeFortune takeFortune, String name) {
//		this.takeFortune = takeFortune;
//		this.name = name;
//	} 
	
	//Setter injection
	
	public BaseCoach() {
		
	}

	public void setTakeFortune(takeFortune takeFortune) {
		this.takeFortune = takeFortune;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		System.out.println("getTên: ");
		return name;
	}

	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "5 phút";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return takeFortune.recieveFortune();
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[fortune = " + takeFortune + "]" + "[name = " + name +"]";
		
	}

}
