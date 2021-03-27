package com.pack.coffee.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vouchers {

	@Id
	@Column(name = "Voucher_ID")
	private int voucherID;
	@Column(name = "Voucher_Name")
	private String voucherName;
	private Date voucherStatDate;
	private Date voucherEndDate;
	@Column(name = "Voucher_discount")
	private float voucherPrice;
	
public Vouchers() {		
	}

public Vouchers(int voucherID, String voucherName, Date voucherStatDate, Date voucherEndDate, float voucherPrice) {
	super();
	this.voucherID = voucherID;
	this.voucherName = voucherName;
	this.voucherStatDate = voucherStatDate;
	this.voucherEndDate = voucherEndDate;
	this.voucherPrice = voucherPrice;
}

public int getVoucherID() {
	return voucherID;
}

public void setVoucherID(int voucherID) {
	this.voucherID = voucherID;
}

public String getVoucherName() {
	return voucherName;
}

public void setVoucherName(String voucherName) {
	this.voucherName = voucherName;
}

public Date getVoucherStatDate() {
	return voucherStatDate;
}

public void setVoucherStatDate(Date voucherStatDate) {
	this.voucherStatDate = voucherStatDate;
}

public Date getVoucherEndDate() {
	return voucherEndDate;
}

public void setVoucherEndDate(Date voucherEndDate) {
	this.voucherEndDate = voucherEndDate;
}

public float getVoucherPrice() {
	return voucherPrice;
}

public void setVoucherPrice(float voucherPrice) {
	this.voucherPrice = voucherPrice;
}
	
	

}
