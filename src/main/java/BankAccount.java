import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {
    private double balance;
    private List<String> transactionHistory;
    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: " + initialBalance);
        logger.info("Account created with initial balance: {}", initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount + ", New Balance: " + balance);
        logger.info("Deposited: {}, New Balance: {}", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount + ", New Balance: " + balance);
        logger.info("Withdrew: {}, New Balance: {}", amount, balance);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public double getBalance() {
        return balance;
    }
}