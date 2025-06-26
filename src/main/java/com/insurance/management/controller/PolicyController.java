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

import com.insurance.management.dto.PolicyDTO;
import com.insurance.management.mapper.PolicyMapper;
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
	PolicyDTO addPolicy(@RequestBody PolicyDTO policyDTO) {
		logger.info("Adding new Policy: {}", policyDTO.getPolicyId());
		Policy policy = policyService.addPolicy(PolicyMapper.toEntity(policyDTO));
		PolicyDTO dto = PolicyMapper.toDto(policy);
		logger.info("New Policy Added succesfully: {}", policyDTO.getPolicyId());
		return dto;
	}

	@GetMapping("/list")
	List<PolicyDTO> getAllPolicies() {
		logger.info("Fetching all policies...");
		List<Policy> policies = policyService.getAllPolicies();
		return PolicyMapper.toDtoList(policies);
	}

	@GetMapping("/getById/{policyId}")
	PolicyDTO getPolicyById(@PathVariable("policyId") Integer policyId) {
		logger.info("Fetching Policy data by ID: {}", policyId);
		Policy policy = policyService.getPolicyById(policyId);
		return PolicyMapper.toDto(policy);
	}

	@DeleteMapping("/delete/{policyId}")
	void deletePolicy(@PathVariable("policyId") Integer policyId) {
		logger.info("Deleting Policy with ID: {}", policyId);
		policyService.deletePolicy(policyId);
	}

	@PutMapping("/update")
	PolicyDTO updatePolicy(@RequestBody PolicyDTO policyDTO) {
		logger.info("Updating Policy with ID: {}", policyDTO.getPolicyId());
		Policy policy2 = policyService.updatePolicy(PolicyMapper.toEntity(policyDTO));
		logger.info("Updated Policy with ID: {}", policyDTO.getPolicyId());
		return PolicyMapper.toDto(policy2);
	}
}
