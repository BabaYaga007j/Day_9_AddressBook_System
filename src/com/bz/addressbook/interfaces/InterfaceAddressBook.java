package com.bz.addressbook.interfaces;

import com.bz.addressbook.model.Contacts;

public interface InterfaceAddressBook 
{
	int createContacts(Contacts contacts);
	void showAllContacts();//Showing Contacts method
	void updateContacts(String firstName);
	void deleteContacts(String firstName);
	

	
}
