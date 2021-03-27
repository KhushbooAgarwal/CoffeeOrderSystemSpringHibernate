package com.pack.coffee.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Customers;
import com.pack.coffee.bean.Invoices;
import com.pack.coffee.bean.Orders;
import com.pack.coffee.dao.OrderDao;
import com.pack.coffee.dao.OrderDaoImpl;
import com.pack.coffee.dao.OrderTransactionDao;
import com.pack.coffee.dao.OrderTransactionDaoImpl;
@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderTransactionDao orderTDao;
    

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void setOrderTDao(OrderTransactionDao orderTDao) {
		this.orderTDao = orderTDao;
	}
	@Override
	public Orders getOrderByCustid(int customerId) throws ClassNotFoundException,SQLException {
		return orderDao.getOrderByCustid(customerId);	
		
	}
	@Override
	public int CreateOrder(int customerId, String orderDate, int voucherId)
			throws ClassNotFoundException, SQLException {		
		
			int orderId=0;
			orderId = orderDao.getMaxOrderId();
			orderId = orderId+1;
			orderDao.CreateOrder(orderId,customerId, orderDate, voucherId);	
		
		return orderId;
	}

}
