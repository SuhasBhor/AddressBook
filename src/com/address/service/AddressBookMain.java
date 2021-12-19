package com.address.service;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("------Welcome TO AddressBook------");
		AddressBookService address = new AddressBookService();

		while (true) {
			System.out.println("1.Add\n2.Edit\n3.Delete\n4.Find\n5.Add AddressBook\n6.Display AddressBook List\n7.Search Contact By City+"
					+ "\n8.Search Contact By State\n9.Count Contact In City\n10.Count Contact In State\n11.Sort By Name_City_Zip_State\n12.Write Into File"
					+ "\n13.Read From File");
			System.out.print("Select Your Option: ");
			int option = scan.nextInt();

			switch (option) {
			case 1:
				address.getContact();
				break;
			case 2:
				address.edit();
				break;
			case 3:
				address.delete();
				break;
			case 4:
				address.find();
				break;
			case 5:
				address.newAddressBook();
				break;
			case 6:
				address.displayAddressBook();
				break;
			case 7:
				address.searchByCity();
				break;
			case 8:
				address.searchByState();
				break;
			case 9:
				address.countByCity();
				break;
			case 10:
				address.countByState();
				break;
			case 11:
				address.sortByName_City_Zip_State();
				break;
			case 12:
				address.writeContactIntoFile();
				break;
			case 13:
				try {
					address.readFromFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Enter Option Between 1 To 10");
			}
		}
	}
}
