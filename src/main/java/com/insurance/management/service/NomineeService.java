package com.insurance.management.service;

import java.util.List;

import com.insurance.management.model.Nominee;

public interface NomineeService {

	// For adding Nominee
	Nominee addNominee(Nominee nominee);

	// For List of Nominee
	List<Nominee> getAllNominee();

	// For Nominee by single Id
	Nominee getNomineeById(Integer nomineeId);

	// For Delete Nominee Data
	void deleteNominee(Integer nomineeId);

	//For Update Nominee
	Nominee updateNominee(Nominee nominee);
	
}
