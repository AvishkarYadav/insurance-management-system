package com.insurance.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.management.model.Policy;
import com.insurance.management.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

	@PostMapping("/add")
	Policy addPolicy(@RequestBody Policy policy) {
		logger.info("Adding new Policy: {}", policy.getPolicyId());
		return policyService.addPolicy(policy);
	}

	@GetMapping("/list")
	List<Policy> getAllPolicies() {
		logger.info("Fetching all policies...");
		return policyService.getAllPolicies();
	}

	@GetMapping("/getById/{policyId}")
	Policy getPolicyById(@PathVariable("policyId") Integer policyId) {
		logger.info("Fetching Policy data by ID: {}", policyId);
		return policyService.getPolicyById(policyId);
	}

	@DeleteMapping("/delete/{policyId}")
	void deletePolicy(@PathVariable("policyId") Integer policyId) {
		logger.info("Deleting Policy with ID: {}", policyId);
		policyService.deletePolicy(policyId);
	}

	@PutMapping("/update")
	Policy updatePolicy(@RequestBody Policy policy) {
		logger.info("Updating Policy with ID: {}", policy.getPolicyId());
		return policyService.updatePolicy(policy);
	}
}
