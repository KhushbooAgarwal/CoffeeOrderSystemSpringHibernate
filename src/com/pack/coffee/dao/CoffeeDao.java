package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Coffee;

public interface CoffeeDao {	
	
	ArrayList<Coffee> getAllCoffeeDetails()throws ClassNotFoundException,SQLException;
	ArrayList<String> getAllCoffeeNameDetails()throws ClassNotFoundException,SQLException;
	ArrayList<String> getAllCoffeeSize()throws ClassNotFoundException,SQLException;
	Coffee getCoffeeByNameAndSize(String coffeeName , String coffeeSize)throws ClassNotFoundException,SQLException;
	public float getPriceByCoffeeId(int coffeeId) throws ClassNotFoundException,SQLException;
	Coffee getCoffeeDetailsById(int coffeeId)throws ClassNotFoundException,SQLException;
}
