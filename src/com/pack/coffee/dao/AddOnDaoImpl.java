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

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.util.MySQLConnectionManagement;
@Repository("AddOnDao")
public class AddOnDaoImpl implements AddOnDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}

	@Override
	public ArrayList<AddOn> getAllAddOn() throws ClassNotFoundException, SQLException {
        Session session=sessionFactory.openSession();		
		Transaction transaction=session.beginTransaction();
		Query<AddOn> query=session.createQuery("from AddOn");
		List<AddOn> addOnList=query.getResultList();
		transaction.commit();
		session.close();
		//factory.close();
		return (ArrayList<AddOn>) addOnList;
		
	}
	

	
	@Override
	public AddOn getAddOnByName(String addOnName) throws ClassNotFoundException, SQLException {
		AddOn addOn = null;
        Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		  Query query2=session.createQuery("from AddOn where AddOn_Name=:addOnName");
		  query2.setParameter("addOnName", addOnName); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  addOn = (AddOn) iterator.next();
		  }
		  transaction.commit();
			session.close();
			//factory.close();
		return addOn;
		
	}

	@Override
	public float getAddOnPriceByName(String name) throws ClassNotFoundException, SQLException {
		AddOn addOn = null;
		float price= 0f;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
		  Query query2=session.createQuery("SELECT addOnPrice FROM AddOn WHERE AddOn_Name=:name");
		  query2.setParameter("name", name); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  addOn = (AddOn) iterator.next();
			  price = addOn.getAddOnPrice();
			  }
		  transaction.commit();
			session.close();
		return price;
	
	}

	@Override
	public float getAddOnPriceById(int addOnId) throws ClassNotFoundException, SQLException {
		AddOn addOn = null;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Float price =0f;
		
		Query<Float> query = session.createQuery("select addOnPrice from AddOn where addOn_ID=:aId");
		query.setParameter("aId", addOnId);
		
		price =query.getSingleResult();
		transaction.commit();
		session.close();
		

		return price;  
	
	}



	@Override
	public AddOn getAddOnDetailsById(int addOnId) throws ClassNotFoundException, SQLException {
		AddOn addOn = null;
        Session session=sessionFactory.openSession();
       Transaction transaction=session.beginTransaction();
		  Query query2=session.createQuery("FROM AddOn WHERE AddOn_ID=:addOnId");
		  query2.setParameter("addOnId", addOnId); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  addOn = (AddOn) iterator.next();
		  }
		  transaction.commit();
			session.close();
		return addOn;
	}
}
