package com.hnn.mock.junit.account;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAccountService {

	@Test
	public void testTransferOk() {
		MockAccountManager accountManager = new MockAccountManager(); 
		Account senderAccount = new Account("1", 200);
		Account beneficiaryAccount = new Account("2", 100); 
		accountManager.addAccount("1", senderAccount);
		accountManager.addAccount("2", beneficiaryAccount);
		AccountService accountService = new AccountService(); 
		accountService.setAccountManager(accountManager);
		accountService.transfer("1", "2", 50);
		
		assertEquals(150, senderAccount.getBalance());
		assertEquals(150, beneficiaryAccount.getBalance());
	}
}
