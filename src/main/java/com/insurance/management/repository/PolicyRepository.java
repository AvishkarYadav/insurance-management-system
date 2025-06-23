package com.insurance.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {



}
