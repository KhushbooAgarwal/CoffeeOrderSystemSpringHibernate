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
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.util.MySQLConnectionManagement;
@Repository("CoffeeDao")
public class CoffeeDaoImpl implements CoffeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
	@Override
	public ArrayList<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException {
		 Session session=sessionFactory.openSession();		
			Transaction transaction=session.beginTransaction();
			Query<Coffee> query=session.createQuery("from Coffee ");
			List<Coffee> coffeeList=query.getResultList();
			transaction.commit();
			session.close();
			//factory.close();
			return (ArrayList<Coffee>) coffeeList;
		}
	
	@Override
	public ArrayList<String> getAllCoffeeNameDetails() throws ClassNotFoundException, SQLException {
		 Session session=sessionFactory.openSession();		
			Transaction transaction=session.beginTransaction();
			ArrayList<String> coffeeNameList = new ArrayList<>();
			Query<Coffee> query = session.createQuery("select distinct(cf.coffee_Name) from Coffee cf"); 
			List<Coffee> coffeeList = query.getResultList();
			for(Coffee coffeeLists:coffeeList)
			{
				coffeeNameList.add(coffeeLists.getCoffeeName());
			}
			transaction.commit();
			session.close();
			//factory.close();
			return coffeeNameList;
	}

	@Override
	public Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize)
			throws ClassNotFoundException, SQLException {
		 Session session=sessionFactory.openSession();
		 Coffee coffee = null;
		Transaction transaction=session.beginTransaction();
		  Query query2=session.createQuery("from Coffee where COFFEE_NAME=:coffeeName and COFFEE_SIZE=:coffeeSize");
		  query2.setParameter("coffeeName", coffeeName); 
		  query2.setParameter("coffeeSize", coffeeSize); 
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  coffee = (Coffee) iterator.next();
		  }
		  transaction.commit();
			session.close();
			//factory.close();
		return coffee;
		
	}
	
	@Override
	public float getPriceByCoffeeId(int coffeeId)
			throws ClassNotFoundException, SQLException {
		Coffee coffee = null;
        Session session=sessionFactory.openSession();
        float price= 0f;
		Transaction transaction=session.beginTransaction();
		Query<Float> query = session.createQuery("select coffeePrice from Coffee where Coffee_id=:cId");
		query.setParameter("cId", coffeeId);
		
		if(query.uniqueResult()!=null)
		price =query.uniqueResult();
		transaction.commit();
		session.close();
		return price;
	}

	@Override
	public ArrayList<String> getAllCoffeeSize() throws ClassNotFoundException, SQLException {
		   Session session=sessionFactory.openSession();		
			Transaction transaction=session.beginTransaction();
			//ArrayList<String> coffeeSizeList = new ArrayList<>();
			Query<String> query = session.createQuery("select distinct(coffeeSize) from Coffee");
			//Query<String> query = session.createQuery("select distinct(coffeeSize) from Coffee");
			List<String> coffeeList=query.getResultList();
		/*
		 * for(Coffee coffeeLists:coffeeList) {
		 * coffeeSizeList.add(coffeeLists.getCoffeeSize()); }
		 */
			transaction.commit();
			session.close();
			//factory.close();
			return (ArrayList<String>) coffeeList;
			
	}

	@Override
	public Coffee getCoffeeDetailsById(int coffeeId) throws ClassNotFoundException, SQLException {
		Coffee coffee = null;
		 Session session=sessionFactory.openSession();
        float price= 0f;
		Transaction transaction=session.beginTransaction();
		  Query query2=session.createQuery("FROM Coffee WHERE Coffee_ID=:coffeeId");
		  query2.setParameter("coffeeId", coffeeId); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  coffee = (Coffee) iterator.next();
		  }
		  transaction.commit();
			session.close();
		return coffee;
	}

	

}
