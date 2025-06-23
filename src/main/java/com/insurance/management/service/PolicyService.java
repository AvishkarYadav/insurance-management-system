package com.insurance.management.service;

import java.util.List;

import com.insurance.management.model.Policy;

public interface PolicyService {

	
	Policy addPolicy(Policy policy);
	
	List<Policy> getAllPolicies();
	
	Policy getPolicyById(Integer policyId);
	
	void deletePolicy(Integer policyId);
}
