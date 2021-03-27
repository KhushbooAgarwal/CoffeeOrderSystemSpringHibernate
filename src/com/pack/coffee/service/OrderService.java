package com.pack.coffee.service;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Orders;



public interface OrderService {
	
	int CreateOrder(int customerId,String orderDate,int voucherId)throws ClassNotFoundException,SQLException;
	Orders getOrderByCustid(int customerId) throws ClassNotFoundException,SQLException;

}
