package designprinciples.railseva.bad.dip;

// Low-level concrete network driver
public class BsnlSmsGatewayDriver {
  public void sendSms(String phone, String text) {
    System.out.println("Sending raw HTTP payload to BSNL SMS Gateway: " + text);
  }
}