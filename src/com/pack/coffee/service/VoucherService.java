package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Vouchers;

public interface VoucherService {
	ArrayList<Vouchers> getAllVochers()throws ClassNotFoundException,SQLException;
	Vouchers getVoucherByVoucherName(String voucherName)  throws ClassNotFoundException, SQLException;
}

