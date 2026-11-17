package lab11.srp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CateringOrderProcessor {

  public void processMealOrder(String pnr, String passengerPhone, int vegThaliCount, int chaiCount) {
    if (vegThaliCount < 0 || chaiCount < 0 || (vegThaliCount + chaiCount == 0))
      throw new IllegalArgumentException("Order must contain at least one item.");

    // 1. Domain billing & GST calculation
    double subtotal = (vegThaliCount * 120.0) + (chaiCount * 20.0);
    double gst = subtotal * 0.05; // 5% Railway Catering GST
    double grandTotal = subtotal + gst;

    // 2. Local CSV file persistence
    try (BufferedWriter out = new BufferedWriter(new FileWriter("order.csv"))) {
      out.write(pnr + "," + vegThaliCount + "," + chaiCount + "," + grandTotal + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }

    // 3. SMS receipt formatting and dispatch
    String smsMsg = "RailSeva E-Catering: Order for PNR " + pnr
        + " confirmed. Total payable: INR " + String.format("%.2f", grandTotal);
    System.out.println("[SMS GATEWAY -> " + passengerPhone + "]: " + smsMsg);
  }

  public static void main(String[] args) {
    CateringOrderProcessor processor = new CateringOrderProcessor();
    processor.processMealOrder("PNR482910", "9876543210", 2, 2);
  }
}