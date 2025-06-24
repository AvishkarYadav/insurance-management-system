package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Policy;
import com.insurance.management.model.Premium;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.repository.PremiumRepository;
import com.insurance.management.service.PremiumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PremiumServiceImpl implements PremiumService {

	@Autowired
	private PremiumRepository premiumRepository;

	@Autowired
	private PolicyRepository policyRepository;

	private static final Logger logger = LoggerFactory.getLogger(PremiumServiceImpl.class);

	@Override
	public Premium addPremium(Premium premium, Integer policyId) {
		logger.info("Adding new premium: {}", premium.getPremiumId());
		Policy policy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("PolicyId Not Found :"));
		premium.setPolicy(policy);
		premiumRepository.save(premium);
		logger.info("Premium added successfully with ID: {}", premium.getPremiumId());

		return premium;
	}

	@Override
	public Premium getPremiumById(Integer premiumId) {
		logger.info("Fetching Premium by ID: {}", premiumId);
		return premiumRepository.findById(premiumId).orElseThrow(() -> new RuntimeException("Premium Not Found :"));
	}

	@Override
	public List<Premium> getAllPremuims() {
		logger.info("Fetching list of Premiums ");
		return premiumRepository.findAll();
	}

	@Override
	public List<Premium> allPremiumsByPolicyId(Integer policyId) {
		logger.info("Fetching list of Premiums By PolicyID: {}", policyId);
		return premiumRepository.findByPolicyPolicyId(policyId);

	}

	@Override
	public void deletePremium(Integer premiumId) {
		logger.info("Deleting cusotmer Data with ID: {}", premiumId);

		premiumRepository.deleteById(premiumId);
		logger.info("Deleted cusotmer Data with ID: {}", premiumId);

	}

	@Override
	public Premium updatePremium(Premium premium) {
		logger.info("Updating premium data with ID: {}", premium.getPremiumId());

		Integer premiumId = premium.getPremiumId();
		Premium existing = premiumRepository.findById(premiumId)
				.orElseThrow(() -> new RuntimeException("Premium not found with ID " + premiumId));

		existing.setAmount(premium.getAmount());
		existing.setDueDate(premium.getDueDate());
		existing.setPaymentDate(premium.getPaymentDate());
		existing.setStatus(premium.getStatus());
		logger.info("Updated premium data with ID: {}", premium.getPremiumId());

		return premiumRepository.save(existing);

	}

}
