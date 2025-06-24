package com.insurance.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.management.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

	List<Claim> findByPolicyPolicyId(Integer policyId);
}
