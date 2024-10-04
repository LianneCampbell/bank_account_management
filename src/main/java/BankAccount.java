import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("\nInitial balance must be non-negative");
        }
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();

        // Add the initial account creation event to transaction history
        String creationMessage = "Account created with initial balance: " + initialBalance;
        transactionHistory.add(creationMessage); // Record in transaction history
        logTransaction(creationMessage); // Log to the file
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("\nDeposit amount must be positive");
        }
        balance += amount;
        String depositMessage = "Deposited: " + amount + ", New Balance: " + balance;
        transactionHistory.add(depositMessage); // Add to transaction history
        logTransaction(depositMessage); // Log to the file
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("\nWithdraw amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("\nInsufficient funds");
        }
        balance -= amount;
        String withdrawalMessage = "Withdrew: " + amount + ", New Balance: " + balance;
        transactionHistory.add(withdrawalMessage); // Add to transaction history
        logTransaction(withdrawalMessage); // Log to the file
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void addSavingsTransaction(String message) {
        transactionHistory.add(message);
        logTransaction(message);
    }

    private void logTransaction(String message) {
        try (FileWriter writer = new FileWriter("transactions.log", true)) { // Appends to transactions.log
            writer.write(message + "\n"); // Writes the transaction message to the log
        } catch (IOException e) {
            System.err.println("Error logging transaction: " + e.getMessage());
        }
    }
}