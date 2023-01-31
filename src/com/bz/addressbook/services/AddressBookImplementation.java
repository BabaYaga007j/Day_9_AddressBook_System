package com.bz.addressbook.services;

import java.util.Scanner;

import com.bz.addressbook.interfaces.InterfaceAddressBook;
import com.bz.addressbook.model.Contacts;

public class AddressBookImplementation implements InterfaceAddressBook

{
	
	private static Contacts[] contactsOfPersons= new Contacts[15];//for array decaration
	private static Scanner getUserInput= new Scanner(System.in);//for user input

	public int createContacts(Contacts contacts) 
	{
		System.out.println("List Of Files");
		System.out.println(contacts);
		int index = getIndexFornextEmptyLocation();
		System.out.println("Index :: "+index);
		contactsOfPersons[index]=contacts;
		return index;
	}

	private int getIndexFornextEmptyLocation()
	{
		for (int i=0;i<contactsOfPersons.length;i++)
		{								
			if (null==contactsOfPersons[i])
			{
				return i;
			}
		}
		return 0;
	}

	public void showAllContacts() {

		System.out.println("Showing contacts details");
		
		for (int i=0;i<contactsOfPersons.length;i++)
		{								
			showContactDetails(contactsOfPersons[i]); 
		}
	}
	
	public void updateContacts(String firstName) {
		
		int i= findByFirstName(firstName);
		if (i!=-1)
		{
			editContactDetails(contactsOfPersons[i]);
		}
		showAllContacts();
		
		
	}
	public void deleteContacts(String firstName) {
		int i= findByFirstName(firstName);
		if (i!=-1)
		{
			contactsOfPersons[i]=null;
		}
		else
		{
			System.out.println("Name Not Found");
		}
		showAllContacts();
		
	}
	private void editContactDetails( Contacts contacts) {
		Contacts con = new Contacts();
		
		byte loopExit = 1; 
			do {
				System.out.println("Choose Option to Update :: " + '\n' + " 1.FirstName " + '\n' + " 2.LastName " + '\n' + " 3.Address "
						+ '\n' + " 4.City " + '\n' + " 5.State " + '\n' + " 6.Zip " + '\n'
								+ " 7.PhoneNumber " + '\n' + " 8.Aadhar_Number " + '\n' + " 9.Email_ID ");
				byte option = getUserInput.nextByte();
				
				switch(option) {
				case 1:
						System.out.println(" FirstName :: "); 
						contacts.setFirstName(getUserInput.next());
					break;
				case 2:
						System.out.println(" LastName :: ");
						contacts.setLastName(getUserInput.next());
					break;
				case 3:
						System.out.println(" PhoneNumber :: ");
						contacts.setPhoneNumber(getUserInput.nextLong());
						
					break;
				case 4:
					System.out.println(" Email_ID :: ");
					contacts.setEmail(getUserInput.next());
				break;
				case 5:
					System.out.println(" Address :: ");
					con.setAddress(getUserInput.next());
						
					break;
				case 6:
						System.out.println(" City :: ");
						contacts.setCity(getUserInput.next());
					break;
				case 7:
						System.out.println(" State :: ");
						contacts.setState(getUserInput.next());
					break;
				case 8:
						System.out.println(" Zip :: ");
						contacts.setZip(getUserInput.nextInt());
					break;
				
					
				
				default:
					System.out.println(" ****---- Invalid Input ----**** ");
				}
				System.out.println(" Press 1: If you want to update anything else " + '\n' + " Press 0: Exit to Menu ");
				loopExit = getUserInput.nextByte();
			}while(loopExit != 0);
		}

	
	
	
	private void showContactDetails(Contacts contacts)
	{
		if(contacts != null) 
		{
		System.out.println(">>>>>Contact Details<<<<<");
		System.out.println("First Name = "+contacts.getFirstName());
		System.out.println("Last Name = "+contacts.getLastName());
		System.out.println("Phone Number = "+contacts.getPhoneNumber());
		System.out.println("Email Id = "+contacts.getEmail());
		System.out.println("Adress = "+contacts.getAddress());
		System.out.println("City = "+contacts.getCity());
		System.out.println("State = "+contacts.getState());
		System.out.println("ZipCode = "+contacts.getZip());
		
		}
	}
	private int findByFirstName(String firstName)
	{
		
		for (int i=0;i<contactsOfPersons.length;i++)
		{								
			Contacts contacts= contactsOfPersons[i];
			if(null!=contacts && firstName.equalsIgnoreCase(contacts.getFirstName()))
			{
				return i;
			}
		}
		return -1;
		
		
	}

	

	
}
