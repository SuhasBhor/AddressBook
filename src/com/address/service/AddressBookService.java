package com.address.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.address.entity.Contact;

public class AddressBookService {
	
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	long zip;
	long phoneNumber;
	String email;
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Contact> contactBook = new ArrayList<>();
	
	public void getContact() {
		System.out.println("How Many Contacts You Want To Add: ");
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			
		System.out.print(" Please enter the first name: ");
		firstName = scan.next();
		
		System.out.print(" Please enter the last name: ");
		lastName = scan.next();
		
		System.out.print(" Please enter the address: ");
		address = scan.next();
		
		System.out.print(" Please enter the city: ");
		city = scan.next();
		
		System.out.print(" Please enter the state: ");
		state = scan.next();
		
		System.out.print(" Please enter the zip: ");
		zip = scan.nextLong();
		
		System.out.print(" Please enter the phone number: ");
		phoneNumber = scan.nextLong();
		
		System.out.print(" Please enter the email: ");
		email = scan.next();
		System.out.println("\n");
		
		Contact contact = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
		contactBook.add(contact);
		}
	}

	public void display() {
		System.out.println("------Contacts in Addrees Book------");
		for (Contact person : contactBook) {
			System.out.println(person.toString());
		}
	}
	
	public static void main(String[] args) {
		System.out.println("------Welcome TO AddressBook------");
		AddressBookService address = new AddressBookService();
		address.getContact();
		address.display();
	}
}
