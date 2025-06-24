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

@RestController
@RequestMapping("/api/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@PostMapping("/add")
	Policy addPolicy(@RequestBody Policy policy) {
		return policyService.addPolicy(policy);
	}

	@GetMapping("/list")
	List<Policy> getAllPolicies() {
		return policyService.getAllPolicies();
	}

	@GetMapping("/getById/{policyId}")
	Policy getPolicyById(@PathVariable("policyId") Integer policyId) {
		return policyService.getPolicyById(policyId);
	}

	@DeleteMapping("/delete/{policyId}")
	void deletePolicy(@PathVariable("policyId") Integer policyId) {
		policyService.deletePolicy(policyId);
	}

	@PutMapping("/update")
	Policy updatePolicy(@RequestBody Policy policy) {
		return policyService.updatePolicy(policy);
	}
}
