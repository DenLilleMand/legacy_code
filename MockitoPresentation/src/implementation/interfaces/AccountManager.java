package implementation.interfaces;

import implementation.Account;

public interface AccountManager 
{
	Account findAccountForUser(String userId);
	void updateAccount(Account account);
}