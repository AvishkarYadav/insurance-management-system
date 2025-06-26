package com.insurance.management.mapper;

import java.util.ArrayList;
import java.util.List;

import com.insurance.management.dto.PolicyDTO;
import com.insurance.management.model.Policy;

public class PolicyMapper {

	public static Policy toEntity(PolicyDTO dto) {
		Policy policy = new Policy();
		policy.setPolicyId(dto.getPolicyId());
		policy.setPolicyNumber(dto.getPolicyNumber());
		policy.setPolicyType(dto.getPolicyType());
		policy.setStartDate(dto.getStartDate());
		policy.setEndDate(dto.getEndDate());
		policy.setCoverageAmount(dto.getCoverageAmount());
		policy.setPremiumAmount(dto.getPremiumAmount());
		return policy;
	}

	public static PolicyDTO toDto(Policy policy) {
		PolicyDTO dto = new PolicyDTO();
		dto.setPolicyId(policy.getPolicyId());
		dto.setPolicyNumber(policy.getPolicyNumber());
		dto.setPolicyType(policy.getPolicyType());
		dto.setStartDate(policy.getStartDate());
		dto.setEndDate(policy.getEndDate());
		dto.setCoverageAmount(policy.getCoverageAmount());
		dto.setPremiumAmount(policy.getPremiumAmount());
		return dto;
	}

	public static List<PolicyDTO> toDtoList(List<Policy> policies) {
		List<PolicyDTO> dtoList = new ArrayList<>();
		for (Policy policy : policies) {
			dtoList.add(toDto(policy));
		}
		return dtoList;
	}
}
