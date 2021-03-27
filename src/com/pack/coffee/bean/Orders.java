package com.pack.coffee.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Orders {
    @Id
	@Column(name = "Order_Id")
	private int orderId;
	@Column(name = "Customer_Id")
	private int customerId;
	@Column(name = "Order_Date")
	private Date orderDate;
	
	//private int voucherID;

	public Orders(){
	}

	public Orders(int customerId, Date orderDate) {
		super();
		this.customerId = customerId;
		this.orderDate = orderDate;
		//this.voucherID = voucherID;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/*
	 * public int getVoucherID() { return voucherID; }
	 * 
	 * public void setVoucherID(int voucherID) { this.voucherID = voucherID; }
	 */
	
	
}
