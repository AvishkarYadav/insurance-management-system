package com.insurance.management.service;

import java.util.List;

import com.insurance.management.model.Premium;

public interface PremiumService {

	// For add premium
	Premium addPremium(Premium premium, Integer policyId);

	// for fetch
	Premium getPremiumById(Integer premiumId);

	// List of premiums all
	List<Premium> getAllPremuims();

	// For List of premiums by policy
	List<Premium> allPremiumsByPolicyId(Integer policyId);

	// Delete premium from data
	void deletePremium(Integer premiumId);

}
