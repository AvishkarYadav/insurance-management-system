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

import com.insurance.management.model.Nominee;
import com.insurance.management.service.NomineeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag(name = "Nominee", description = "CRUD operations for nominee details associated with policies")
@RestController
@RequestMapping("/api/nominee")
public class NomineeController {

	@Autowired
	private NomineeService service;

	private static final Logger logger = LoggerFactory.getLogger(NomineeController.class);

	// For adding Nominee

	@PostMapping("/add")
	@Operation(summary = "Add Nominee Data", description = "Rest API used to add nominee data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	Nominee addNominee(@RequestBody Nominee nominee) {
		logger.info("Adding new Nominee: {}", nominee.getNomineeId());
		return service.addNominee(nominee);

	}

	// For List of Nominee
	@GetMapping("/list")
	@Operation(summary = "Fetch Nominee List", description = "Rest API used to fetch nominee list")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	List<Nominee> getAllNominee() {
		logger.info("Fetching all nominees...");

		return service.getAllNominee();
	}

	// For Nominee by single Id
	@GetMapping("/getbyId/{nomineeId}")
	@Operation(summary = "Fetch Nominee Data By Id", description = "Rest API used to fetch nominee data by id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	Nominee getNomineeById(@PathVariable("nomineeId") Integer nomineeId) {
		logger.info("Fetching Policy data by ID: {}", nomineeId);
		return service.getNomineeById(nomineeId);
	}

	// For Delete Nominee Data
	@DeleteMapping("/delete/{nomineeId}")
	@Operation(summary = "Delete Nominee Data", description = "Rest API used to delete nominee data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	void deleteNominee(@PathVariable("nomineeId") Integer nomineeId) {
		logger.info("Deleting Nominee with ID: {}", nomineeId);
		service.deleteNominee(nomineeId);
	}

	// For Update Nominee Data
	@PutMapping("/update")
	@Operation(summary = "Update Nominee Data", description = "Rest API used to update nominee data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation") })
	public Nominee updateNominee(@RequestBody Nominee nominee) {
		logger.info("Updating Nominee with ID: {}", nominee.getNomineeId());
		return service.updateNominee(nominee);

	}

}
