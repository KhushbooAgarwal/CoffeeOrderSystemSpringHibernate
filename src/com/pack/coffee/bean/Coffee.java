package com.pack.coffee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coffee {
	
	@Id
	@Column(name = "Coffee_id")
	private int coffeeId;
	@Column(name = "Coffee_name")
	private String coffeeName;
	@Column(name = "Coffee_size")
	private String coffeeSize;
	@Column(name = "Coffee_Price")
	private float coffeePrice;
	
	
	public Coffee() {
		
	}


	public Coffee(int coffeeId, String coffeeName, String coffeeSize, float coffeePrice) {
		super();
		this.coffeeId = coffeeId;
		this.coffeeName = coffeeName;
		this.coffeeSize = coffeeSize;
		this.coffeePrice = coffeePrice;
	}


	public int getCoffeeId() {
		return coffeeId;
	}


	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}


	public String getCoffeeName() {
		return coffeeName;
	}


	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}


	public String getCoffeeSize() {
		return coffeeSize;
	}


	public void setCoffeeSize(String coffeeSize) {
		this.coffeeSize = coffeeSize;
	}


	public float getCoffeePrice() {
		return coffeePrice;
	}


	public void setCoffeePrice(float coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	
	
	
}
