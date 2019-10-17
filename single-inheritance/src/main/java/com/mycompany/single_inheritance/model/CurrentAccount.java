package com.mycompany.single_inheritance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Current_Account")
public class CurrentAccount extends Account {
	private long balance;
	private long deposite;

	public CurrentAccount() {
	}

	public CurrentAccount(String Account_holder, long Account_number, String IFSC_Code, long balance, long deposite) {
		super(Account_holder,Account_number, IFSC_Code);
		this.balance = balance;
		this.deposite = deposite;
	}
}