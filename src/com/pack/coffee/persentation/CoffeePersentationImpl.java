package com.pack.coffee.persentation;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.bean.Customers;
import com.pack.coffee.bean.Invoices;
import com.pack.coffee.service.AddOnService;
import com.pack.coffee.service.AddOnServiceImpl;
import com.pack.coffee.service.CoffeeService;
import com.pack.coffee.service.CoffeeServiceImpl;
import com.pack.coffee.service.CustomerService;
import com.pack.coffee.service.CustomerServiceImpl;
import com.pack.coffee.service.InvoiceService;
import com.pack.coffee.service.InvoiceServiceImpl;
import com.pack.coffee.service.OrderService;
import com.pack.coffee.service.OrderServiceImpl;
import com.pack.coffee.service.OrderTransactionService;
import com.pack.coffee.service.OrderTransactionServiceImpl;
@Component("presentation")
public class CoffeePersentationImpl implements CoffeePersentation {
	
	/*
	 * @Autowired private CustomerService customers = new CustomerServiceImpl();
	 * 
	 * @Autowired private CoffeeService coffServ = new CoffeeServiceImpl();
	 * 
	 * @Autowired private AddOnService addOnServ = new AddOnServiceImpl();
	 * 
	 * @Autowired private OrderService orders = new OrderServiceImpl();
	 * 
	 * @Autowired private OrderTransactionService ordTran = new
	 * OrderTransactionServiceImpl();
	 * 
	 * @Autowired private InvoiceService invoiceServ = new InvoiceServiceImpl();
	 */
	 
	
	  @Autowired private CustomerService customers;
	  
	  @Autowired private CoffeeService coffServ;
	  
	  @Autowired private AddOnService addOnServ;
	  
	  @Autowired private OrderService orders;
	  
	  @Autowired private OrderTransactionService ordTran;
	  
	  @Autowired private InvoiceService invoiceServ;
	  
	/*
	 * public void setCustomers(CustomerService customers) { this.customers =
	 * customers; }
	 * 
	 * 
	 * public void setCoffServ(CoffeeService coffServ) { this.coffServ = coffServ; }
	 * 
	 * 
	 * public void setAddOnServ(AddOnService addOnServ) { this.addOnServ =
	 * addOnServ; }
	 * 
	 * 
	 * public void setOrders(OrderService orders) { this.orders = orders; }
	 * 
	 * 
	 * public void setOrdTran(OrderTransactionService ordTran) { this.ordTran =
	 * ordTran; }
	 * 
	 * 
	 * public void setInvoiceServ(InvoiceService invoiceServ) { this.invoiceServ =
	 * invoiceServ; }
	 */
	 

	static Scanner sc=new Scanner(System.in);
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	  Date date = new Date();
	  
	int orderId =0,orderTransId=0;
	int customerId=0;
	long phoneNumber=0L;
	String checkflag="Y";
	String name,coffeeName,coffeeSize,addOn,addonName;
	@Override
	public void checkCustomer() {
		int custId=0;
		String name ;
		Customers cust=null;
		System.out.println("*************WELCOME TO COFFEE ORDER SYSTEM************* ");
		System.out.println("Enter your Phone Number");
		
		phoneNumber=sc.nextLong();
		
		
			try {
				custId=customers.checkCustomer(phoneNumber);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(custId==0) {
			System.out.println("Enter your name :");	
			name=sc.next();
			try {
				customers.addCustomer(name, phoneNumber);
				
			
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}		
			

	public void showCoffee() {
		char AddOnkey='N',coffKey='N';
		int voucherId =0;
		Customers cust = null;
		Invoices invoice=null;
	
		try {
			do {
				System.out.println("****************COFFEE MENU*************************");
			ArrayList<Coffee> coffDetails = coffServ.getAllCoffeeDetails();
			for(Coffee clist : coffDetails) {
				System.out.println(clist.getCoffeeName() +"              "+ clist.getCoffeeSize() +"             "+ clist.getCoffeePrice());
			}
			System.out.println("***************************************************");
			System.out.println("Enter the coffee you want to buy :");
			coffeeName=sc.next().toUpperCase();
		
			ArrayList<String> sizeList=coffServ.getAllCoffeeSize();
			for(String list:sizeList) {
				System.out.println(list);
			}
			
			System.out.println("Enter the size you want to buy :");
			coffeeSize=sc.next().toUpperCase();
			
			cust= customers.getCustomerByPhone(phoneNumber);
			customerId=cust.getCustomerID();
			if(orderId==0)
			orderId= orders.CreateOrder(customerId, formatter.format(date), voucherId);
			showAddOn();
			
			System.out.println("Do you want to add AddOns[Y/N]:" );
			AddOnkey=sc.next().charAt(0);
			while(AddOnkey=='Y') {
				System.out.println("Select AddOn:");
				//sc.nextLine();
				addonName=sc.next().toUpperCase();
				ordTran.createOrderTran(orderId, coffeeName, coffeeSize, addonName);
				System.out.println("Do you want to add AddOns [Y/N]:" );
				AddOnkey=sc.next().charAt(0);
			}
			System.out.println("Do you want to order more coffee: ");
			coffKey=sc.next().charAt(0);
		}while(coffKey=='Y');
			System.out.println("Do you have any discount voucher :");
			String voucherName=sc.next();
			invoiceServ.createInvoice(orderId, voucherName, coffeeName, coffeeSize, addonName);
			invoiceServ.showInvoice(orderId,customerId);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void showAddOn() {
		try {
			ArrayList<AddOn> addOnList=addOnServ.getAllAddOn();
			for(AddOn addon:addOnList) {
				System.out.println(addon.getAddOnName());
			}
		
			System.out.println("Do you want to add AddOns:" );
			String addonName=sc.next().toUpperCase();
		
			ordTran.createOrderTran(orderId, coffeeName, coffeeSize, addonName);
			
				
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	


}
