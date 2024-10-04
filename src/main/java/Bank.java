import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created: " + account.getAccountNumber());
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    public void removeAccount(String accountNumber) {
        Account accountToRemove = findAccount(accountNumber);
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
            System.out.println("Account removed: " + accountNumber);
        }
    }
}