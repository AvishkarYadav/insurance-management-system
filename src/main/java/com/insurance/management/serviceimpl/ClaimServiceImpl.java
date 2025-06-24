package com.insurance.management.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Claim;
import com.insurance.management.model.Policy;
import com.insurance.management.repository.ClaimRepository;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private PolicyRepository policyRepository;

	private static final Logger logger = LoggerFactory.getLogger(ClaimServiceImpl.class);

	@Override
	public Claim addClaim(Claim claim, Integer policyId) {
		logger.info("Adding new claim: {}", claim.getClaimId());
		Policy policy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy Id Not Found :"));
		claim.setPolicy(policy);
		logger.info("Claim added successfully with ID: {}", claim.getClaimId());
		return claimRepository.save(claim);

	}

	@Override
	public List<Claim> getAllClaims() {
		logger.info("Fetching list of Claims ");
		return claimRepository.findAll();

	}

	@Override
	public Claim getClaimById(Integer claimId) {
		logger.info("Fetching Claim by ID: {}", claimId);
		return claimRepository.findById(claimId).orElseThrow(() -> new RuntimeException("Claim not found :"));
	}

	@Override
	public Claim updateClaim(Integer claimId, Claim updatedClaim) {
		logger.info("Updating Claim data with ID: {}", updatedClaim.getClaimId());

		Claim existingClaim = getClaimById(claimId);
		existingClaim.setClaimAmount(updatedClaim.getClaimAmount());
		existingClaim.setClaimDate(updatedClaim.getClaimDate());
		existingClaim.setStatus(updatedClaim.getStatus());
		existingClaim.setDescription(updatedClaim.getDescription());
		logger.info("Updated Claim data with ID: {}", updatedClaim.getClaimId());

		return claimRepository.save(existingClaim);
	}

	@Override
	public void deleteClaim(Integer claimId) {
		logger.info("Deleting cusotmer Data with ID: {}", claimId);

		claimRepository.deleteById(claimId);
		logger.info("Deleted cusotmer Data with ID: {}", claimId);

	}

	@Override
	public List<Claim> getClaimByPolicy(Integer policyId) {
		logger.info("Fetching list of Claims By PolicyID: {}", policyId);
		return claimRepository.findByPolicyPolicyId(policyId);

	}

}
