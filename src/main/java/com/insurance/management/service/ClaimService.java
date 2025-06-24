package com.insurance.management.service;

import java.util.List;

import com.insurance.management.model.Claim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public interface ClaimService {

	// For add claim
	Claim addClaim(Claim claim, Integer policyId);

	// For list of claims
	List<Claim> getAllClaims();

	// For Claim By Id
	Claim getClaimById(Integer claimId);

	// For update claim
	Claim updateClaim(Integer claimId, Claim updatedClaim);

	// For Delete claim
	void deleteClaim(Integer claimId);

	// For List of claims By PolicyId
	List<Claim> getClaimByPolicy(Integer policyId);
}
