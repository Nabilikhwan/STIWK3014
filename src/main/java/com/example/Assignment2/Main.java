package com.example.Assignment2;

public class Main {
    public static void main(String[] args) {
        // Create a bank account with initial balance of 1000
        BankAccountWithLock account = new BankAccountWithLock(1000.0);

        // Create and start multiple threads to perform operations
        Thread depositThread = new Thread(() -> {
            account.deposit(500.0);
            System.out.println("After deposit - Balance: " + account.getBalance());
        }, "Deposit-Thread");

        Thread withdrawThread = new Thread(() -> {
            account.withdraw(200.0);
            System.out.println("After withdrawal - Balance: " + account.getBalance());
        }, "Withdraw-Thread");

        Thread checkBalanceThread = new Thread(() -> {
            System.out.println("Balance check - Current: " + account.getBalance());
        }, "BalanceCheck-Thread");

        // Start all threads
        depositThread.start();
        withdrawThread.start();
        checkBalanceThread.start();

        // Wait for all threads to complete
        try {
            depositThread.join();
            withdrawThread.join();
            checkBalanceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final balance
        System.out.println("\nFinal Account Balance: " + account.getBalance());
    }
}

