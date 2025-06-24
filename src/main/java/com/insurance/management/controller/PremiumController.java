package com.insurance.management.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.management.model.Premium;
import com.insurance.management.service.PremiumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/premium")
public class PremiumController {

	@Autowired
	private PremiumService premiumService;

	private static final Logger logger = LoggerFactory.getLogger(PremiumController.class);

	// For add premium
	@PostMapping("/add/{policyId}")
	Premium addPremium(@RequestBody Premium premium, @PathVariable("policyId") Integer policyId) {
		logger.info("Adding new Premium: {}", premium.getPremiumId());
		return premiumService.addPremium(premium, policyId);
	}

	// for fetch
	@GetMapping("/getPremiumById/{premiumId}")
	Premium getPremiumById(@PathVariable("premiumId") Integer premiumId) {
		logger.info("Fetching premium data by ID: {}", premiumId);

		return premiumService.getPremiumById(premiumId);
	}

	// List of premiums all
	@GetMapping("/list")
	List<Premium> getAllPremuims() {
		logger.info("Fetching all premiums...");

		return premiumService.getAllPremuims();
	}

	// For List of premiums by policy
	@GetMapping("/listByPolicyId/{policyId}")
	List<Premium> allPremiumsByPolicyId(@PathVariable("policyId") Integer policyId) {
		return premiumService.allPremiumsByPolicyId(policyId);
	}

	// Delete premium from data
	@DeleteMapping("/delete/{premiumId}")
	void deletePremium(@PathVariable("premiumId") Integer premiumId) {
		logger.info("Deleting premium with ID: {}", premiumId);
		premiumService.deletePremium(premiumId);
	}

	// Update Premium Data
	@PutMapping("/update")
	public Premium updatePremium(@RequestBody Premium premium) {
		logger.info("Updating Premium with ID: {}", premium.getPremiumId());
		return premiumService.updatePremium(premium);

	}
}
