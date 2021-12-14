package com.address.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.address.entity.AddressBookList;
import com.address.entity.Contact;

public class AddressBookService {

	Scanner scan = new Scanner(System.in);
	Contact contact;
	// ArrayList<Contact> contactBook = new ArrayList<>();
	ArrayList<AddressBookList> AddressBookNameList = new ArrayList<>();

	public void getContact() {
		if (AddressBookNameList.isEmpty()) {
			System.out.println("\n---Add Address Book First---\n");
			return;
		} else {
			System.out.println("Which Address Book You Want To Fill: ");
			String book = scan.next();

			System.out.println("How Many Contact You Want To Add: ");
			int n = scan.nextInt();

			for (int i = 0; i < n; i++) {
				System.out.print("Enter Your First Name: ");
				String firstName = scan.next();

				System.out.print("Enter Your Last Name: ");
				String lastName = scan.next();

				System.out.print("Enter Your Address: ");
				String address = scan.next();

				System.out.print("Enter Your City Name: ");
				String city = scan.next();

				System.out.print("Enter Your State: ");
				String state = scan.next();

				System.out.print("Enter Your Email ID: ");
				String email = scan.next();

				System.out.print("Enter Your Zip-Code: ");
				long zip = scan.nextLong();

				System.out.print("Enter Your Phone Number: ");
				long phoneNumber = scan.nextLong();

				contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
				
				if(checkDuplicate(book,firstName)) {
				//AddressBookNameList.stream().filter(find -> find.bookName.contains(book))
				//		.forEach(addressBook -> addressBook.contactDetails.add(contact));
					for (AddressBookList addressBook : AddressBookNameList) {
						if (addressBook.bookName.contains(book)) {
							addressBook.contactDetails.add(contact);
							for (Contact contact : addressBook.contactDetails) {
								
							}
						}
					}
					System.out.println("\nContact Added Successfully\n");
				}else {
					System.out.println("This Person "+ firstName +" Already Exists");
					return;
				}
			}
		}
	}
	
	public boolean checkDuplicate(String book , String firstName) {
		for (AddressBookList addressBook : AddressBookNameList) {
			if (book.equals(addressBook.bookName)) {
				for (Contact contact : addressBook.contactDetails) {
					if (firstName.equals(contact.firstName)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void edit() {
		System.out.println("Which AddressBook's Contact You Want To Edit: ");
		String book = scan.nextLine();

		System.out.println("Enter Email Of Contact You Want To Edit: ");
		String email = scan.next();
		for (AddressBookList addressBook : AddressBookNameList) {
			if (book.equals(addressBook.bookName)) {
				for (Contact contact : addressBook.contactDetails) {
					if (email.equals(contact.email)) {
						System.out.println(
								"Select Option: \n1.FirstName\n2.LastName\n3.Address\n4.City\n5.State\n6.ZipCode\n7.PhoneNumber\n8Email;");
						int ch = scan.nextInt();

						switch (ch) {
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
					} else {
						System.out.println("The Email You Entered Is Wrong Please Provide Right One");
						continue;
					}
				}
			}
		}
	}

	public void delete() {
		System.out.println("Which AddressBook's Contact You Want To Delete: ");
		String book = scan.nextLine();

		System.out.println("Enter Email Of Contact You Want To Delete: ");
		String deleteByEmail = scan.next();
		for (AddressBookList addressBook : AddressBookNameList) {
			if (book.equals(addressBook.bookName)) {
				for (Contact contact : addressBook.contactDetails) {
					if (deleteByEmail.equals(contact.email)) {
						addressBook.contactDetails.remove(contact);
						System.out.println("\nSelected contact deleted successfully.");
						break;
					} else {
						System.out.println("The Email You Entered Is Wrong Please Provide Right One");
						continue;
					}
				}
			}
		}
	}

	public void find() {
		System.out.println("Which AddressBook's Contact You Want To Find: ");
		String book = scan.nextLine();

		System.out.println("Enter Email Of Contact You Want To Find: ");
		String deleteByEmail = scan.next();
		for (AddressBookList addressBook : AddressBookNameList) {
			if (book.equals(addressBook.bookName)) {
				for (Contact contact : addressBook.contactDetails) {
					if (deleteByEmail.equals(contact.email)) {
						System.out.println("\n---Contact Found---.");
						break;
					} else {
						System.out.println("\n---Contact Not Found---\n");
					}
				}
			}
		}
	}

	public boolean findAddressBook(String bookName) {
		if (AddressBookNameList.isEmpty()) {
			return true;
		}
		for (int i = 0; i < AddressBookNameList.size(); i++) {
			if (AddressBookNameList.get(i).bookName.equals(bookName)) {
				return false;
			}
		}

		return true;
	}

	public void newAddressBook() {
		System.out.println("Enter Address Book Name: ");
		String bookName = scan.next();

		if (!findAddressBook(bookName)) {
			System.out.println("This Name Address Book Already Exists");
		}

		AddressBookList obj = new AddressBookList(bookName);
		AddressBookNameList.add(obj);

		System.out.println("New Address Book Is Added: " + obj);
	}

	public void displayAddressBook() {
		System.out.println("------Address Book List------");
		for (AddressBookList addressBookName : AddressBookNameList) {
			System.out.println(addressBookName);
		}
	}
}
