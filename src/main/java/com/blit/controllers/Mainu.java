package com.blit.controllers;

import java.util.Scanner;

public class Mainu {

Scanner scan = new Scanner(System.in);

public static void main(String[] args) throws Exception {
	 Controllers controller = new Controllers();
	 Scanner scan = new Scanner(System.in);

//public void firstMenu() {
	System.out.println("Hello, welcome to  " + "BILT Bank");


		
		System.out.println("1. Customer");
		System.out.println("2. Employee");

		String answer = scan.nextLine();
		
		if(answer.equals("1")) {
		
		System.out.println("1. Login");
		System.out.println("2. Register");
		String answer2 = scan.nextLine();
		
		if(answer2.equals("1")) {
			
			controller.Login();
			
		}else {
			controller.Register();
			
		}
			
			
		}else {//User login
			controller.Emplogin();
		}
		
		}
}


