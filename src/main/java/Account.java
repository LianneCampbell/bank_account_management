public class Account {
    private final String accountNumber;
    private final String holderName;
    private static double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        Account.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public static double getBalance() {
        return balance;
    }

    // Update deposit method
    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposit successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Add a silent deposit method
    protected static void depositSilently(double amount) {
        if (amount > 0) {
            balance += amount; // Update balance without printing
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Account balance: " + balance);
    }
}