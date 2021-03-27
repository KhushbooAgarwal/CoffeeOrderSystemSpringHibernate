package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
import com.pack.coffee.util.MySQLConnectionManagement;
@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@Override
	public int CreateOrder(int orderId,int customerId, String orderDate, int voucherId)
			throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Orders orders = new Orders();
		orders.setOrderId(orderId);
		orders.setCustomerId(customerId);
		orders.setOrderDate(getCurrentDate());
        int rows = (int) session.save(orders);
		transaction.commit();
		session.close();
		return rows;
	}

	@Override
	public Orders getOrderByCustid(int customerId) throws ClassNotFoundException, SQLException {
		Orders orders = null;
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  Query query2=session.createQuery("from ORDERS where CUSTOMER_ID=:customerId");
		  query2.setParameter("customerId", customerId); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  orders = (Orders) iterator.next();
		  }
		  transaction.commit();
		  session.close();
		return orders;
	}
	@Override
	public int getMaxOrderId() throws ClassNotFoundException, SQLException {
		Orders orders = null;
		int id= 0;
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
			
		  CriteriaQuery<Object> crt3 = criteriaBuilder.createQuery(Object.class);
			Root<Orders> root3 = crt3.from(Orders.class);
			
			crt3.select(criteriaBuilder.max(root3.get("orderId"))); 
			Query query3 = session.createQuery(crt3);
			Object maxId = query3.getSingleResult();
			if(maxId != null)
			{
		    id = (int) maxId;
			}
		  transaction.commit();
		  session.close();
		
		return id;
	}

	@Override
	public boolean isOrderIsPresent(int orderId) throws ClassNotFoundException, SQLException {
		Orders orders = null;
		int id= 0;
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  Query query2=session.createQuery("FROM ORDERS WHERE ORDER_ID =:orderId");
		  query2.setParameter("orderId", orderId);
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  orders = (Orders) iterator.next();
			  id = orders.getOrderId();
			  }
		  transaction.commit();
		  session.close();
		if(id!=0)
			return true;
		else 
			return false;
		

	}


}
