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
			String sql = "SELECT * FROM Customers WHERE account_number = '" +
					accNo + "';";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			Customer customer = new Customer();

			while(result.next()) {
				
				customer.setAccountnumber(result.getInt("account_number"));
//			   customer.setBalance(result.getLong("Balance"));
				customer.setEmail(result.getString("email"));
				customer.setName(result.getString("name"));
				customer.setPassword(result.getString("password"));
			}
			
			return customer;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
