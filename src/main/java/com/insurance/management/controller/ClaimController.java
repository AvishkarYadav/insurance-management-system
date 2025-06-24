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

import com.insurance.management.model.Claim;
import com.insurance.management.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/claim")
public class ClaimController {

	@Autowired
	private ClaimService claimService;

	private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);

	// For add claim
	@PostMapping("/add/{policyId}")
	Claim addClaim(@RequestBody Claim claim, @PathVariable("policyId") Integer policyId) {
		logger.info("Adding new claim: {}", claim.getClaimId());
		return claimService.addClaim(claim, policyId);
	}

	// For list of claims
	@GetMapping("/list")
	List<Claim> getAllClaims() {
		logger.info("Fetching all claims...");

		return claimService.getAllClaims();
	}

	// For Claim By Id
	@GetMapping("/getById/{claimId}")
	Claim getClaimById(@PathVariable("claimId") Integer claimId) {
		logger.info("Fetching Claim data by ID: {}", claimId);

		return claimService.getClaimById(claimId);
	}

	// For update claim
	@PutMapping("/update/{claimId}")
	Claim updateClaim(@PathVariable Integer claimId, @RequestBody Claim updatedClaim) {
		logger.info("Updating Claim with ID: {}", updatedClaim.getClaimId());
		return claimService.updateClaim(claimId, updatedClaim);
	}

	// For Delete claim
	@DeleteMapping("/delete/{claimId}")
	void deleteClaim(@PathVariable("claimId") Integer claimId) {
		logger.info("Deleting claim with ID: {}", claimId);
		claimService.deleteClaim(claimId);
	}

	// For List of claims By PolicyId
	@GetMapping("/getClaimByPolicy/{policyId}")
	List<Claim> getClaimByPolicy(@PathVariable("policyId") Integer policyId) {
		logger.info("Fetching claim By PolicyID: {}", policyId);
		return claimService.getClaimByPolicy(policyId);
	}
}
