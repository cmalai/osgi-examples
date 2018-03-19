package org.ancit.osgi.addressbook.consumer;

import org.ancit.osgi.addressbook.model.Contact;
import org.ancit.osgi.addressbook.service.AddressBookService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

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
		
           
            
			// Create a service tracker to monitor dictionary services.
            ServiceTracker m_tracker = new ServiceTracker(
                context,
                context.createFilter(
                    "(&(objectClass=" + AddressBookService.class.getName() + ")" +
                    "(Group=*))"),
                null);
            m_tracker.open();

            
            
            
            if(m_tracker == null) {
            	System.out.println("No Such Group Found !");
            	return;
            }
            
            AddressBookService service = (AddressBookService) m_tracker.getService(m_tracker.getServiceReference());
            Contact searchContact = service.getAddressBook().searchContact("Malai");
            
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
