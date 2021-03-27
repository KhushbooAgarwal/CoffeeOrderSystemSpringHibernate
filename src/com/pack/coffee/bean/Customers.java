package com.pack.coffee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {

	    @Id
	    @Column(name = "customer_id")
		private int customerID;
	    @Column(name = "customer_name")
		private String customerName;
	    @Column(name = "phone_number")
		private long phoneNumber;
		
	public Customers() {		
		}

	public Customers(String customerName, long phoneNumber) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}

