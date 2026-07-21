package com.example;

public class BankAccount {

    private final String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder cannot be empty");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }

        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }

        balance -= amount;
    }

    public void transfer(BankAccount receiver, double amount) {

        if (receiver == null) {
            throw new IllegalArgumentException("Receiver account cannot be null");
        }

        withdraw(amount);
        receiver.deposit(amount);
    }
}