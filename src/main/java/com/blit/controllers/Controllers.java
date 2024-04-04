package com.blit.controllers;

import java.util.Scanner;

import com.blit.service.CustomersService;

public class Controllers {
	Scanner scan=new Scanner(System.in);
	CustomersService service = new CustomersService();
	
	public void Login() throws Exception {
		System.out.println("Insert Your Account Number");
		int accNo = scan.nextInt();
		scan.nextLine();
		System.out.println("Insert Your Passweord");
		String password= scan.nextLine();	
		
		service.Login(accNo, password);
		
	}
	public void Emplogin() {
		System.out.println("Employee Name");
		String empname = scan.next();
		System.out.println("Insert Your Password");
		String emppassword= scan.nextLine();	
		
		}
	public void Register() {
		System.out.println("Enter your name");
		String name = scan.next();
		System.out.println("Insert Your email");
		String email= scan.nextLine();	
		System.out.println("Set your password");
		int newpassword= scan.nextInt();
		
	}

		
	 public void deposit() {
		 System.out.println("please insert the amount you want to deposit");
		 long amount=scan.nextLong();
       service.deposit(amount);
       }
	 
	public void withdraw() {
		System.out.println("please insert the amount you want to deposit");
		 long amount=scan.nextLong();
		
		 service.withdraw(amount);
		
	} /* public void transfer() {
		
		 long amount=scan.nextLong();
        if (amount <= balance) {
            withdraw();
            
            System.out.println("Transferred: $" + amount + " to account " + "destination.getAccountNumber()");
        } else {
            System.out.println("Insufficient funds for transfer!");
        }*/
	}
