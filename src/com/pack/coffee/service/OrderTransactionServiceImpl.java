package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.OrderTransaction;
import com.pack.coffee.dao.OrderTransactionDao;
import com.pack.coffee.dao.OrderTransactionDaoImpl;
@Service("OrderTransactionService")
public class OrderTransactionServiceImpl implements OrderTransactionService {
	@Autowired
	private OrderTransactionDao orderTran;
	@Autowired
	private CoffeeService coffServ;
	@Autowired
	private AddOnService addOnServ;
	
	public void setOrderTran(OrderTransactionDao orderTran) {
		this.orderTran = orderTran;
	}

	public void setCoffServ(CoffeeService coffServ) {
		this.coffServ = coffServ;
	}

	public void setAddOnServ(AddOnService addOnServ) {
		this.addOnServ = addOnServ;
	}

	int addOnId =0,coffeeId=0;
	@Override
	public int createOrderTran(int orderId, String coffeeName, String coffeeSize,String addOnName)
			throws ClassNotFoundException, SQLException {
		
		
		Coffee coffe = coffServ.getCoffeeByNameAndSize(coffeeName, coffeeSize);	
	
		AddOn addOn = addOnServ.getAddOnByName(addOnName);
		
		coffeeId = coffe.getCoffeeId();
		if(addOn!=null)
		addOnId =  addOn.getAddOnID();
		
	//	System.out.println(coffeeId +"|"+ addOnId);
		
		int orderTId=0;
		orderTId = orderTran.getMaxOrderTranId();
		orderTId = orderTId+1;
		//System.out.println("+++++++++++++++++++++++++++" + orderTId);
		//System.out.println("+++++++++++++++++++++++++++" + orderId);
		orderTran.createOrderTran(orderTId,orderId, coffeeId, addOnId);
		return orderId;
	}

	@Override
	public ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId) throws ClassNotFoundException, SQLException  {
	
		return orderTran.getOrderTranByOrderID(orderId);
		/*
		ArrayList<OrderTransaction> orderTList = new ArrayList<OrderTransaction>();
		
		for(OrderTransaction orderlist : orderTList) {
		
				coffee = coffServ.getCoffeeDetailsById(orderlist.getCoffeeId());
				
			}
		return orderTList;
		*/
	}

	@Override
	public ArrayList<Integer> getCoffeeIdByOrderID(int orderId) throws ClassNotFoundException, SQLException {
		return orderTran.getCoffeeIdByOrderID(orderId);
	}

	@Override
	public ArrayList<Integer> getAddOnIdByOrderID(int orderId) throws ClassNotFoundException, SQLException {
		return orderTran.getAddOnIdByOrderID(orderId);
	}
	
	

}
