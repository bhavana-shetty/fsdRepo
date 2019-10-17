package com.mycompany.single_inheritance.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
@DiscriminatorValue("Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Account_holder;
	private long Account_Number;
	private String IFSC_Code;

	public Account() {
	}

	public Account(String Account_holder, long Account_number, String IFSC_Code) {
		this.Account_holder = Account_holder;
		this.Account_Number = Account_number;
		this.IFSC_Code = IFSC_Code;
	}
}