# Bank Account Management System

This project is a **Bank Account Management System** implemented in Java. It provides basic banking functionalities, including creating accounts, making deposits and withdrawals, checking balances, viewing transaction history, and logging all transactions to a file.

## Features

### 1. Command-Line Interface (CLI)
The application includes a user-friendly CLI that allows users to interact with the system through the terminal. The CLI provides options for creating accounts, making transactions, and checking balances.

**Commands available in the CLI:**
- **Create Account**: Allows users to create new savings accounts with an account number, account holder name, and initial balance.
- **Deposit**: Enables users to deposit a specified amount into an existing account.
- **Withdraw**: Allows users to withdraw a specified amount from an existing account, provided there are sufficient funds.
- **Check Balance**: Displays the current balance of a specified account.
- **Transfer to Savings**: Transfers from main account to savings account.
- **Check Savings Balance**: Check the savings account balance with interest.
- **View Transaction History**: Shows a list of all transactions (deposits, withdrawals) made on an account.
- **Exit**: Closes the application.

### 2. Account Types
- **Savings Account**: Supports interest calculation. Users can apply interest to their savings account, which gets added to their balance.

### 3. Transaction History
Every deposit and withdrawal operation is recorded. Users can view the entire transaction history for an account, including details of all deposits, withdrawals, and interest applications.

### 4. Logging
All transactions are logged into a file named `transactions.log`. This file records each transaction made by the user, including deposits, withdrawals, and account creation.

**Log file features:**
- Appends transaction records to the file every time an operation is performed.
- Stored in the root directory of the project.

### 5. Exception Handling
The system includes error handling to ensure:
- No negative deposits or withdrawals.
- Withdrawals cannot exceed the current balance.
- Initial balance must be non-negative.

### 6. Unit Tests
Basic unit tests have been implemented to ensure functionality. These tests include:
- Testing deposits and withdrawals.
- Checking for invalid deposit and withdrawal attempts.
- Ensuring interest is applied correctly in savings accounts.

## How to Run

1. Clone the repository and navigate to the project directory.
2. Compile the Java files using a Java compiler:
   ```bash
   javac *.java
3. Run the application:
   ```bash
   java Main
4. Follow the on-screen instructions to interact with the bank system.

