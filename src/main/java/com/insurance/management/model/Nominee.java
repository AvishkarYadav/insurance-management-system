package com.insurance.management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nominee")
public class Nominee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nomineeId;
	private Integer nomineeNumber;
	private String fullName;
	private String relation;
	private int age;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id")
	@JsonBackReference(value = "policy-nominee")
	private Policy policy;

	public Integer getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(Integer nomineeId) {
		this.nomineeId = nomineeId;
	}

	public Integer getNomineeNumber() {
		return nomineeNumber;
	}

	public void setNomineeNumber(Integer nomineeNumber) {
		this.nomineeNumber = nomineeNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Nominee [nomineeId=" + nomineeId + ", nomineeNumber=" + nomineeNumber + ", fullName=" + fullName
				+ ", relation=" + relation + ", age=" + age + "]";
	}

}
