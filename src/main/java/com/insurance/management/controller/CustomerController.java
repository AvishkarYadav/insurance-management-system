package com.insurance.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.management.model.Customer;
import com.insurance.management.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	// Save customer data
	@PostMapping("/add")
	Customer saveData(@RequestBody Customer customer) {
		// logger part
		logger.info("Adding new customer: {}", customer.getFullName());
		Customer customers = customerService.saveData(customer);
		logger.info("New customer added succesfully: {}", customer.getCustomerId());
		return customers;
	}

	// Fetching single customer data
	@GetMapping("/getById/{customerId}")
	Customer getDatabyId(@PathVariable("customerId") Integer customerId) {
		logger.info("Fetching customer data by ID: {}", customerId);
		return customerService.getDataById(customerId);
	}

	// Fetching By FullName
	@GetMapping("/getByName/{fullName}")
	List<Customer> getDataByName(@PathVariable("fullName") String fullName) {
		logger.info("Fetching customer data by FullName: {}", fullName);
		return customerService.getDataByName(fullName);
	}

	// Fetching Customer By City
	@GetMapping("/getByCity/{city}")
	List<Customer> getDataByCity(@PathVariable("city") String city) {
		logger.info("Fetching customer data by City: {}", city);
		return customerService.getDataByCity(city);

	}

	// Update Customer Data
	@PutMapping("/update")
	Customer updateData(@RequestBody Customer customer) {
		logger.info("Updating customer with ID: {}", customer.getCustomerId());
		Customer customer3 = customerService.saveData(customer);
		logger.info("Updated customer data successfully. ");
		return customer3;
	}

	// Delete Customer Data
	@DeleteMapping("/delete/{customerId}")
	void deleteData(@PathVariable("customerId") Integer customerId) {
		logger.info("Deleting customer with ID: {}", customerId);
		customerService.deleteData(customerId);
		logger.info("Customer deleted successfully.");
	}

	// List of customers
	@GetMapping("/list")
	public List<Customer> getAllCustomers() {
		logger.info("Fetching all customers...");
		return customerService.getAllCustomers();
	}

}
