package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.exception.ResourceNotFoundException;
import com.insurance.management.model.Policy;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Policy addPolicy(Policy policy) {
		return policyRepository.save(policy);

	}

	@Override
	public List<Policy> getAllPolicies() {
		return policyRepository.findAll();

	}

	@Override
	public Policy getPolicyById(Integer policyId) {
		return policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy Not found with ID" + policyId));
	}

	@Override
	public void deletePolicy(Integer policyId) {
		policyRepository.deleteById(policyId);
	}

}
