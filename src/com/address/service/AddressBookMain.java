package com.address.service;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("------Welcome TO AddressBook------");
		AddressBookService address = new AddressBookService();
		
		while(true) {
		System.out.println("1.Add\n2.Edit\n3.Delete\n4.Find");
		System.out.print("Select Your Option: ");
		int option = scan.nextInt();
		
		switch(option) {
		case 1:
			address.getContact();
			address.display();
			break;
		case 2:
			address.edit();
			address.display();
			break;
		case 3:
			address.delete();
			address.display();
			break;
		case 4:
			address.find();
			address.display();
			break;
		}
	}
}
}
