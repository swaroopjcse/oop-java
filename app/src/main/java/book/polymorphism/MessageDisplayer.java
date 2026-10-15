package book.polymorphism;

import javax.swing.*;

public class MessageDisplayer {

   public static void main(String[] args) {
      JOptionPane.showMessageDialog(
      null,
      "Hello, World!",
      "Message",
      JOptionPane.INFORMATION_MESSAGE,
      new ImageIcon("./app/src/main/resources/globe.gif")
   );
      System.exit(0);
   }

}
