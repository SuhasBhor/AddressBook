package com.address.entity;

import java.util.ArrayList;

public class AddressBookList {
	public String bookName;
	public ArrayList<Contact> contactDetails;

	public AddressBookList(String bookName) {
		this.bookName = bookName;
		this.contactDetails = new ArrayList<Contact>();
	}
	
	public ArrayList<Contact> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ArrayList<Contact> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override 
	public String toString() { 
		return "AddressBook Name: " + bookName + "\n"
							+"contacts:-" + contactDetails; 
		}
}
