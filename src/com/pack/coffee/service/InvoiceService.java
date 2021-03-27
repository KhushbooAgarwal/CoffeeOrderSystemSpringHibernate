package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Invoices;

public interface InvoiceService {
	
	int createInvoice(int orderId,String  voucherName,String coffeeName,String coffeeSize ,String addOnName)throws ClassNotFoundException,SQLException;
	Invoices getInvoiceByOrderId(int orderId) throws ClassNotFoundException,SQLException;
	public void showInvoice(int orderId,int customerId) throws ClassNotFoundException,SQLException;

}
