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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag(name = "Premium", description = "Handle premium payments, schedule, and history")
@RestController
@RequestMapping("/api/premium")
public class PremiumController {

	@Autowired
	private PremiumService premiumService;

	private static final Logger logger = LoggerFactory.getLogger(PremiumController.class);

	// For add premium
	@PostMapping("/add/{policyId}")
	@Operation(summary = "Add Premium Data", description = "Rest API used to add premium data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	Premium addPremium(@RequestBody Premium premium, @PathVariable("policyId") Integer policyId) {
		logger.info("Adding new Premium: {}", premium.getPremiumId());
		return premiumService.addPremium(premium, policyId);
	}

	// for fetch
	@GetMapping("/getPremiumById/{premiumId}")
	@Operation(summary = "Fetch Premium Data By ID", description = "Rest API used to fetch premium data by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	Premium getPremiumById(@PathVariable("premiumId") Integer premiumId) {
		logger.info("Fetching premium data by ID: {}", premiumId);

		return premiumService.getPremiumById(premiumId);
	}

	// List of premiums all
	@GetMapping("/list")
	@Operation(summary = "Fetch Premium Data list", description = "Rest API used to fetch premium data list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	List<Premium> getAllPremuims() {
		logger.info("Fetching all premiums...");

		return premiumService.getAllPremuims();
	}

	// For List of premiums by policy
	@GetMapping("/listByPolicyId/{policyId}")
	@Operation(summary = "Fetch Premium Data list By PolicyId", description = "Rest API used to fetch premium data list by policyid")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	List<Premium> allPremiumsByPolicyId(@PathVariable("policyId") Integer policyId) {
		return premiumService.allPremiumsByPolicyId(policyId);
	}

	// Delete premium from data
	@DeleteMapping("/delete/{premiumId}")
	@Operation(summary = "Delete Premium Data", description = "Rest API used to delete premium data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	void deletePremium(@PathVariable("premiumId") Integer premiumId) {
		logger.info("Deleting premium with ID: {}", premiumId);
		premiumService.deletePremium(premiumId);
	}

	// Update Premium Data
	@PutMapping("/update")
	@Operation(summary = "Update Premium Data", description = "Rest API used to update premium data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	public Premium updatePremium(@RequestBody Premium premium) {
		logger.info("Updating Premium with ID: {}", premium.getPremiumId());
		return premiumService.updatePremium(premium);

	}
}
