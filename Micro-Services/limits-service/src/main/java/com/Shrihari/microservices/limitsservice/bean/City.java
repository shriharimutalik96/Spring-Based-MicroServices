package com.Shrihari.microservices.limitsservice.bean;

public class City {

	private String name;
	private String state;
	private String country;
	private int zipcode;
	
	public City() {
		super();
	}
	
	public City(String name, String state, String country, int zipcode) {
		super();
		this.name = name;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return "City [name=" + name + ", state=" + state + "]";
	}
	
	
}
