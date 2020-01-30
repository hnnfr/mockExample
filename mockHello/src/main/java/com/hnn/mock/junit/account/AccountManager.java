package com.hnn.mock.junit.account;

public interface AccountManager {
	Account findAccountForUser(String userId);
	void updateAccount(Account account);
}
