package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.pack.coffee.bean.Vouchers;

public interface VoucherDao {

	ArrayList<Vouchers> getAllVouchers()throws ClassNotFoundException,SQLException;
	Vouchers getVoucherByVoucherName(String voucherName)throws ClassNotFoundException,SQLException;
	
}
