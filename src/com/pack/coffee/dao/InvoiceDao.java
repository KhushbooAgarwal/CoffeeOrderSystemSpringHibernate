package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Invoices;

public interface InvoiceDao {
	
	int CreateInvoice(int invoiceNum,int orderId,float netValue,float gst,float serviceTax,float total,float price,float voucherAmt)throws ClassNotFoundException,SQLException;
	Invoices getInvoiceByOrderId(int orderId)throws ClassNotFoundException,SQLException;
	public int getMaxInvoiceId() throws ClassNotFoundException, SQLException;
	
	
}
