package com.insurance.management.mapper;

import java.util.ArrayList;
import java.util.List;

import com.insurance.management.dto.CustomerDTO;
import com.insurance.management.model.Customer;

public class CustomerMapper {

	// FOR DTO PART
	// DTO → Entity
	public static Customer toEntity(CustomerDTO dto) {
		Customer customer = new Customer();
		customer.setCustomerId(dto.getCustomerId());
		customer.setFullName(dto.getFullName());
		customer.setEmailId(dto.getEmailId());
		customer.setPhoneNumber(dto.getPhoneNumber());
		customer.setCity(dto.getCity());
		customer.setPinCode(dto.getPinCode());
		return customer;
	}

	// Entity → DTO
	public static CustomerDTO toDto(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(customer.getCustomerId());
		dto.setFullName(customer.getFullName());
		dto.setEmailId(customer.getEmailId());
		dto.setPhoneNumber(customer.getPhoneNumber());
		dto.setCity(customer.getCity());
		dto.setPinCode(customer.getPinCode());
		return dto;
	}
	
	public static List<CustomerDTO> toDtoList(List<Customer> customers) {
	    List<CustomerDTO> dtoList = new ArrayList<>();
	    for (Customer customer : customers) {
	        dtoList.add(toDto(customer)); // Call the existing toDto() method
	    }
	    return dtoList;
	}

}
