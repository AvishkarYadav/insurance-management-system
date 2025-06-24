package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Claim;
import com.insurance.management.model.Policy;
import com.insurance.management.repository.ClaimRepository;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Claim addClaim(Claim claim, Integer policyId) {
		Policy policy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy Id Not Found :"));
		claim.setPolicy(policy);
		return claimRepository.save(claim);

	}

	@Override
	public List<Claim> getAllClaims() {
		return claimRepository.findAll();

	}

	@Override
	public Claim getClaimById(Integer claimId) {
		return claimRepository.findById(claimId).orElseThrow(() -> new RuntimeException("Claim not found :"));
	}

	@Override
	public Claim updateClaim(Integer claimId, Claim updatedClaim) {
		Claim existingClaim = getClaimById(claimId);
		existingClaim.setClaimAmount(updatedClaim.getClaimAmount());
		existingClaim.setClaimDate(updatedClaim.getClaimDate());
		existingClaim.setStatus(updatedClaim.getStatus());
		existingClaim.setDescription(updatedClaim.getDescription());
		return claimRepository.save(existingClaim);
	}

	@Override
	public void deleteClaim(Integer claimId) {
		claimRepository.deleteById(claimId);

	}

	@Override
	public List<Claim> getClaimByPolicy(Integer policyId) {
		return claimRepository.findByPolicyPolicyId(policyId);

	}

}
