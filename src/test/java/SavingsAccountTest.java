import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount("54321", "Jane Doe", 5000, 2.5);
    }

    @Test
    void testApplyInterest() {
        savingsAccount.applyInterest();
        assertEquals(5125, savingsAccount.getBalance());  // 2.5% interest on 5000
    }
}