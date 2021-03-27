package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.dao.VoucherDao;
import com.pack.coffee.dao.VoucherDaoImpl;
@Service("VoucherService")
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private VoucherDao vouchDao;
    
	public void setVouchDao(VoucherDao vouchDao) {
		this.vouchDao = vouchDao;
	}

	@Override
	public ArrayList<Vouchers> getAllVochers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vouchers getVoucherByVoucherName(String voucherName) throws ClassNotFoundException, SQLException {
		
		return vouchDao.getVoucherByVoucherName(voucherName);
	}

}
