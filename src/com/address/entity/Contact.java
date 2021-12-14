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

	public Contact(String firstName, String lastName, String address, String city, String state, long zip,
			long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zip = zip;
		this.phoneNumber = phoneNumber;

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
		System.out.println("First Name Updated To " + newFirstName);
	}

	public void getNewLastName() {
		System.out.print("Enter Your New Last Name: ");
		String newLastName = scan.next();
		setLastName(newLastName);
		System.out.println("Last Name Updated To " + newLastName);
	}

	public void getNewAddress() {
		System.out.print("Enter Your New Addresss: ");
		String newAddress = scan.next();
		setAddress(newAddress);
		System.out.println("Address Updated To " + newAddress);
	}

	public void getNewCity() {
		System.out.print("Enter Your New City Name: ");
		String newCity = scan.next();
		setCity(newCity);
		System.out.println("City Updated To " + newCity);
	}

	public void getNewState() {
		System.out.print("Enter New State: ");
		String newState = scan.next();
		setState(newState);
		System.out.println("State Updated To " + newState);
	}

	public void getNewZip() {
		System.out.print("Enter Your New ZipCode: ");
		int newZip = scan.nextInt();
		setZip(newZip);
		System.out.println("ZipCode Updated To " + newZip);
	}

	public void getNewPhoneNumber() {
		System.out.print("Enter Your New Phone Number: ");
		long newPhone = scan.nextLong();
		setPhoneNumber(newPhone);
		System.out.println("Phone Updated To " + newPhone);
	}

	public void getNewEmail() {
		System.out.print("Enter New Email: ");
		String newEmail = scan.next();
		setEmail(newEmail);
		System.out.println("Email Updated To " + newEmail);
	}

	@Override
	public String toString() {
		return "\n\nFirstName = " + firstName + "\nLastName = " + lastName + "\nAddress = " + address + "\nCity = " + city
				+ "\nState = " + state + "\nZip = " + zip + "\nPhoneNumber = " + phoneNumber + "\nEmail = " + email
				+ "\n--------------------------\n";
	}

}
