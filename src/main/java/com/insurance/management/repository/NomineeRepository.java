package com.insurance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Nominee;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Integer> {

	
}
