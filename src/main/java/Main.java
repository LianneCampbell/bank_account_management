public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create a savings account
        SavingsAccount savingsAccount = new SavingsAccount("12345", "John Doe", 5000, 2.5);
        bank.createAccount(savingsAccount);

        // Deposit into the account
        savingsAccount.deposit(1000);
        savingsAccount.checkBalance();

        // Apply interest
        savingsAccount.applyInterest();
        savingsAccount.checkBalance();

        // Withdraw from the account
        savingsAccount.withdraw(3000);
        savingsAccount.checkBalance();

        // Remove the account
        bank.removeAccount("12345");
    }
}