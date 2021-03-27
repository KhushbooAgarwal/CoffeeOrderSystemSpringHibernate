package com.pack.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.query.Query;

import com.pack.coffee.bean.Coffee;


public class CoffeeeMain {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

		//For entire application one SessionFactory object : SessionFactory is SingleTon
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
	
		//For every Transaction one Session object
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		Query<Coffee> query = session.createQuery("from Coffee"); 
		
		List<Coffee> list = query.getResultList();
		for(Coffee det : list) {
			System.out.println(det);
		}
	
		transaction.commit();
		
	//	System.out.println("Records Added ");
		
		session.close();
		

	}

}
