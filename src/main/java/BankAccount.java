import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private List<String> transactionHistory; // stores transaction details

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be greater than zero");
        balance += amount;
        transactionHistory.add("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount + ", New Balance: " + balance);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}