package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.exception.CustomerNotFoundException;
import com.insurance.management.model.Customer;
import com.insurance.management.repository.CustomerRepository;
import com.insurance.management.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveData(Customer customer) {
		Customer customer1 = customerRepository.save(customer);
		return customer1;
	}

	@Override
	public Customer getDataById(Integer customerId) {
		Customer customer = customerRepository.findBycustomerId(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException(customerId + " <-Customer Not Found");
		} else
			return customer;
	}

	@Override
	public Customer updateData(Customer customer) {
		Customer customer3 = customerRepository.save(customer);
		return customer3;
	}

	// Get cusotmer by ID
	@Override
	public void deleteData(Integer customerId) {
		customerRepository.deleteById(customerId);

	}

	// List of Customers
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> getDataByName(String fullName) {
		return customerRepository.findByfullName(fullName);
	}

	// List Of customers By City
	@Override
	public List<Customer> getDataByCity(String city) {
		return customerRepository.findByCity(city);
	}

}
