package com.bz.addressbook.services;

import java.util.Scanner;

import com.bz.addressbook.interfaces.InterfaceAddressBook;
import com.bz.addressbook.model.Contacts;

public class AddressBookImplementation implements InterfaceAddressBook

{
	
	private static Contacts[] contactsOfPersons= new Contacts[15];
	private static Scanner getUserInput= new Scanner(System.in);

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
			System.out.println(contactsOfPersons[i]);
		}
	
	}
}
