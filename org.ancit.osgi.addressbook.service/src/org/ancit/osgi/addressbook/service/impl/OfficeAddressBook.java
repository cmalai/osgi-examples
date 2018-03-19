package org.ancit.osgi.addressbook.service.impl;

import org.ancit.osgi.addressbook.model.AddressBook;
import org.ancit.osgi.addressbook.model.Contact;
import org.ancit.osgi.addressbook.service.AddressBookService;

public class OfficeAddressBook implements AddressBookService {

	AddressBook book;
	
	@Override
	public AddressBook getAddressBook() {
		if(book == null) {
			book = new AddressBook();
			Contact contact = new Contact("Malai", "Bangalore", "abc@gmail.com", "1234567890");
			book.storeContact(contact);
		}
		return book;
	}

}
