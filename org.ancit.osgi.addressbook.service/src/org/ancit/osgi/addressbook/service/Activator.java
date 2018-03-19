package org.ancit.osgi.addressbook.service;

import java.util.Hashtable;

import org.ancit.osgi.addressbook.service.impl.OfficeAddressBook;
import org.ancit.osgi.addressbook.service.impl.RelativeAddressBook;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Group", "Office");
		context.registerService(AddressBookService.class, new OfficeAddressBook(), props);
		
		props = new Hashtable<String, String>();
        props.put("Group", "Relative");
		context.registerService(AddressBookService.class, new RelativeAddressBook(), props);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
