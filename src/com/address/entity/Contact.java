package com.address.entity;

import java.util.Scanner;

public class Contact {
	public String firstName;	
	public String lastName;
	public String address;
	public String city;
	public String state;
	public long zip;	
	public long phoneNumber;
	public String email;
	
	Scanner scan = new Scanner(System.in);
	
	public Contact(String firstName, String lastName, String address, String city, String state, long zip,long phoneNumber, String email) {
		System.out.print("Enter Your First Name: ");
		this.firstName = scan.nextLine();
		System.out.print("Enter Your Last Name: ");
		this.lastName = scan.nextLine();
		System.out.print("Enter Your Address: ");
		this.address = scan.nextLine();
		System.out.print("Enter Your City Name: ");
		this.city = scan.nextLine();
		System.out.print("Enter Your State: ");
		this.state = scan.nextLine();
		System.out.print("Enter Your Email ID: ");
		this.email = scan.nextLine();
		System.out.print("Enter Your Zip-Code: ");
		this.zip = scan.nextLong();
		System.out.print("Enter Your Phone Number: ");
		this.phoneNumber = scan.nextLong();		
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
	
	public void getNewFirstName() {
		System.out.print("Enter Your New Name: ");
		String newFirstName = scan.next();
		setFirstName(newFirstName);
		System.out.println("First Name Updated To "+newFirstName);
	}
	
	public void getNewLastName() {
		System.out.print("Enter Your New Last Name: ");
		String newLastName = scan.next();
		setLastName(newLastName);
		System.out.println("Last Name Updated To "+newLastName);
	}
	
	public void getNewAddress() {
		System.out.print("Enter Your New Addresss: ");
		String newAddress = scan.next();
		setAddress(newAddress);
		System.out.println("Address Updated To "+newAddress);
	}
	
	public void getNewCity() {
		System.out.print("Enter Your New City Name: ");
		String newCity = scan.next();
		setCity(newCity);
		System.out.println("City Updated To "+newCity);
	}
	
	public void getNewState() {
		System.out.print("Enter New State: ");
		String newState = scan.next();
		setState(newState);
		System.out.println("State Updated To "+newState);
	}
	
	public void getNewZip() {
		System.out.print("Enter Your New ZipCode: ");
		int newZip = scan.nextInt();
		setZip(newZip);
		System.out.println("ZipCode Updated To "+newZip);
	}
	
	public void getNewPhoneNumber() {
		System.out.print("Enter Your New Phone Number: ");
		long newPhone = scan.nextLong();
		setPhoneNumber(newPhone);
		System.out.println("Phone Updated To "+newPhone);
	}
	
	public void getNewEmail() {
		System.out.print("Enter New Email: ");
		long newEmail = scan.nextLong();
	setPhoneNumber(newEmail);
		System.out.println("Email Updated To "+newEmail);
	}
	@Override
	public String toString() {
		System.out.println("Name: " +this.firstName); 
		System.out.println("LastName: "+this.lastName);
		System.out.println(" Address: " + this.address);
		System.out.println(" City: " + this.city);
		System.out.println(" State: " + this.state);
		System.out.println(" ZipCode: " + this.zip);
		System.out.println(" Phone Number: " + this.phoneNumber);
		System.out.println(" Email: " + this.email);
		return "";
	}
}
