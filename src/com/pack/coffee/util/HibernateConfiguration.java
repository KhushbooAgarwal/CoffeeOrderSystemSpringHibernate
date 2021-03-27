package com.pack.coffee.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

	public class HibernateConfiguration {
		
		private static SessionFactory factory=null;

		public static SessionFactory getConfiguration(){

			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
			factory=meta.getSessionFactoryBuilder().build();
			return factory;
		}
	}

