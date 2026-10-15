package lab05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wallet {
    private final String upiId;
    private double balance;
    private final List<Transaction> transactions;

    public Wallet(String upiId, double initialBalance) {
        if (upiId == null || upiId.trim().isEmpty()) {
            throw new IllegalArgumentException("UPI ID cannot be null or empty.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.upiId = upiId;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public void addMoney(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be strictly positive.");
        }
        this.balance += amount;
        transactions.add(new Transaction("TXN-CR-" + System.currentTimeMillis(), amount, true));
    }

    public boolean deductMoney(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be strictly positive.");
        }
        if (amount > this.balance) {
            return false; // Insufficient funds
        }
        this.balance -= amount;
        transactions.add(new Transaction("TXN-DR-" + System.currentTimeMillis(), amount, false));
        return true;
    }

    public List<Transaction> getStatement() {
        return Collections.unmodifiableList(transactions);
    }

    public String getUpiId() {
        return upiId;
    }

    public double getBalance() {
        return balance;
    }
}