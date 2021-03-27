package com.pack.coffee.client;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pack.coffee.persentation.CoffeePersentation;

public class CoffeeOrderClient {

	public static void main(String[] args) {
        ApplicationContext springContainer=new AnnotationConfigApplicationContext(MyJdbcConfiguration.class);
		
		CoffeePersentation coffee=(CoffeePersentation)springContainer.getBean("presentation");
		
	
		coffee.checkCustomer();
		coffee.showCoffee();
	}
}
