package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return customerRepository.findBycustomerId(customerId);
	}

	@Override
	public Customer updateData(Customer customer) {
		Customer customer3 = customerRepository.save(customer);
		return customer3;
	}

	@Override
	public void deleteData(Integer customerId) {
		customerRepository.deleteById(customerId);

	}

}
