package com.bz.addressbook.controller;

import java.util.Scanner;

import com.bz.addressbook.interfaces.InterfaceAddressBook;
import com.bz.addressbook.model.Contacts;
import com.bz.addressbook.services.AddressBookImplementation;

public class AddressBookMain {
	
	
	private static Scanner getUserInput= new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		InterfaceAddressBook adressBook=new AddressBookImplementation();
		
		byte menueChoice=0;
		
		do {
			System.out.println("  ::>>>Adress Book<<<::  ");
			System.out.println("1.Add New Contcat");
			System.out.println("2.View All Contacts");
			
			byte userChoice=getUserInput.nextByte();
			switch (userChoice) 
			{ 
			case 1:
				System.out.println("Creating Contact...");
				Contacts contacts=getContacts();
				int index1=adressBook.createContacts(contacts);
				System.out.println("contacts id :: "+index1);
				break;
			case 2:
				adressBook.showAllContacts();
				
				break;
			default:
				System.out.println("Invalid Choice");
			}
			System.out.println("Press 1 to continue "+'\n'+"Press any number to exit");
			menueChoice=getUserInput.nextByte();
			

		} while (menueChoice==1);
		
		
	}
	 private static Contacts getContacts()
	 {
		 Contacts contacts= new Contacts();
		 System.out.println("Enter First Name");
		 String firstName =getUserInput.next();
		 contacts.setFirstName(firstName);
		 
		 System.out.println("Enter Last Name");
		 String lastName =getUserInput.next();
		 contacts.setLastName(lastName);
		 
		 System.out.println("Enter PhoneNumber");
		 long phoneNumber =getUserInput.nextLong();
		 contacts.setPhoneNumber(phoneNumber);
		 
		 System.out.println("Enter EmailId");
		 String email =getUserInput.next();
		 contacts.setEmail(email);
		 
		 System.out.println("Enter Adress");
		 String adress =getUserInput.next();
		 contacts.setAddress(adress);
		 
		 System.out.println("Enter City");
		 String city =getUserInput.next();
		 contacts.setCity(city);
		 
		 System.out.println("Enter State");
		 String state =getUserInput.next();
		 contacts.setState(state);
		 
		 System.out.println("Enter Zipcode");
		 int zip =getUserInput.nextInt();
		 contacts.setZip(zip);
		 
		 
		 return contacts;
		  
	 }

}
