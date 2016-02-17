package implementation.tests;

import implementation.Account;
import implementation.AccountService;
import static org.junit.Assert.*;

import mocks.MockAccountManager;

public class TestAccountService 
{
	public void testTransferOk() 
	{
		MockAccountManager mockAccountManager = new MockAccountManager();

		Account senderAccount = new Account("1", 200);

		Account beneficiaryAccount = new Account("2", 100);

		mockAccountManager.addAccount("1", senderAccount);

		mockAccountManager.addAccount("2", beneficiaryAccount);

		AccountService accountService = new AccountService();

		accountService.setAccountManager(mockAccountManager);

		accountService.transfer("1", "2", 50);

		assertEquals(150, senderAccount.getBalance());

		assertEquals(150, beneficiaryAccount.getBalance());
	}
	/**Test der viser IOC */
	public void testFindAccountByUser() 
	{
		MockLog logger = new MockLog();
		MockConfiguration configuration = new MockConfiguration();
		configuration.setSQL("SELECT * [...]");
		DefaultAccountManager am = new DefaultAccountManager(logger,configuration);
		Account account = am.findAccountForUser("1234");

	}
}
