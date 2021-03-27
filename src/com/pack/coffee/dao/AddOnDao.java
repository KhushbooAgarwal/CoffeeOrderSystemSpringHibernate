package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.AddOn;


public interface AddOnDao {	
	
	ArrayList<AddOn> getAllAddOn()throws ClassNotFoundException,SQLException;
	AddOn getAddOnByName(String addOnName)throws ClassNotFoundException,SQLException;
	public float getAddOnPriceByName(String name) throws ClassNotFoundException, SQLException;
	public float getAddOnPriceById(int addOnId) throws ClassNotFoundException, SQLException;
	AddOn getAddOnDetailsById(int addOnId)throws ClassNotFoundException,SQLException;
}
