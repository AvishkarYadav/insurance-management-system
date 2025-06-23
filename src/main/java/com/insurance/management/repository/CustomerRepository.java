package com.insurance.management.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

	

	// For fetching customers by FullName
	@Query(value = "select * from customer c where full_name=?1", nativeQuery = true)
	List<Customer> findByfullName(String fullName);

	// For fetching customers by city
	@Query(value = "select * from customer c where city =?1", nativeQuery = true)
	List<Customer> findByCity(String city);

}
