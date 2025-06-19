package com.insurance.management.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

	public Customer findBycustomerId(Integer customerId);
}
