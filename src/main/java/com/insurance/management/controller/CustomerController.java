package com.insurance.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.management.dto.CustomerDTO;
import com.insurance.management.mapper.CustomerMapper;
import com.insurance.management.model.Customer;
import com.insurance.management.repository.CustomerRepository;
import com.insurance.management.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag(name = "Customer", description = "Operations related to cusotmer registration ,updation and retrieval")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository customerRepository;

	// Pagination
	@GetMapping("/paginated")
	public Page<Customer> getPaginatedCustomers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return customerRepository.findAll(pageable);

	}

	// Save customer data
	@PostMapping("/add")
	@Operation(summary = "Save Customer Data", description = "Rest API used to store customer data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	public CustomerDTO saveData(@RequestBody CustomerDTO customerDTO) {
		logger.info("Adding new customer: {}", customerDTO.getFullName());

		Customer savedCustomer = customerService.saveData(CustomerMapper.toEntity(customerDTO));
		CustomerDTO responseDTO = CustomerMapper.toDto(savedCustomer);

		logger.info("New customer added successfully: {}", responseDTO.getCustomerId());
		return responseDTO;
	}

	// Fetching single customer data
	@GetMapping("/getById/{customerId}")
	@Operation(summary = "Fetch Customer Data By ID", description = "Rest API used to fetch customer data by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	CustomerDTO getDatabyId(@PathVariable("customerId") Integer customerId) {
		logger.info("Fetching customer data by ID: {}", customerId);
		Customer customer = customerService.getDataById(customerId);
		return CustomerMapper.toDto(customer);
	}

	// Fetching By FullName
	@GetMapping("/getByName/{fullName}")
	@Operation(summary = "Fetch Customer Data By Name", description = "Rest API used to fetch customer data by name")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	List<CustomerDTO> getDataByName(@PathVariable("fullName") String fullName) {
		logger.info("Fetching customer data by FullName: {}", fullName);
		List<Customer> customers = customerService.getDataByName(fullName);
		return CustomerMapper.toDtoList(customers);
	}

	// Fetching Customer By City
	@GetMapping("/getByCity/{city}")
	@Operation(summary = "Fetch Customer Data By City", description = "Rest API used to fetch customer data by city")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	List<CustomerDTO> getDataByCity(@PathVariable("city") String city) {
		logger.info("Fetching customer data by City: {}", city);
		List<Customer> customers = customerService.getDataByName(city);
		return CustomerMapper.toDtoList(customers);
	}

	// Update Customer Data
	@PutMapping("/update")
	@Operation(summary = "Update Customer Data", description = "Rest API used to update customer data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	CustomerDTO updateData(@RequestBody CustomerDTO customerDto) {
		logger.info("Updating customer with ID: {}", customerDto.getCustomerId());
		Customer customer3 = customerService.saveData(CustomerMapper.toEntity(customerDto));
		logger.info("Updated customer data successfully. ");
		return CustomerMapper.toDto(customer3);
	}

	// Delete Customer Data
	@DeleteMapping("/delete/{customerId}")
	@Operation(summary = "Delete Customer Data", description = "Rest API used to delete customer data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	void deleteData(@PathVariable("customerId") Integer customerId) {
		logger.info("Deleting customer with ID: {}", customerId);
		customerService.deleteData(customerId);
		logger.info("Customer deleted successfully.");
	}

	// List of customers
	@GetMapping("/list")
	@Operation(summary = "Fetch All Customers List", description = "Rest API used to fetch customer list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	public List<CustomerDTO> getAllCustomers() {
		logger.info("Fetching all customers...");
		List<Customer> customers = customerService.getAllCustomers();
		return CustomerMapper.toDtoList(customers);
	}

	@PostMapping("/save-all")
	public ResponseEntity<Customer> saveAllData(@RequestBody Customer customer) {
		Customer saved = customerService.saveCustomerWithAllDetails(customer);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
}
