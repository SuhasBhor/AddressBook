package com.address.service;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("------Welcome TO AddressBook------");
		AddressBookService address = new AddressBookService();
		
		System.out.println("1.Add\n2.Edit\n3.Delete");
		System.out.print("Select Your Option: ");
		int option = scan.nextInt();
		
		switch(option) {
		case 1:
			address.getContact();
			address.display();
		case 2:
			address.edit();
			address.display();
		case 3:
			address.delete();
			address.display();
		}
	}
}
