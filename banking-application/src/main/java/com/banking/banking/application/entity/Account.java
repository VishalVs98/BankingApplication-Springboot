package com.banking.banking.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="accounts")
@Entity
public class Account {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long accountId;
@Column(name="account_holder_name")
private String accountHolderName;
private double balance;
public long getAccountId() {
	return accountId;
}
public void setAccountId(long accountId) {
	this.accountId = accountId;
}
public String getAccountHolderName() {
	return accountHolderName;
}
public void setAccountHolderName(String accountHolderName) {
	this.accountHolderName = accountHolderName;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public Account(long accountId, String accountHolderName, double balance) {
	super();
	this.accountId = accountId;
	this.accountHolderName = accountHolderName;
	this.balance = balance;
}
public Account() {
	super();
	// TODO Auto-generated constructor stub
}

}
