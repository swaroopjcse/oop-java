package lab11.dip;

// Low-level concrete infrastructure class
public class SbiNodalNeftGateway {
  public void executeNeftPayout(String beneficiaryAccount, double amountInInr) {
    System.out.printf("SBI Nodal API: Transferred INR %.2f to Account %s%n", amountInInr, beneficiaryAccount);
  }
}