package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String service;
	
	// add a new method: findAccount()
	public List<Account> findAccounts(boolean tripWire) {
		
		// for academic purpose ... simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for you!!");
		}
		
		
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platium");
		Account temp3 = new Account("Luca", "Gold");
		
		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	
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
