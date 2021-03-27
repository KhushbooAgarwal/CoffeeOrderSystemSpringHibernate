package com.pack.coffee.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.coffee.bean.Customers;
@Repository("CustomerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	  @Autowired private SessionFactory sessionFactory; 
	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory;
	 */
	//}
	@Override
	public int addCustomer(int custId, String custName, long phoneNum) throws ClassNotFoundException, SQLException {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customers customers = new Customers();
		customers.setCustomerID(custId);
		customers.setCustomerName(custName);
		customers.setPhoneNumber(phoneNum);
        session.save(customers);
		transaction.commit();
		session.close();
		
		return 1;
	}

	@Override
	public Customers getCustomerByPhone(long phoneNum) throws ClassNotFoundException, SQLException {
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  Customers customers =null;
		  Query query2=session.createQuery("from Customers where phone_Number=:phoneNum");
		  query2.setParameter("phoneNum", phoneNum); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
              customers = (Customers) iterator.next();
		  }
		  transaction.commit();
		  session.close();
		  
		 return customers;
	}

	@Override
	public int getMaxCustomer() throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		 int id = 0;
			CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
			
		 CriteriaQuery<Object> crt3 = criteriaBuilder.createQuery(Object.class);
			Root<Customers> root3 = crt3.from(Customers.class);
			
			crt3.select(criteriaBuilder.max(root3.get("customerID"))); 
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
	public int checkCustomer(long phoneNum) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  int id = 0;
		 Customers customers =null;
		 
		  Query query2=session.createQuery("from Customers where phone_Number=:phoneNum");
		  query2.setParameter("phoneNum", phoneNum); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
             customers = (Customers) iterator.next();
             id = customers.getCustomerID();
		  }
		    transaction.commit();
		    
			  session.close();
			 
			     
		return id;
	}

	@Override
	public Customers getCustomerId(String custName, long phoneNum) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  Customers customers =null;
		  Query query2=session.createQuery("from Customers where phone_Number=:phoneNum and CUSTOMER_NAME =:custName");
		 query2.setParameter("phoneNum", phoneNum); 
		 query2.setParameter("custName",custName);
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
            customers = (Customers) iterator.next();
		  }
		  transaction.commit();
		  session.close();
		

		return customers;
	}

	@Override
	public String getCustomerName(int custId) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  String custName = null;
		 Customers customers =null;
		 
		  Query query2=session.createQuery(" from Customers where CUSTOMER_ID=:custId");
		  query2.setParameter("custId", custId); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
           customers = (Customers) iterator.next();
           custName = customers.getCustomerName();
		  }
		  
	        transaction.commit();
			  session.close();
		return custName;
	}
}
