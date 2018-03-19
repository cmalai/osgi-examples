package org.ancit.osgi.addressbook.model;

import java.util.HashMap;

public class AddressBook {
	
	HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	public void storeContact(Contact contact) {
		contacts.put(contact.getName(), contact);
	}
	
	public void removeContact(String name) {
		contacts.remove(name);
	}
	
	public Contact searchContact(String name) {
		return contacts.get(name);
	}
	
}
