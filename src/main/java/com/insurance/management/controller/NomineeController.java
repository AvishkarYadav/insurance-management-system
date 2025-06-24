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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/nominee")
public class NomineeController {

	@Autowired
	private NomineeService service;

	private static final Logger logger = LoggerFactory.getLogger(NomineeController.class);

	// For adding Nominee

	@PostMapping("/add")
	Nominee addNominee(@RequestBody Nominee nominee) {
		logger.info("Adding new Nominee: {}",nominee.getNomineeId());
		return service.addNominee(nominee);
		
	}

	// For List of Nominee
	@GetMapping("/list")
	List<Nominee> getAllNominee() {
		logger.info("Fetching all nominees...");

		return service.getAllNominee();
	}

	// For Nominee by single Id
	@GetMapping("/getbyId/{nomineeId}")
	Nominee getNomineeById(@PathVariable("nomineeId") Integer nomineeId) {
		logger.info("Fetching Policy data by ID: {}", nomineeId);
		return service.getNomineeById(nomineeId);
	}

	// For Delete Nominee Data
	@DeleteMapping("/delete/{nomineeId}")
	void deleteNominee(@PathVariable("nomineeId") Integer nomineeId) {
		logger.info("Deleting Nominee with ID: {}", nomineeId);
		service.deleteNominee(nomineeId);
	}

	// For Update Nominee Data
	@PutMapping("/update")
	public Nominee updateNominee(@RequestBody Nominee nominee) {
		logger.info("Updating Nominee with ID: {}", nominee.getNomineeId());
		return service.updateNominee(nominee);

	}

}
