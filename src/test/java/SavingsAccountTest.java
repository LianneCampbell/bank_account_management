import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        // Initialize the SavingsAccount with a balance of 5000 and an interest rate of 2.5%
        SavingsAccount savingsAccount = new SavingsAccount("54321", "Jane Doe", 5000, 2.5);
        // Initialize a BankAccount to use with the applyInterest method
        bankAccount = new BankAccount(5000); // Start with the same balance
    }

    @Test
    void testApplyInterest() {
        // Call the static applyInterest method with the bankAccount object
        SavingsAccount.applyInterest(bankAccount); // Correct usage of static method

        // Assert that the balance is correct after applying 2.5% interest (5000 + 125)
        assertEquals(5125, Account.getBalance());
    }
}