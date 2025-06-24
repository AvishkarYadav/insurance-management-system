package com.insurance.management.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.management.model.Policy;
import com.insurance.management.model.Premium;
import com.insurance.management.repository.PolicyRepository;
import com.insurance.management.repository.PremiumRepository;
import com.insurance.management.service.PremiumService;

@Service
public class PremiumServiceImpl implements PremiumService {

	@Autowired
	private PremiumRepository premiumRepository;

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public Premium addPremium(Premium premium, Integer policyId) {
		Policy policy = policyRepository.findById(policyId)
				.orElseThrow(() -> new RuntimeException("PolicyId Not Found :"));
		premium.setPolicy(policy);
		premiumRepository.save(premium);
		return premium;
	}

	@Override
	public Premium getPremiumById(Integer premiumId) {
		return premiumRepository.findById(premiumId).orElseThrow(() -> new RuntimeException("Premium Not Found :"));
	}

	@Override
	public List<Premium> getAllPremuims() {
		return premiumRepository.findAll();
	}

	@Override
	public List<Premium> allPremiumsByPolicyId(Integer policyId) {
		return premiumRepository.findByPolicyPolicyId(policyId);

	}

	@Override
	public void deletePremium(Integer premiumId) {
		premiumRepository.deleteById(premiumId);
	}

}
