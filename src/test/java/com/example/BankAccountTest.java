package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testCreateAccount() {

        BankAccount account = new BankAccount("John", 1000);

        assertEquals("John", account.getAccountHolder());
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testInvalidAccountHolder() {

        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("", 100));
    }

    @Test
    void testNegativeInitialBalance() {

        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("John", -10));
    }

    @Test
    void testDeposit() {

        BankAccount account = new BankAccount("John", 100);

        account.deposit(200);

        assertEquals(300, account.getBalance());
    }

    @Test
    void testDepositZero() {

        BankAccount account = new BankAccount("John", 100);

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0));
    }

    @Test
    void testDepositNegative() {

        BankAccount account = new BankAccount("John", 100);

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-20));
    }

    @Test
    void testWithdraw() {

        BankAccount account = new BankAccount("John", 500);

        account.withdraw(200);

        assertEquals(300, account.getBalance());
    }

    @Test
    void testWithdrawZero() {

        BankAccount account = new BankAccount("John", 500);

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(0));
    }

    @Test
    void testWithdrawNegative() {

        BankAccount account = new BankAccount("John", 500);

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-50));
    }

    @Test
    void testWithdrawInsufficientBalance() {

        BankAccount account = new BankAccount("John", 200);

        assertThrows(IllegalStateException.class,
                () -> account.withdraw(500));
    }

    @Test
    void testTransfer() {

        BankAccount sender = new BankAccount("John", 1000);
        BankAccount receiver = new BankAccount("Alice", 300);

        sender.transfer(receiver, 250);

        assertEquals(750, sender.getBalance());
        assertEquals(550, receiver.getBalance());
    }

    @Test
    void testTransferNullAccount() {

        BankAccount sender = new BankAccount("John", 1000);

        assertThrows(IllegalArgumentException.class,
                () -> sender.transfer(null, 100));
    }

    @Test
    void testTransferInsufficientBalance() {

        BankAccount sender = new BankAccount("John", 100);
        BankAccount receiver = new BankAccount("Alice", 100);

        assertThrows(IllegalStateException.class,
                () -> sender.transfer(receiver, 500));
    }
}