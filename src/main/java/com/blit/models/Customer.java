package com.blit.models;

import java.util.Objects;

public class Customer {
	private String name;
	private long balance;
	private String email;
	private int Accountnumber;
	public String password;
	public Customer() {
		super();
	}
	public Customer(String name, long balance, String email, int accountnumber) {
		super();
		this.name = name;
		this.balance = balance;
		this.email = email;
		Accountnumber = accountnumber;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", Accountnumber=" + Accountnumber + ", balance=" + balance + ", email="
				+ email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Accountnumber, balance, email, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Accountnumber == other.Accountnumber && balance == other.balance && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountnumber() {
		return Accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		Accountnumber = accountnumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
