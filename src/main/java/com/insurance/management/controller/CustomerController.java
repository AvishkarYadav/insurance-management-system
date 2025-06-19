package com.insurance.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.management.model.Customer;
import com.insurance.management.service.CustomerService;
import com.insurance.management.serviceimpl.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Save customer data
	@PostMapping("/save")
	Customer saveData(@RequestBody Customer customer) {
		Customer customers = customerService.saveData(customer);
		return customers;
	}

	// Fetching single customer data
	@GetMapping("/get/{customerId}")
	Customer getDatabyId(@PathVariable("customerId") Integer customerId) {
		return customerService.getDataById(customerId);
	}

	// Update Customer Data
	@PutMapping("/update")
	Customer updateData(@RequestBody Customer customer) {
		Customer customer3 = customerService.saveData(customer);
		return customer3;
	}

	// Delete Customer Data
	@DeleteMapping("/delete/{customerId}")
	void deleteData(@PathVariable("customerId") Integer customerId) {
		customerService.deleteData(customerId);
	}
}
