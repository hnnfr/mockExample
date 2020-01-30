package com.hnn.mock.junit.account;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManager implements AccountManager {
	
	private Map<String, Account> accounts = new HashMap<String, Account>();
	
	public void addAccount(String userId, Account account) {
		accounts.put(userId, account); 
	}

	@Override
	public Account findAccountForUser(String userId) {
		return accounts.get(userId);
	}

	@Override
	public void updateAccount(Account account) {
		// do nothing
	}

}
