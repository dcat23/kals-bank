package com.blit.service;

import com.blit.DAO.CustomerDAO;
import com.blit.DAO.CustomerDAOImpl;
import com.blit.models.Customer;

public class CustomersService {
	
	private Customer customer = new Customer();
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public void deposit(long amount) {

		try {
			customer.setBalance(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}



//		accountDAO.updateBalance(customer);

//		long updatedBalance = customer.getBalance();

//		Insert intp a


//		if (amount>=1) {
//			balance = balance+amount;
//			 System.out.println("Deposit of "+ amount +"$  Sucessful.");
//		}else {
//			System.out.println("Deposit of "+ amount+ "$ Successful.");
//		}
		}
		
		
	public void withdraw(long amount) {
		long balance = customer.getBalance();
		if (amount>=1 && amount<=balance) {
			balance = balance-amount;
			 System.out.println("Withdraw of "+ amount +"$  Sucessful.");
		}else {

			 System.out.println("Sorry Something went Wrong try to Put a valid Amount");
		}
	}



	
	public void Login(int accNo, String password) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = customerDAO.findByAccountNumber(accNo);
		if (customer == null) {
			throw new Exception("Invalid account");
		}
//		System.out.println(customer + " c "+" p");

		if (!customer.getPassword().equals(password)) {
			throw new Exception("Invalid passwords");
		}
		
		this.customer = customer;

	}
}