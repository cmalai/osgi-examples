package org.ancit.osgi.addressbook.consumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.ancit.osgi.addressbook.model.Contact;
import org.ancit.osgi.addressbook.service.AddressBookService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

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
		
            
         // Query for all service references matching any language.
            ServiceReference[] refs = context.getServiceReferences(
                AddressBookService.class.getName(), "(Group=Official)");
            
            if(refs == null) {
            	System.out.println("No Such Group Found !");
            	return;
            }
            
            AddressBookService service = (AddressBookService) context.getService(refs[0]);
            Contact searchContact = service.getAddressBook().searchContact("Anna");
            
            if(searchContact == null) {
            	System.out.println("No such contact found !");
            } else {
            	System.out.println("Contact Found !");
            }

		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
