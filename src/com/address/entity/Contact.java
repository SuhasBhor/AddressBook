package com.address.entity;

public class Contact {
	String firstName;	
	String lastName;
	String address;
	String city;
	String state;
	long zip;	
	long phoneNumber;
	String email;
	
	public Contact(String firstName, String lastName, String address, String city, String state, long zip,
			long phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		System.out.println("\n ==== " + firstName + " " + lastName + " ====");
		System.out.println(" Address: " + this.address);
		System.out.println(" City: " + this.city);
		System.out.println(" State: " + this.state);
		System.out.println(" Zip: " + this.zip);
		System.out.println(" Phone number: " + this.phoneNumber);
		System.out.println(" Email: " + this.email);
		return "";
	}
}
