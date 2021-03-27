package com.pack.coffee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddOn {

	@Id
	@Column(name = "AddOn_ID")
	private int addOnID;
	@Column(name = "AddOn_Name")
	private String addOnName;
	@Column(name = "AddOn_Price")
	private float addOnPrice;
	
public AddOn() {
		
	}

public AddOn(int addOnID, String addOnName, float addOnPrice) {
	super();
	this.addOnID = addOnID;
	this.addOnName = addOnName;
	this.addOnPrice = addOnPrice;
}

public int getAddOnID() {
	return addOnID;
}

public void setAddOnID(int addOnID) {
	this.addOnID = addOnID;
}

public String getAddOnName() {
	return addOnName;
}

public void setAddOnName(String addOnName) {
	this.addOnName = addOnName;
}

public float getAddOnPrice() {
	return addOnPrice;
}

public void setAddOnPrice(float addOnPrice) {
	this.addOnPrice = addOnPrice;
}



}
