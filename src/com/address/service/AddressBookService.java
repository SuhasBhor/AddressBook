package com.address.service;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;


import com.address.entity.AddressBookList;
import com.address.entity.Contact;

public class AddressBookService {

	Scanner scan = new Scanner(System.in);
	Contact contact;
	// ArrayList<Contact> contactBook = new ArrayList<>();
	ArrayList<AddressBookList> AddressBookNameList = new ArrayList<>();
	
	//Add Method To Add Contact in ArrayList 
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
				int zip = scan.nextInt();

				System.out.print("Enter Your Phone Number: ");
				long phoneNumber = scan.nextLong();

				contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
				
				if(checkDuplicate(book,firstName)) {
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
	
	//Check for Duplicate Contact
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
	
	//edit contact of Particular AddressBook
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
	
	/*Delete Contact from AddressBook 
		by searching with email in addressbook 
	*/
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
	
	/*find Contact from AddressBook 
	by searching with email in addressbook 
*/
	public void find() {
		System.out.println("Which AddressBook's Contact You Want To Find: ");
		String book = scan.nextLine();

		System.out.println("Enter Email Of Contact You Want To Find: ");
		String findByEmail = scan.next();
		for (AddressBookList addressBook : AddressBookNameList) {
			if (book.equals(addressBook.bookName)) {
				for (Contact contact : addressBook.contactDetails) {
					if (findByEmail.equals(contact.email)) {
						System.out.println("\n---Contact Found---.");
						break;
					} else {
						System.out.println("\n---Contact Not Found---\n");
					}
				}
			}
		}
	}
	
	//Search Contact By City Name
	public void searchByCity() {
		System.out.println("Enter City Name Whose Contact You Want: ");
		String cityName = scan.next();
		
		//Creating A Dictionary of City And Name
		Dictionary cityDictionary = new Hashtable<>();
		for (AddressBookList addressBookList : AddressBookNameList) {
			for(Contact contact : addressBookList.contactDetails) {
				if(cityName.equals(contact.city)) {
					cityDictionary.put(contact.firstName, cityName);
				}
			}
		}
		System.out.println("Contact In City "+cityName);
		for(Enumeration i = cityDictionary.keys();i.hasMoreElements();) {
			System.out.println(i.nextElement());
		}
		System.out.println(" ");
	}
	
	//Count Contact In particular City
	public void countByCity() {
		System.out.println("Enter City Name: ");
		String cityName = scan.next();
		int count = 0;
		for (AddressBookList addressBookList : AddressBookNameList) {
			for(Contact contact : addressBookList.contactDetails) {
				if(cityName.equals(contact.city)) {
					count++;
				}
			}
		}
		System.out.println("\nTotal Contact In State "+cityName+ " Are: "+count);
	}
	
	
	//Search Contact By State 
	public void searchByState() {
		System.out.println("Enter State Whose Contact You Want: ");
		String stateName = scan.next();
		
		//creating Dictionary of State and Name
		Dictionary stateDictionary = new Hashtable();
		for (AddressBookList addressBookList : AddressBookNameList) {
			for(Contact contact : addressBookList.contactDetails) {
				if(stateName.equals(contact.state)) {
					stateDictionary.put(contact.firstName, stateName);
				}
			}
		}
		System.out.println("Contact In State "+stateName);
		for(Enumeration i = stateDictionary.keys();i.hasMoreElements();) {
			System.out.println(i.nextElement());
		}
		System.out.println(" ");
	}
	
	//Count Contact In particular State
	public void countByState() {
		System.out.println("Enter City Name: ");
		String stateName = scan.next();
		int count = 0;
		for (AddressBookList addressBookList : AddressBookNameList) {
			for(Contact contact : addressBookList.contactDetails) {
				if(stateName.equals(contact.state)) {
					count++;
				}
			}
		}
		System.out.println("\nTotal Contact In State "+stateName+ " Are: "+count);
	}
	
	//Checking Unique AddressBook in ArrayList of AddressBook
	public boolean checkUniqueAddressBook(String bookName) {
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
	
	//Add AddressBook in Arraylist of AddresBook
	public void newAddressBook() {
		System.out.println("Enter Address Book Name: ");
		String bookName = scan.next();

		if (!checkUniqueAddressBook(bookName)) {
			System.out.println("This Name Address Book Already Exists");
		}

		AddressBookList obj = new AddressBookList(bookName);
		AddressBookNameList.add(obj);

		System.out.println("New Address Book Is Added: " + obj);
	}
	
	//Display AddressBook
	public void displayAddressBook() {
		System.out.println("------Address Book List------");
		for (AddressBookList addressBookName : AddressBookNameList) {
			System.out.println(addressBookName);
		}
	}
	
	//Sort Output By Name
	public void sortByName_City_Zip_State() {
		AddressBookList addressBook = findAddressBook();
		
		System.out.println("By Which Option You Want To Sort Output:\n1.Sort By Name\n2.Sort By City\n3.Sort By Zip Code"
				+ "\n4.Sort By Sate");
		int ch = scan.nextInt();
		switch(ch) {
		case 1:
			addressBook.contactDetails.stream().sorted((contact1,contact2) ->contact1.getFirstName()
					.compareTo(contact2.getFirstName())).forEach(contactDetails -> System.out.println(contactDetails));
			break;
		case 2:
			addressBook.contactDetails.stream().sorted((contact1,contact2) ->contact1.getCity()
					.compareTo(contact2.getCity())).forEach(contactDetails -> System.out.println(contactDetails));
			break;
		case 3:
			addressBook.contactDetails.stream().sorted((contact1,contact2) ->
				Integer.valueOf(contact1.getZip()).compareTo(contact2.getZip()))
				.forEach(contactDetails -> System.out.println(contactDetails));
			break;
		case 4:
			addressBook.contactDetails.stream().sorted((contact1,contact2) ->contact1.getState()
					.compareTo(contact2.getState())).forEach(contactDetails -> System.out.println(contactDetails));
			break;
		}
	}
	
	//finding AddressBook In Address Book ArrayList
	public AddressBookList findAddressBook() {
		if(AddressBookNameList.isEmpty()) {
			System.out.println("Add AddressBook In Address Book List");
			return null;
		}
		System.out.println("Enter Address Book Name: ");
		String addressBookName = scan.next();
		
		for (AddressBookList addressBookList : AddressBookNameList) {
			if (addressBookName.equals(addressBookList.bookName)) {
				return addressBookList;
			}
		}
		System.out.println("This Name Address Book Is Not Exists");
		return null;
		
	}
}
