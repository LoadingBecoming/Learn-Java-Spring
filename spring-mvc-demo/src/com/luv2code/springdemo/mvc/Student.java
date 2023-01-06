package com.luv2code.springdemo.mvc;

import java.util.*;

public class Student {
	private String firstName;
	private String lasttName;
	private String country;
	private String favoriteLang;
	private String[] operateSystems;
	
	private LinkedHashMap <String, String> countryOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("GM", "Germany");
		countryOptions.put("FR", "France");
		countryOptions.put("IN", "India");
		countryOptions.put("VI", "VietNam");
		
	}

	public String getFirstName() {
		return firstName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLang() {
		return favoriteLang;
	}

	public void setFavoriteLang(String favoriteSub) {
		this.favoriteLang = favoriteSub;
	}

	public String[] getOperateSystems() {
		return operateSystems;
	}

	public void setOperateSystems(String[] operateSystems) {
		this.operateSystems = operateSystems;
	}

	
	
	
	
}
