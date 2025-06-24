package com.insurance.management.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "premium")
public class Premium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer premiumId;
	private Double amount;
	private LocalDate dueDate;
	private LocalDate paymentDate;
	private String status;
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Integer getPremiumId() {
		return premiumId;
	}

	public void setPremiumId(Integer premiumId) {
		this.premiumId = premiumId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Premium [premiumId=" + premiumId + ", amount=" + amount + ", dueDate=" + dueDate + ", paymentDate="
				+ paymentDate + ", status=" + status + "]";
	}

}
