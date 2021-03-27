package com.pack.coffee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoices {
	
	@Id
	@Column(name = "Invoice_No")
	private int invoiceId;
	@Column(name = "order_ID")
	private int orderId;
	@Column(name = "Net_value")
	private float netValue;
	@Column(name = "GST")
	private float gst;
	@Column(name = "Service_Tax")
	private float serviceTax;
	@Column(name = "total")
	private float total;
	@Column(name = "Voucher_discount")
	private float voucherAmt;
	@Column(name = "Price")
	private float price;


	public Invoices(){
	}


	

	public Invoices(int invoiceId, int orderId, float netValue, float gst, float serviceTax, float total,
			float voucherAmt, float price) {
		super();
		this.invoiceId = invoiceId;
		this.orderId = orderId;
		this.netValue = netValue;
		this.gst = gst;
		this.serviceTax = serviceTax;
		this.total = total;
		this.voucherAmt = voucherAmt;
		this.price = price;
	}




	public float getPrice() {
		return price;
	}




	public void setPrice(float price) {
		this.price = price;
	}




	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public float getNetValue() {
		return netValue;
	}


	public void setNetValue(float netValue) {
		this.netValue = netValue;
	}


	public float getGst() {
		return gst;
	}


	public void setGst(float gst) {
		this.gst = gst;
	}


	public float getServiceTax() {
		return serviceTax;
	}


	public void setServiceTax(float serviceTax) {
		this.serviceTax = serviceTax;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public float getVoucherAmt() {
		return voucherAmt;
	}


	public void setVoucherAmt(float voucherAmt) {
		this.voucherAmt = voucherAmt;
	}
	

}
