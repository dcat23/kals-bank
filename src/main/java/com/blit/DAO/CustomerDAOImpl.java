package com.blit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blit.models.Customer;

import com.blit.utils.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer findByAccountNumber(int accNo) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT name,Accountnumber,email,Balance FROM customers,account"
					+ "WHERE customers.Accountnumber= ?";
		
			PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1,accNo);		
			ResultSet result = statement.executeQuery();
			
			Customer customer = new Customer();
			while(result.next()) {
				
				customer.setAccountnumber(result.getInt("Accountnumber"));
			   customer.setBalance(result.getLong("B1alance"));
				customer.setEmail(result.getString("email"));
				customer.setName(result.getString("name"));
			}
			
			return customer;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
