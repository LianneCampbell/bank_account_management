import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(0); // Initial balance
        SavingsAccount savingsAccount = new SavingsAccount("S123", "Jane Doe", 0, 5); // 5% interest rate

        while (true) {
            System.out.println("\n---------------------------------------------------");
            System.out.println("\n-  Welcome to the Bank Account Management System  -");
            System.out.println("\n---------------------------------------------------");
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Transfer Funds to Savings Account");
            System.out.println("5. Check Savings Account Balance");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.println("\n---------------------------------------------------");

            System.out.println("\nPlease enter your option:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n---------------- Deposit Funds --------------------");
                    double depositAmount;
                    try {
                        System.out.print("\nEnter deposit amount: ");
                        depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("\n---------------- Deposit Confirmed ----------------");
                        System.out.println("\nDeposited: " + depositAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n---------------- Deposit Declined -----------------");
                        System.out.println("\nError: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("\n---------------- Deposit Declined -----------------");
                        System.out.println("\nInvalid input. Please enter a valid number.");
                        scanner.next(); // Clear the invalid input
                    }
                    break;
                case 2:
                    System.out.println("\n---------------- Withdraw Funds -------------------");
                    System.out.print("\nEnter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawAmount);
                        System.out.println("\n--------------- Withdraw Confirmed ----------------");
                        System.out.println("\nWithdrawn: " + withdrawAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n---------------- Withdraw Declined ----------------");
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\n------------- Check Account Balance ---------------");
                    System.out.println("\nCurrent Balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("\n---------------- Transfer Funds to Savings Account -------------------");
                    System.out.print("\nEnter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    try {
                        account.withdraw(transferAmount); // Withdraw from the BankAccount
                        System.out.println("\n--------------- Transfer Confirmed ---------------");
                        SavingsAccount.deposit(transferAmount, account); // Deposit into the SavingsAccount and log
                        SavingsAccount.applyInterest(account); // Apply interest on the savings account

                        System.out.println("Transferred: " + transferAmount + " to Savings Account.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n---------------- Transfer Declined ---------------");
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\n-------------- Check Savings Balance --------------");
                    SavingsAccount.viewBalanceWithInterest(); // Only shows the balance, no double interest
                    break;
                case 6:
                    System.out.println("\n------------ Check Transaction History ------------");
                    System.out.println("\nTransaction History:");
                    for (String transaction : account.getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    break;
                case 7:
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("\nExiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\n---------------------------------------------------");
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}