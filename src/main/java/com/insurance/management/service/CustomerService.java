package com.insurance.management.service;

import com.insurance.management.model.Customer;

public interface CustomerService {

	// Save customer data
	Customer saveData(Customer customer);

	// Fetching single customer data
	Customer getDataById(Integer customerId);

	// Update Customer Data
	Customer updateData(Customer customer);

	// Delete Customer Data
	void deleteData(Integer customerId);
}
