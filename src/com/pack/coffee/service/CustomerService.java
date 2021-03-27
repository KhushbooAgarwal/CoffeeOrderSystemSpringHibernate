package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Customers;

public interface CustomerService {

	int addCustomer(String custName, long phoneNum)throws ClassNotFoundException,SQLException;
	Customers getCustomerByPhone(long phoneNum)  throws ClassNotFoundException, SQLException ;
	int checkCustomer(long phoneNum) throws ClassNotFoundException,SQLException;
	Customers getCustomerId(String custName,long phoneNum)throws ClassNotFoundException,SQLException;
	String getCustomerName(int custId) throws ClassNotFoundException, SQLException;
}

