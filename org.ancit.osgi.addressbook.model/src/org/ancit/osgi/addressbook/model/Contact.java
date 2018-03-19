package org.ancit.osgi.addressbook.model;

public class Contact {
	
	private String name;
	private String address;
	private String emailid;
	private String mobileno;
	
	public Contact(String name, String address, String emailid, String mobileno) {
		super();
		this.name = name;
		this.address = address;
		this.emailid = emailid;
		this.mobileno = mobileno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	

}
