package com.insurance.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.insurance.management.serviceimpl.CustomerServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Save customer data
	@PostMapping("/add")
	Customer saveData(@RequestBody Customer customer) {
		Customer customers = customerService.saveData(customer);
		return customers;
	}

	// Fetching single customer data
	@GetMapping("/getById/{customerId}")
	Customer getDatabyId(@PathVariable("customerId") Integer customerId) {
		return customerService.getDataById(customerId);
	}

	// Fetching By FullName
	@GetMapping("/getByName/{fullName}")
	List<Customer> getDataByName(@PathVariable("fullName") String fullName) {
		return customerService.getDataByName(fullName);
	}

	// Fetching Customer By City
	@GetMapping("/getByCity/{city}")
	List<Customer> getDataByCity(@PathVariable("city") String city) {
		return customerService.getDataByCity(city);

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

	// List of customers
	@GetMapping("/list")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

}
