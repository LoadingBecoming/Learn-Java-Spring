package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String service;
	
	public void addAccount(Account account, boolean isFlag) {
		 System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + "DOWORK!");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + "in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "in setName()");
		this.name = name;
	}

	public String getService() {
		System.out.println(getClass() + "in getService()");
		return service;
	}

	public void setService(String service) {
		System.out.println(getClass() + "in setService()");
		this.service = service;
	}
	
	
}
