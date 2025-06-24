package com.insurance.management.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Policy;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	private static final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

	@Override
	public Policy addPolicy(Policy policy) {
		logger.info("Adding new policy: {}", policy.getPolicyId());
		return policyRepository.save(policy);

	}

	@Override
	public List<Policy> getAllPolicies() {
		logger.info("Fetching list of Policies ");
		return policyRepository.findAll();

	}

	@Override
	public Policy getPolicyById(Integer policyId) {
		logger.info("Fetching policy by ID: {}", policyId);
		return policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy Not found with ID" + policyId));
	}

	@Override
	public void deletePolicy(Integer policyId) {
		logger.info("Deleting cusotmer Data with ID: {}",policyId);
		policyRepository.deleteById(policyId);
		logger.info("Deleted cusotmer Data with ID: {}",policyId);

	}

	@Override
	public Policy updatePolicy(Policy policy) {
		logger.info("Updating policy data with ID: {}",policy.getPolicyId());
		Integer policyId = policy.getPolicyId();
		Policy existingPolicy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy Id Not Found :" + policyId));
		existingPolicy.setPolicyNumber(policy.getPolicyNumber());
		existingPolicy.setPolicyType(policy.getPolicyType());
		existingPolicy.setStartDate(policy.getStartDate());
		existingPolicy.setEndDate(policy.getEndDate());
		existingPolicy.setCoverageAmount(policy.getCoverageAmount());
		existingPolicy.setPremiumAmount(policy.getPremiumAmount());
		logger.info("Updated policy data with ID: {}",policy.getPolicyId());
		return policyRepository.save(existingPolicy);
	}

}
