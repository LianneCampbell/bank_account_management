import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountEdgeCaseTest {

    @Test
    public void testWithdrawExceedBalance() {
        BankAccount account = new BankAccount(500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600); // Exceeds balance
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50); // Negative amount
        });
        assertEquals("Withdraw amount must be positive", exception.getMessage());
    }

    @Test
    public void testDepositNegativeAmount() {
        BankAccount account = new BankAccount(500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100); // Invalid negative deposit
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    public void testDepositZeroAmount() {
        BankAccount account = new BankAccount(500);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0); // Zero deposit
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
}