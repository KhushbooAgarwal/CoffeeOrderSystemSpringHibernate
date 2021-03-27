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
import com.pack.coffee.bean.Invoices;

@Repository("InvoiceDao")
public class InvoiceDaoImpl implements InvoiceDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}
	@Override
	public int CreateInvoice(int invoiceNum,int orderId, float netValue, float gst, float serviceTax, float total,float price,
			float voucherAmt) throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Invoices invoices = new Invoices();
		invoices.setInvoiceId(invoiceNum);
		invoices.setOrderId(orderId);
		invoices.setNetValue(netValue);
		invoices.setGst(gst);
		invoices.setServiceTax(serviceTax);
		invoices.setTotal(total);
		invoices.setPrice(price);
		invoices.setVoucherAmt(voucherAmt);
        int row = (int)session.save(invoices);
		transaction.commit();
		session.close();
		return row;
	}

	@Override
	public Invoices getInvoiceByOrderId(int orderId) throws ClassNotFoundException, SQLException {
		 Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  Invoices invoice = null;
		  Query query2=session.createQuery("FROM Invoices WHERE order_ID=:orderId");
		  query2.setParameter("orderId", orderId); 
		
		 List list = query2.list();
		  for (Iterator iterator = list.iterator(); iterator.hasNext();){
			  invoice = (Invoices) iterator.next();
		  }
		  transaction.commit();
		  session.close();
		  
		return invoice;
	
	}
	
	
	@Override
	public int getMaxInvoiceId() throws ClassNotFoundException, SQLException {
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		 int id = 0;
		 CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
			
		 CriteriaQuery<Object> crt3 = criteriaBuilder.createQuery(Object.class);
			Root<Invoices> root3 = crt3.from(Invoices.class);
			
			crt3.select(criteriaBuilder.max(root3.get("invoiceId"))); 
			Query query3 = session.createQuery(crt3);
			Object maxId = query3.getSingleResult();
			if(maxId != null)
			{
		    id = (int) maxId;
			}
		/*
		 * Invoices customers =null; Query query2 =
		 * session.createQuery("SELECT MAX(CUSTOMER_ID) FROM INVOICES"); List list =
		 * query2.list(); for (Iterator iterator = list.iterator();
		 * iterator.hasNext();){ customers = (Invoices) iterator.next(); id =
		 * customers.getInvoiceId(); }
		 */
		 
      transaction.commit();
		  session.close();
		return id;
		
	}

}
