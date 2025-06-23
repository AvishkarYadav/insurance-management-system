package com.insurance.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.management.model.Policy;
import com.insurance.management.service.PolicyService;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@PostMapping("/addPolicy")
	Policy addPolicy(@RequestBody Policy policy) {
		return policyService.addPolicy(policy);
	}

	@GetMapping("/getAllPolicies")
	List<Policy> getAllPolicies() {
		return policyService.getAllPolicies();
	}

	@GetMapping("/getPolicyById/{policyId}")
	Policy getPolicyById(@PathVariable("policyId") Integer policyId) {
		return policyService.getPolicyById(policyId);
	}

	@DeleteMapping("/deletePolicy/{policyId}")
	void deletePolicy(@PathVariable("policyId") Integer policyId) {
		policyService.deletePolicy(policyId);
	}
}
