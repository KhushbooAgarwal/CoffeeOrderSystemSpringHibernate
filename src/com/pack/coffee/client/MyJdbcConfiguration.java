package com.pack.coffee.client;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.pack")
public class MyJdbcConfiguration {

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		driverManagerDataSource.setUsername("system");
		driverManagerDataSource.setPassword("wiley123");
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		return driverManagerDataSource;
	}
	
	
	 @Bean(name ="sessionFactoryBean")
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] {
	                "com.pack.coffee.bean"
	            });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }

	 
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	        properties.put("hibernate.show_sql", "false");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        return properties;
	    }
	 
	 


}
