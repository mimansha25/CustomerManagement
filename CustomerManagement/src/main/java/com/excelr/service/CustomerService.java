package com.excelr.service;

import java.util.List;

import com.excelr.entity.Customer;

public interface CustomerService {
	
	
	Customer addCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer getCustomerById(int id);
	String deleteCustomer(int id);
	String updateCustomer(int id, Customer customer);

}
