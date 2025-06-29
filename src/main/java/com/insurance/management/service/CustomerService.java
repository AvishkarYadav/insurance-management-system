package com.insurance.management.service;

import java.util.List;

import com.insurance.management.model.Customer;

public interface CustomerService {

	// Save/Add Customer data
	Customer saveData(Customer customer);

	// Fetching single customer data
	Customer getDataById(Integer customerId);

	// Fetch Customer by name
	List<Customer> getDataByName(String fullName);

	// Fetch Customer by city
	List<Customer> getDataByCity(String city);

	// Update Customer Data
	Customer updateData(Customer customer);

	// Delete Customer Data
	void deleteData(Integer customerId);

	// List of customers
	List<Customer> getAllCustomers();

	
	//Saving customers with all details
	Customer saveCustomerWithAllDetails(Customer customer);
}
