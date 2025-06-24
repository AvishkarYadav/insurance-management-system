package com.insurance.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Premium;

@Repository
public interface PremiumRepository extends JpaRepository<Premium, Integer> {

	List<Premium> findByPolicyPolicyId(Integer policyId);

}
