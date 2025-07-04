package com.insurance.management.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.management.dto.CustomerDTO;
import com.insurance.management.model.Claim;
import com.insurance.management.model.Customer;
import com.insurance.management.model.Nominee;
import com.insurance.management.model.Policy;
import com.insurance.management.model.Premium;
import com.insurance.management.repository.ClaimRepository;
import com.insurance.management.repository.CustomerRepository;
import com.insurance.management.repository.NomineeRepository;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.repository.PremiumRepository;
import com.insurance.management.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private NomineeRepository nomineeRepository;

	@Autowired
	private PremiumRepository premiumRepository;

	@Autowired
	private ClaimRepository claimRepository;

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer saveData(Customer customer) {
		logger.info("Adding new customer: {}", customer.getFullName());
		Customer customer1 = customerRepository.save(customer);
		logger.info("Customer added successfully with ID: {}", customer1.getCustomerId());
		return customer1;
	}

	@Override
	public Customer getDataById(Integer customerId) {
		logger.info("Fetching customer by ID: {}", customerId);
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Customer Not Found with Id :" + customerId));

	}

	@Override
	public Customer updateData(Customer customer) {
		logger.info("Updating customer data with ID: {}", customer.getCustomerId());
		Customer customer3 = customerRepository.save(customer);
		logger.info("Updated customer data with ID: {}", customer.getCustomerId());
		return customer3;
	}

	// Delete customer by ID
	@Override
	public void deleteData(Integer customerId) {
		logger.info("Deleting cusotmer Data with ID: {}", customerId);
		customerRepository.deleteById(customerId);
		logger.info("Deleted cusotmer Data with ID: {}", customerId);

	}

	// List of Customers
	@Override
	public List<Customer> getAllCustomers() {
		logger.info("Fetching list of Customers ");
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> getDataByName(String fullName) {
		logger.info("Fetching customer by fullName: {}", fullName);
		return customerRepository.findByfullName(fullName);
	}

	// List Of customers By City
	@Override
	public List<Customer> getDataByCity(String city) {
		logger.info("Fetching customer by city: {}", city);
		return customerRepository.findByCity(city);
	}

	@Transactional
	public Customer saveCustomerWithAllDetails(Customer customer) {
		// Save customer
		Customer savedCustomer = customerRepository.save(customer);

		// Save policies
		for (Policy policy : customer.getPolicies()) {
			policy.setCustomer(savedCustomer);
			Policy savedPolicy = policyRepository.save(policy);

			// Save nominees
			for (Nominee nominee : policy.getNominees()) {
				nominee.setPolicy(savedPolicy);
				nomineeRepository.save(nominee);
			}

			// Save premiums
			for (Premium premium : policy.getPremiums()) {
				premium.setPolicy(savedPolicy);
				premiumRepository.save(premium);
			}

			// Save claims
			for (Claim claim : policy.getClaims()) {
				claim.setPolicy(savedPolicy);
				claimRepository.save(claim);
			}
		}

		return savedCustomer;
	}

}
