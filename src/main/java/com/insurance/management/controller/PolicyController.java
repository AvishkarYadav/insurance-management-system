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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag(name = "Policy", description = "Manage insurance policies like add, update, view, and delete")
@RestController
@RequestMapping("/api/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

	@PostMapping("/add")
	@Operation(summary = "Save policy Data", description = "Rest API used to store policy data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	PolicyDTO addPolicy(@RequestBody PolicyDTO policyDTO) {
		logger.info("Adding new Policy: {}", policyDTO.getPolicyId());
		Policy policy = policyService.addPolicy(PolicyMapper.toEntity(policyDTO));
		PolicyDTO dto = PolicyMapper.toDto(policy);
		logger.info("New Policy Added succesfully: {}", policyDTO.getPolicyId());
		return dto;
	}

	@GetMapping("/list")
	@Operation(summary = "Fetch Policy List", description = "Rest API used to fetch policy list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	List<PolicyDTO> getAllPolicies() {
		logger.info("Fetching all policies...");
		List<Policy> policies = policyService.getAllPolicies();
		return PolicyMapper.toDtoList(policies);
	}

	@GetMapping("/getById/{policyId}")
	@Operation(summary = "Fetch Policy Data By Id", description = "Rest API used to fetch policy data by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	PolicyDTO getPolicyById(@PathVariable("policyId") Integer policyId) {
		logger.info("Fetching Policy data by ID: {}", policyId);
		Policy policy = policyService.getPolicyById(policyId);
		return PolicyMapper.toDto(policy);
	}

	@DeleteMapping("/delete/{policyId}")
	@Operation(summary = "Delete Policy Data", description = "Rest API used to delete policy data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	void deletePolicy(@PathVariable("policyId") Integer policyId) {
		logger.info("Deleting Policy with ID: {}", policyId);
		policyService.deletePolicy(policyId);
	}

	@PutMapping("/update")
	@Operation(summary = "Update Policy Data", description = "Rest API used to update policy data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	PolicyDTO updatePolicy(@RequestBody PolicyDTO policyDTO) {
		logger.info("Updating Policy with ID: {}", policyDTO.getPolicyId());
		Policy policy2 = policyService.updatePolicy(PolicyMapper.toEntity(policyDTO));
		logger.info("Updated Policy with ID: {}", policyDTO.getPolicyId());
		return PolicyMapper.toDto(policy2);
	}
}/*@OpenAPIDefinition(info = @Info(title = "Insurance Management System API", version = "1.0", description = "API documentation for the Insurance backend project"), tags = {
		@Tag(name = "1. Customer", description = "Operations related to customer registration, update, and retrieval"),
		@Tag(name = "2. Policy", description = "Manage insurance policies like add, update, view, and delete"),
		@Tag(name = "3. Nominee", description = "CRUD operations for nominee details associated with policies"),
		@Tag(name = "4. Premium", description = "Handle premium payments, schedule, and history"),
		@Tag(name = "5 .Claim", description = "Submit and manage claims") })*/
