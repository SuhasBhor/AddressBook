package com.address.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.address.entity.AddressBookList;
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
	ArrayList<AddressBookList> AddressBookNameList = new ArrayList<>();
	
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
	
	public void edit() {
		System.out.println("Enter Email Of Contact Person You Want To Edit: ");
		String email = scan.next();
		for (Contact person : contactBook) {
			if(email.equals(person.email)) {
				System.out.println("Select Option: "
						+ "1.firstName;"
						+ "	2.lastName;"
						+ "	3.address;"
						+ "	4.city;"
						+ "	5.state;"
						+ "	6.zip;"
						+ "	7.phoneNumber;");
				int ch = scan.nextInt();
				
				switch(ch) {
				case 1:
					System.out.print("Enter new first name :- ");
					String newFirstName = scan.next();
					person.setFirstName(newFirstName);
					System.out.println("First name is updated.");
					break;
					
				case 2:
					System.out.print("Enter new last name :- ");
					String newLastName = scan.next();
					person.setLastName(newLastName);
					System.out.println("Last name is updated.");
					break;
					
				case 3:
					System.out.print("Enter new Address :- ");
					String newAddress = scan.next();
					person.setAddress(newAddress);
					System.out.println("Address is updated.");
					break;
					
				case 4:
					System.out.print("Enter new city name :- ");
					String newCity = scan.next();
					person.setCity(newCity);
					System.out.println("City is updated.");
					break;
					
				case 5:
					System.out.print("Enter new state name :- ");
					String newState = scan.next();
					person.setState(newState);
					System.out.println("State is updated.");
					break;
					
				case 6:
					System.out.print("Enter new Zip code :- ");
					int newZip = scan.nextInt();
					person.setZip(newZip);
					System.out.println("Zip code is updated.");
					break;
					
				case 7:
					System.out.print("Enter new phone number :- ");
					long newPhone = scan.nextLong();
					person.setPhoneNumber(newPhone);
					System.out.println("Phone number is updated.");
					break;
	
				default:
					System.out.println("Please Enter Valid Choice!!!");	
				}
			}else {
				continue;
			}
		}
	}
	
	public void delete() {
		System.out.print("Enter Email to Delete Contact:- ");
		String deleteByEmail = scan.next();
		
		for(int i = 0; i < contactBook.size(); i++) {
			String Finding_email = contactBook.get(i).getEmail();
			
			if(deleteByEmail.equals(Finding_email)) {
				contactBook.remove(i);
				System.out.println("\nSelected contact deleted successfully.");
				break;
			}
			else {
				continue;
			}
		}
	}
	
	public void find() {
		System.out.print("Enter Email to Find Contact:- ");
		String findByEmail = scan.next();
		
		for(int i = 0; i < contactBook.size(); i++) {
			String Finding_Email = contactBook.get(i).getEmail();
			
			if(findByEmail.equals(Finding_Email)) {
				System.out.println("\n---Contatct Found---.");
				break;
			}
			else {
				System.out.println("\n---Contact Not Found---\n");
			}
		}
	}
	
	public void newAddressBook() {
		System.out.println("Enter Address Book Name: ");
		String bookName = scan.next();
		
		AddressBookList obj = new AddressBookList(bookName);
		AddressBookNameList.add(obj);
		
		System.out.println("New Address Book Is Added: "+obj);
	}
	
	public void displayAddressBook() {
		System.out.println("------Address Book List------");
		for (AddressBookList addressBookName : AddressBookNameList) {
			System.out.println(addressBookName.toString());
		}
	}
}
