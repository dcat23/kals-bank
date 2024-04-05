package com.blit.service;

import com.blit.DAO.CustomerDAO;
import com.blit.DAO.CustomerDAOImpl;
import com.blit.models.Customer;

public class CustomersService {
	
	private Customer customer = new Customer();
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public void deposit(long amount) throws Exception {

		if (amount <= 0) {
			throw new Exception("Cannot deposit negative balance");
		}

		try {

			customer.setBalance(amount + customer.getBalance());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		boolean success = customerDAO.updateBalance(customer);

		if (success) {
			System.out.println("Updated balance " + customer.getBalance());
		} else {
			throw new Exception("Something went wrong updating balance");
		}
	}

		
	public void withdraw(long amount) {
		System.out.println("withdrawing $" + amount);
		long balance = customer.getBalance();
		if (amount > 0 && amount<=customer.getBalance()) {
			balance = balance-amount;
			customer.setBalance(balance);
			boolean updated = customerDAO.updateBalance(customer);


		}else {

			 System.out.println("Sorry Something went Wrong try to Put a valid Amount");
		}
	}



	
	public void Login(int accNo, String password) throws Exception {
		Customer customer = customerDAO.findByAccountNumber(accNo);
		System.out.println("login:" + customer);

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