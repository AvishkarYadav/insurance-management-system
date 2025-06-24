package com.insurance.management.service;

import java.util.List;

import com.insurance.management.model.Policy;

public interface PolicyService {

	// For Add Policy
	Policy addPolicy(Policy policy);

	// For List of Policy
	List<Policy> getAllPolicies();

	// For PolicyBy Id
	Policy getPolicyById(Integer policyId);

	// For Update Policy
	Policy updatePolicy(Policy policy);

	// For Delete Policy
	void deletePolicy(Integer policyId);

}
