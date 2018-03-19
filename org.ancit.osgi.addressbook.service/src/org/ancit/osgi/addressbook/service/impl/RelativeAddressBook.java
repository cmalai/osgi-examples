package org.ancit.osgi.addressbook.service.impl;

import org.ancit.osgi.addressbook.model.AddressBook;
import org.ancit.osgi.addressbook.model.Contact;
import org.ancit.osgi.addressbook.service.AddressBookService;

public class RelativeAddressBook implements AddressBookService {

	AddressBook book;
	
	@Override
	public AddressBook getAddressBook() {
		if(book == null) {
			book = new AddressBook();
			Contact contact = new Contact("Anna", "Chennai", "abc@gmail.com", "0987654321");
			book.storeContact(contact);
		}
		return book;
	}

}
