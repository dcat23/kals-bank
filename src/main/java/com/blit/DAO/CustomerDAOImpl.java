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
			String sql = "SELECT c.name, c.password, c.email, a.balance " +
					"FROM Customers c " +
					"JOIN Account a ON c.account_number = a.account_number " +
					"WHERE a.account_number = " + accNo + ";";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			Customer customer = new Customer();

			while(result.next()) {
				
				customer.setAccountnumber(accNo);
			   	customer.setBalance(result.getLong("balance"));
				customer.setEmail(result.getString("email"));
				customer.setName(result.getString("name"));
				customer.setPassword(result.getString("password"));
			}

			System.out.println("findByAccountNumber: " + customer);
			return customer;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean updateBalance(Customer customer) {
		System.out.println("updating balance " + customer);
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE Account SET balance = ? WHERE account_number = ? ;";

			PreparedStatement statement = conn.prepareStatement(sql);

			int count = 0;
			statement.setLong(++count, customer.getBalance());
			statement.setInt(++count, customer.getAccountnumber());

			statement.execute();

			return true;

		} catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
	}

}
