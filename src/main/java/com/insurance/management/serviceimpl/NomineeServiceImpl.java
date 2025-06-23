package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Nominee;
import com.insurance.management.model.Policy;
import com.insurance.management.repository.NomineeRepository;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.service.NomineeService;

@Service
public class NomineeServiceImpl implements NomineeService {

	@Autowired
	private NomineeRepository nomineeRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Nominee addNominee(Nominee nominee) {
		if (nominee.getPolicy() == null || nominee.getPolicy().getPolicyId() == null) {
			throw new IllegalArgumentException("Policy ID must not be null");
		}
		Integer policyId = nominee.getPolicy().getPolicyId(); // fetch policyId

		// fetching full policy entity from Database
		Policy policy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("Policy Not Found with Id" + policyId));
		nominee.setPolicy(policy);
		return nomineeRepository.save(nominee);
	}

	@Override
	public List<Nominee> getAllNominee() {

		return nomineeRepository.findAll();
	}

	@Override
	public Nominee getNomineeById(Integer nomineeId) {

		return nomineeRepository.findById(nomineeId)
				.orElseThrow(() -> new RuntimeException("Nominee Not found with ID" + nomineeId));
	}

	@Override
	public void deleteNominee(Integer nomineeId) {

		nomineeRepository.deleteById(nomineeId);
	}

}
