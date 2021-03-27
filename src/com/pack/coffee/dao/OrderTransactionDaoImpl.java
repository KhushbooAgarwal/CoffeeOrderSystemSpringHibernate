package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.pack.coffee.bean.OrderTransaction;
import com.pack.coffee.bean.Orders;
import com.pack.coffee.bean.Vouchers;
import com.pack.coffee.util.MySQLConnectionManagement;
@Repository("OrderTransactionDao")
public class OrderTransactionDaoImpl implements OrderTransactionDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public int createOrderTran(int orderTranId , int orderId, int coffeeId, int addOnID)
			throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		OrderTransaction orders = new OrderTransaction();
		orders.setOrderTranId(orderTranId);
		orders.setOrderId(orderId);
		orders.setCoffeeId(coffeeId);
		orders.setAddOnID(addOnID);
		int row = (int) session.save(orders);
		transaction.commit();
		session.close();
		return row;
	}

	@Override
	public ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
        Session session=sessionFactory.openSession();		
		Transaction transaction=session.beginTransaction();
		Query<OrderTransaction> query=session.createQuery("from OrderTransaction WHERE ORDER_ID=:orderId");
		query.setParameter("orderId", orderId);
		List<OrderTransaction> orders=query.getResultList();
		transaction.commit();
		session.close();
		//factory.close();
		return (ArrayList<OrderTransaction>) orders;
		
	}
	
	@Override
	public ArrayList<Integer> getCoffeeIdByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Session session=sessionFactory.openSession();		
		Transaction transaction=session.beginTransaction();
		ArrayList<Integer> orderCoffeeList =new ArrayList<>();;
		Query<Integer> query=session.createQuery("SELECT DISTINCT(coffeeId) from OrderTransaction WHERE ORDER_ID=:orderId");
		query.setParameter("orderId", orderId);
		List<Integer> orders=query.getResultList();
		transaction.commit();
		session.close();
		//factory.close();
		return (ArrayList<Integer>) orders;
		
	}
	@Override
	public ArrayList<Integer> getAddOnIdByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Session session=sessionFactory.openSession();		
		Transaction transaction=session.beginTransaction();
		ArrayList<Integer> orderCoffeeList =new ArrayList<>();;
		Query<Integer> query=session.createQuery("SELECT addOnID from OrderTransaction WHERE ORDER_ID=:orderId");
		query.setParameter("orderId", orderId);
		List<Integer> orders=query.getResultList();
		transaction.commit();
		session.close();
		//factory.close();
		return (ArrayList<Integer>) orders;
	}

	@Override
	public int getMaxOrderTranId() throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		int id = 0;
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Object> crt3 = criteriaBuilder.createQuery(Object.class);
		Root<OrderTransaction> root3 = crt3.from(OrderTransaction.class);
		
		crt3.select(criteriaBuilder.max(root3.get("orderTranId"))); 
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
}
