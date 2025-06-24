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

@RestController
@RequestMapping("/api/premium")
public class PremiumController {

	@Autowired
	private PremiumService premiumService;

	// For add premium
	@PostMapping("/add/{policyId}")
	Premium addPremium(@RequestBody Premium premium, @PathVariable("policyId") Integer policyId) {
		return premiumService.addPremium(premium, policyId);
	}

	// for fetch
	@GetMapping("/getPremiumById/{premiumId}")
	Premium getPremiumById(@PathVariable("premiumId") Integer premiumId) {
		return premiumService.getPremiumById(premiumId);
	}

	// List of premiums all
	@GetMapping("/list")
	List<Premium> getAllPremuims() {
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
		premiumService.deletePremium(premiumId);
	}

	@PutMapping("/update")
	public Premium updatePremium(@RequestBody Premium premium) {
		return premiumService.updatePremium(premium);

	}
}
