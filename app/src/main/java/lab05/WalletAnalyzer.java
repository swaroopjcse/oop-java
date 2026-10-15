package lab05;

import java.time.LocalDateTime;

public class WalletAnalyzer {

  private Wallet wallet;

  public double totalAmountCredited() {
    return wallet.getBalance();
  }

  public double totalAmountDebited() {
    return 0;
  }

  public double amountSpentBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
    return 0;
  }
}
