package lab05;

import java.time.LocalDateTime;

public class Transaction {
  private String transactionID;
  private double amount;
  private boolean creditTransaction;
  private LocalDateTime timestamp;

  public Transaction(String transactionID, double amount, boolean creditTransaction) {
    this.transactionID = transactionID;
    this.amount = amount;
    this.creditTransaction = creditTransaction;
    this.timestamp = LocalDateTime.now();
  }

  public String getTransactionID() {
    return transactionID;
  }

  public double getAmount() {
    return amount;
  }

  public boolean isCreditTransaction() {
    return creditTransaction;
  }

  public LocalDateTime getTimeStamp() {
    return timestamp;
  }
}
