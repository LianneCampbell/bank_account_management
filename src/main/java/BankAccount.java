import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative");
        }
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        logTransaction("Account created with initial balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount + ", New Balance: " + balance);
        logTransaction("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount + ", New Balance: " + balance);
        logTransaction("Withdrew: " + amount + ", New Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    private void logTransaction(String message) {
        try (FileWriter writer = new FileWriter("transactions.log", true)) { // Appends to transactions.log
            writer.write(message + "\n"); // Writes the transaction message to the log
        } catch (IOException e) {
            System.err.println("Error logging transaction: " + e.getMessage());
        }
    }
}