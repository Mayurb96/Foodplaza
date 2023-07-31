package com.Dao;

import java.util.List;

import com.pojo.Customer;

public interface CustomerDao {
	
	boolean addCustomer(Customer cs);
	boolean updateCustomerById(Customer cs);
	boolean deleteCustomerById(String EmailId);
	List<Customer>getAllCustomer();
	Customer searchCustomerById(String EmailId);

}
