package com.mycompany.single_inheritance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Savings_Account")
public class SavingsAccount extends Account {
	private long withdraw;
	private long balance;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(String Account_holder, long Account_number, String IFSC_Code, long balance, long withdraw) {
		super(Account_holder,Account_number, IFSC_Code);
		this.balance=balance;
		this.withdraw=withdraw;
	}
}
