package com.address.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.address.entity.AddressBookList;
import com.address.entity.Contact;

public class AddressBookService {
	
	String firstName, lastName, address, city, state,email; 
	long zip, phoneNumber;
	Scanner scan = new Scanner(System.in);
	Contact contact;
	ArrayList<Contact> contactBook = new ArrayList<>();
	ArrayList<AddressBookList> AddressBookNameList = new ArrayList<>();
	
	public void getContact() {
		System.out.println("How Many Contacts You Want To Add: ");
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {	
		contact = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
		contactBook.add(contact);
		}
	}

	public void display() {
		System.out.println("------Contacts in Addrees Book------");
		for (Contact contact : contactBook) {
			System.out.println(contact.toString());
		}
	}
	
	public void edit() {
		System.out.println("Enter Email Of Contact You Want To Edit: ");
		String email = scan.next();
		for (Contact contact : contactBook) {
			if(email.equals(contact.email)) {
				System.out.println("Select Option: \n1.FirstName\n2.LastName\n3.Address\n4.City\n5.State\n6.ZipCode\n7.PhoneNumber\n8Email;");
				int ch = scan.nextInt();
				
				switch(ch) {
				case 1:
					contact.getNewFirstName();
					break;
					
				case 2:
					contact.getNewLastName();
					break;
					
				case 3:
					contact.getNewAddress();
					break;
					
				case 4:
					contact.getNewCity();
					break;
					
				case 5:
					contact.getNewState();
					break;
					
				case 6:
					contact.getNewZip();
					break;
					
				case 7:
					contact.getNewPhoneNumber();
					break;
				case 8:
					contact.getNewEmail();
					break;
					
				default:
					System.out.println("Please Enter Valid Choice!!!");	
				}
			}else {
				System.out.println("The Email You Entered Is Wrong Please Provide Right One");
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
				System.out.println("The Email You Entered Is Wrong Please Provide Right One");
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
				System.out.println("\n---Contact Found---.");
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
