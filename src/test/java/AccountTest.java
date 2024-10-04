import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("12345", "John Doe", 5000);
    }

    @Test
    void testDeposit() {
        Account.deposit(1000);
        assertEquals(6000, Account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        account.withdraw(3000);
        assertEquals(2000, Account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.withdraw(6000);
        assertEquals(5000, Account.getBalance());  // Balance should remain unchanged
    }

    @Test
    void testCheckBalance() {
        assertEquals(5000, Account.getBalance());
    }
}