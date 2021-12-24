package com.address.entity;

import java.util.ArrayList;

public class AddressBookList {
	public String bookName;
	public ArrayList<Contact> contactDetails;

	public AddressBookList(String bookName) {
		this.bookName = bookName;
		this.contactDetails = new ArrayList<Contact>();
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/*
	 * @Override public String toString() { return "AddressBook Name: " + bookName +
	 * "\ncontacts:-" + contactDetails; }
	 */

}
