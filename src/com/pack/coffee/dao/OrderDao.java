package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pack.coffee.bean.Orders;

public interface OrderDao {
	
	int CreateOrder(int orderId,int customerId,String orderDate,int voucherId)throws ClassNotFoundException,SQLException;
	Orders getOrderByCustid(int customerId)throws ClassNotFoundException,SQLException;
	public int getMaxOrderId() throws ClassNotFoundException, SQLException;
	public boolean isOrderIsPresent(int orderId) throws ClassNotFoundException, SQLException;
}
