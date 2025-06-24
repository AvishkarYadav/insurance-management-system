package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Nominee;
import com.insurance.management.model.Policy;
import com.insurance.management.repository.NomineeRepository;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.service.NomineeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NomineeServiceImpl implements NomineeService {

	@Autowired
	private NomineeRepository nomineeRepository;

	@Autowired
	private PolicyRepository policyRepository;

	private static final Logger logger = LoggerFactory.getLogger(NomineeServiceImpl.class);

	@Override
	public Nominee addNominee(Nominee nominee) {
		logger.info("Adding new nominee: {}", nominee.getNomineeId());
		if (nominee.getPolicy() == null || nominee.getPolicy().getPolicyId() == null) {
			throw new IllegalArgumentException("Policy ID must not be null");
		}
		Integer policyId = nominee.getPolicy().getPolicyId(); // fetch policyId

		// fetching full policy entity from Database
		Policy policy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy Not Found with Id" + policyId));
		nominee.setPolicy(policy);
		logger.info("Nominee added successfully with ID: {}", nominee.getNomineeId());
		return nomineeRepository.save(nominee);
	}

	@Override
	public List<Nominee> getAllNominee() {
		logger.info("Fetching list of Nominees ");
		return nomineeRepository.findAll();
	}

	@Override
	public Nominee getNomineeById(Integer nomineeId) {
		logger.info("Fetching Nominee by ID: {}", nomineeId);
		return nomineeRepository.findById(nomineeId)
				.orElseThrow(() -> new RuntimeException("Nominee Not found with ID" + nomineeId));
	}

	@Override
	public void deleteNominee(Integer nomineeId) {
		logger.info("Deleting cusotmer Data with ID: {}", nomineeId);

		nomineeRepository.deleteById(nomineeId);
		logger.info("Deleted cusotmer Data with ID: {}", nomineeId);

	}

	@Override
	public Nominee updateNominee(Nominee nominee) {
		logger.info("Updating Nominee data with ID: {}", nominee.getNomineeId());

		Integer id = nominee.getNomineeId();
		Nominee existing = nomineeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Nominee not found with ID " + id));

		existing.setNomineeNumber(nominee.getNomineeNumber());
		existing.setFullName(nominee.getFullName());
		existing.setRelation(nominee.getRelation());
		existing.setAge(nominee.getAge());
		logger.info("Updated Nominee data with ID: {}", nominee.getNomineeId());
		return nomineeRepository.save(existing);

	}

}
