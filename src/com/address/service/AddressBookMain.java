package com.address.service;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("------Welcome TO AddressBook------");
		AddressBookService address = new AddressBookService();
		AddressBookIO addressBookIO = new AddressBookIO();
		AddressBookSerachSort addressBookSerachSort = new AddressBookSerachSort();


		while (true) {
			System.out.println(
					"1.Add\n2.Edit\n3.Delete\n4.Find\n5.Add AddressBook\n6.Display AddressBook List\n7.Search Contact By City+"
							+ "\n8.Search Contact By State\n9.Count Contact In City\n10.Count Contact In State\n11.Sort By Name_City_Zip_State\n12.Write Into File"
							+ "\n13.Read From File\n14.Write Into CSVFile\n15.Read From CSVFile\n16.Write Into GSON File\n17.Read From GSON File");
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
				addressBookSerachSort.searchByCity();
				break;
			case 8:
				addressBookSerachSort.searchByState();
				break;
			case 9:
				addressBookSerachSort.countByCity();
				break;
			case 10:
				addressBookSerachSort.countByState();
				break;
			case 11:
				addressBookSerachSort.sortByName_City_Zip_State();
				break;
			case 12:
				addressBookIO.writeContactIntoFile();
				break;
			case 13:
				try {
					addressBookIO.readFromFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 14:
				addressBookIO.writeIntoCSVFile();
				break;
			case 15:
				addressBookIO.readFromCSVFile();
				break;
			case 16:
				addressBookIO.writeIntoJSONFile();
				break;
			case 17:
				addressBookIO.readFromJSONFile();
				break;
			default:
				System.out.println("Enter Option Between 1 To 17");

			}
		}
	}
}