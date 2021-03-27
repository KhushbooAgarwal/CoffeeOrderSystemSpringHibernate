package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.dao.AddOnDao;
import com.pack.coffee.dao.AddOnDaoImpl;
import com.pack.coffee.dao.CoffeeDao;
import com.pack.coffee.dao.CoffeeDaoImpl;
@Service("AddOnService")
public class AddOnServiceImpl implements AddOnService {
	@Autowired
	private AddOnDao addOnDao;
	

	public void setAddOnDao(AddOnDao addOnDao) {
		this.addOnDao = addOnDao;
	}


	@Override
	public ArrayList<AddOn> getAllAddOn() throws ClassNotFoundException, SQLException {
		return addOnDao.getAllAddOn();
	}

	
	@Override
	public AddOn getAddOnByName(String addOnName) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnByName(addOnName);
	}

	@Override
	public float getAddOnPriceByName(String name) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnPriceByName(name);
	}


	@Override
	public float getAddOnPriceById(int addOnId) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnPriceById(addOnId);
	
	}


	@Override
	public AddOn getAddOnDetailsById(int addOnId) throws ClassNotFoundException, SQLException {
		return addOnDao.getAddOnDetailsById(addOnId);
	}

}
