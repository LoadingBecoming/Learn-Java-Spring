package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addABCD() {
		System.out.println(getClass() + "DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public void goToSleep(boolean isReal) {
		System.out.println(getClass() + "Go sleep now!...");
	}
}
