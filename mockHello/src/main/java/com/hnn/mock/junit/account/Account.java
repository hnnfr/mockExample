package com.hnn.mock.junit.account;

public class Account {
	private String accountId;
	private long balance;

	public Account(String accountId, long initialBalance) {
		super();
		this.accountId = accountId;
		this.balance = initialBalance;
	}

	public void debit(long amount) {
		balance -= amount; 
	}
	
	public void credit(long amount) {
		balance += amount;
	}

	public long getBalance() {
		return balance;
	}
}
