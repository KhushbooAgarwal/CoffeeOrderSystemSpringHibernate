package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Customers;

public interface CustomerDao {

	int addCustomer(int custId,String custName,long phoneNum)throws ClassNotFoundException,SQLException;
	Customers getCustomerByPhone(long phoneNum)throws ClassNotFoundException,SQLException;
	int getMaxCustomer() throws ClassNotFoundException,SQLException;
	int checkCustomer(long phoneNum) throws ClassNotFoundException,SQLException;
	Customers getCustomerId(String custName,long phoneNum)throws ClassNotFoundException,SQLException;
	String getCustomerName(int custId) throws ClassNotFoundException, SQLException;
}
