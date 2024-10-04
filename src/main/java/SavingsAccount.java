public class SavingsAccount extends Account {
    private static double interestRate = 0;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        SavingsAccount.interestRate = interestRate;
    }

    public static void applyInterest(BankAccount bankAccount) {
        double interest = getBalance() * (interestRate / 100);
        depositSilently(interest); // Use the silent deposit
        String interestMessage = "Interest applied: " + interest;
        bankAccount.addSavingsTransaction(interestMessage); // Add to bank account transaction history
        System.out.println(interestMessage);
    }

    // Adjusting viewBalanceWithInterest to prevent double interest calculation
    public static void viewBalanceWithInterest() {
        double totalBalance = getBalance(); // Do not add interest here
        System.out.println("\nSavings Account Balance (excluding interest): " + totalBalance);
    }

    public static void deposit(double amount, BankAccount bankAccount) {
        Account.depositSilently(amount); // This will print the deposit message
        String depositMessage = "Deposited to Savings Account: " + amount + ", New Balance: " + getBalance();
        bankAccount.addSavingsTransaction(depositMessage); // Log to the bank account transaction history
    }

    // Silent deposit method for internal use
    public static void depositSilently(double amount) {
        Account.deposit(amount); // Call the parent class's silent deposit method
    }
}