package com.address.service;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import com.address.entity.AddressBookList;
import com.address.entity.Contact;

public class AddressBookSerachSort {
	AddressBookService addressBookService = new AddressBookService();
	Scanner scan = new Scanner(System.in);

	// Search Contact By City Name
	public void searchByCity() {
		System.out.println("Enter City Name Whose Contact You Want: ");
		String cityName = scan.next();

		// Creating A Dictionary of City And Name
		Dictionary cityDictionary = new Hashtable<>();
		for (AddressBookList addressBookList : addressBookService.AddressBookNameList) {
			for (Contact contact : addressBookList.contactDetails) {
				if (cityName.equals(contact.city)) {
					cityDictionary.put(contact.firstName, cityName);
				}
			}
		}
		System.out.println("Contact In City " + cityName);
		for (Enumeration i = cityDictionary.keys(); i.hasMoreElements();) {
			System.out.println(i.nextElement());
		}
		System.out.println(" ");
	}

	// Count Contact In particular City
	public void countByCity() {
		System.out.println("Enter City Name: ");
		String cityName = scan.next();
		int count = 0;
		for (AddressBookList addressBookList : addressBookService.AddressBookNameList) {
			for (Contact contact : addressBookList.contactDetails) {
				if (cityName.equals(contact.city)) {
					count++;
				}
			}
		}
		System.out.println("\nTotal Contact In State " + cityName + " Are: " + count);
	}

	// Search Contact By State
	public void searchByState() {
		System.out.println("Enter State Whose Contact You Want: ");
		String stateName = scan.next();

		// creating Dictionary of State and Name
		Dictionary stateDictionary = new Hashtable();
		for (AddressBookList addressBookList : addressBookService.AddressBookNameList) {
			for (Contact contact : addressBookList.contactDetails) {
				if (stateName.equals(contact.state)) {
					stateDictionary.put(contact.firstName, stateName);
				}
			}
		}
		System.out.println("Contact In State " + stateName);
		for (Enumeration i = stateDictionary.keys(); i.hasMoreElements();) {
			System.out.println(i.nextElement());
		}
		System.out.println(" ");
	}

	// Count Contact In particular State
	public void countByState() {
		System.out.println("Enter City Name: ");
		String stateName = scan.next();
		int count = 0;
		for (AddressBookList addressBookList : addressBookService.AddressBookNameList) {
			for (Contact contact : addressBookList.contactDetails) {
				if (stateName.equals(contact.state)) {
					count++;
				}
			}
		}
		System.out.println("\nTotal Contact In State " + stateName + " Are: " + count);
	}

	// Sort Output By Name
	public void sortByName_City_Zip_State() {
		AddressBookList addressBook = addressBookService.findAddressBook();

		System.out
				.println("By Which Option You Want To Sort Output:\n1.Sort By Name\n2.Sort By City\n3.Sort By Zip Code"
						+ "\n4.Sort By Sate");
		int ch = scan.nextInt();
		switch (ch) {
		case 1:
			addressBook.contactDetails.stream()
					.sorted((contact1, contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
					.forEach(contactDetails -> System.out.println(contactDetails));
			break;
		case 2:
			addressBook.contactDetails.stream()
					.sorted((contact1, contact2) -> contact1.getCity().compareTo(contact2.getCity()))
					.forEach(contactDetails -> System.out.println(contactDetails));
			break;
		case 3:
			addressBook.contactDetails.stream()
					.sorted((contact1, contact2) -> Integer.valueOf(contact1.getZip()).compareTo(contact2.getZip()))
					.forEach(contactDetails -> System.out.println(contactDetails));
			break;
		case 4:
			addressBook.contactDetails.stream()
					.sorted((contact1, contact2) -> contact1.getState().compareTo(contact2.getState()))
					.forEach(contactDetails -> System.out.println(contactDetails));
			break;
		}
	}
}
