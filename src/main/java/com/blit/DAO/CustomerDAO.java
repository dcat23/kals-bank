package com.blit.DAO;

import com.blit.models.Customer;

public interface CustomerDAO {

	Customer findByAccountNumber(int accNo);
	

}
