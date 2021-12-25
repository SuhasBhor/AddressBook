package com.address.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.address.entity.AddressBookList;
import com.address.entity.Contact;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class AddressBookIO {
	AddressBookService addressBookService = new AddressBookService();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// txt File path
	File file = new File("F:/BridgelabzClass/AddressBook/src/com/address/AddressBook.txt");

	// CSV File Path
	File csvFile = new File("F:/BridgelabzClass/AddressBook/src/com/address/AddressBookCSV.csv");
	
	//GSON File Path
	File gsonFile = new File("F:/BridgelabzClass/AddressBook/src/com/address/AddressBookGSON.json");
	
	// Write into File
	public void writeContactIntoFile() {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			String stringAddressBook = addressBookService.AddressBookNameList.toString();

			for (int i = 0; i < stringAddressBook.length(); i++) {
				fileWriter.write(stringAddressBook.charAt(i));
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n----Data Insert Into File----\n");
	}

	// Read data of txt File
	public void readFromFile() throws IOException {
		System.out.println("\n----Reading Data From File----\n");
		int line;
		FileReader fileReader = new FileReader(file);
		while ((line = fileReader.read()) != -1) {
			System.out.print((char) line);
		}
		fileReader.close();
	}

	// Add Contact into CSv File
	public void writeIntoCSVFile() throws IOException {
		try {
			FileWriter outputFile = new FileWriter(csvFile);
			CSVWriter csvWriter = new CSVWriter(outputFile);
			
			for (AddressBookList addressBookList :  addressBookService.AddressBookNameList) {
				for(Contact person : addressBookList.contactDetails) {
					String[] contact = {addressBookList.getBookName(),
							person.getFirstName(),
							person.getLastName(),
							person.getAddress(),
							person.getCity(),
							person.getState(),
							String.valueOf(person.getZip()),
							String.valueOf(person.getPhoneNumber()),
							person.getEmail()+"\n"};
					csvWriter.writeNext(contact);
				}
			}
			csvWriter.close();
			System.out.println("\n----Data Added To CSV File---\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Read Contact from CSV File
	public void readFromCSVFile() throws IOException {
		FileReader fileReader = new FileReader(csvFile);
		CSVReader csvReader = new CSVReader(fileReader);
		System.out.println("\n----Reading From CSVFile----\n");
		String[] contact;
		try {
			while ((contact = csvReader.readNext()) != null) {
				Contact newContact = new Contact(contact[1], contact[2], contact[3], contact[4], contact[5],
						Integer.valueOf(contact[6]), Integer.valueOf(contact[7]), contact[8]);

				System.out.println(newContact);
			}
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Write contact into Gson File
	public void writeIntoJSONFile() throws IOException {
		String output = gson.toJson(addressBookService.AddressBookNameList);
		FileWriter fileWriter = new FileWriter(gsonFile);
		fileWriter.write(output);
		fileWriter.close();

		System.out.println("\\n----Data Insert Into JSON File----\\n");
	}


	// Read Contact From Gson File
	public void readFromJSONFile() throws IOException {
		System.out.println("\n----Reading From JSONFile----\n");
		FileReader fileReader = new FileReader(gsonFile);
		Object temp = gson.fromJson(fileReader, Object.class);
		System.out.println(temp);
	}
}
