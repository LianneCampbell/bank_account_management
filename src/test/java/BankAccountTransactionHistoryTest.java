import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTransactionHistoryTest {

    @Test
    public void testInitialTransactionHistory() {
        BankAccount account = new BankAccount(500);
        List<String> history = account.getTransactionHistory();
        assertEquals(1, history.size()); // Only account creation event
        assertTrue(history.get(0).contains("Account created with initial balance: 500"));
    }

    @Test
    public void testTransactionHistoryAfterDepositAndWithdrawal() {
        BankAccount account = new BankAccount(500);
        account.deposit(100);
        account.withdraw(50);

        List<String> history = account.getTransactionHistory();
        assertEquals(3, history.size()); // 3 transactions: account creation, deposit, withdrawal
        assertTrue(history.get(1).contains("Deposited: 100"));
        assertTrue(history.get(2).contains("Withdrew: 50"));
    }
}