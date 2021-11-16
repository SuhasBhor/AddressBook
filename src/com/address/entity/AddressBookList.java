package com.address.entity;

public class AddressBookList {
	String bookName;

	public AddressBookList(String bookName) {
		super();
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "AddressBook Name: " + bookName + "]";
	}
	
	
}
