package book.polymorphism;

import java.awt.*;
import javax.swing.*;

public class FrameTester {
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    final int FIELD_WIDTH = 20;
    JTextField textField = new JTextField(FIELD_WIDTH);
    textField.setText("Click a button!");

    JButton helloButton = new JButton("Say Hello");
    helloButton.addActionListener(event -> textField.setText("Hello!"));
    JButton goodbyeButton = new JButton("Say Goodbye");
    goodbyeButton.addActionListener(event -> textField.setText("Goodbye!"));

    frame.setLayout(new FlowLayout());

    frame.add(helloButton);
    frame.add(goodbyeButton);
    frame.add(textField);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}