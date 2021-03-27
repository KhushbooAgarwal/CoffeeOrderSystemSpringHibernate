package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.coffee.bean.Customers;
import com.pack.coffee.bean.Orders;
import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.util.MySQLConnectionManagement;
@Repository("VoucherDao")
public class VoucherDaoImpl implements VoucherDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
	
	@Override
	public ArrayList<Vouchers> getAllVouchers() throws ClassNotFoundException, SQLException {
		//For every Transaction one Session object
		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		Query<Vouchers> query=session.createQuery("from Vouchers");
		List<Vouchers> voucherList=query.getResultList();
		transaction.commit();
		session.close();
		//factory.close();
		return (ArrayList<Vouchers>) voucherList;
	}

	@Override
	public Vouchers getVoucherByVoucherName(String voucherName) throws ClassNotFoundException, SQLException {
		Vouchers vouchers = null;
         Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		  Query query2=session.createQuery("from Vouchers where Voucher_Name=:voucherName");
		  query2.setParameter("voucherName", voucherName); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  vouchers = (Vouchers) iterator.next();
		  }
		  transaction.commit();
			session.close();
			//factory.close();
		return vouchers;
	}

}
