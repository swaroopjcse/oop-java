package intro;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
  int number = 0;
  Random rng = new Random();

  public NumberGuessGame() {
    this.number = rng.nextInt(100) + 1;
  }

  public void play() {
    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("I have selected a number between 1 and 100.");
    System.out.println("Try to guess it!\n");

    int guess = 0;
    Scanner input = new Scanner(System.in);
    while (guess != number) {
      System.out.println("Make a guess: ");
      guess = input.nextInt();

      if (guess < number) {
        System.out.println("Too low!");
      } else if (guess > number) {
        System.out.println("Too high!");
      }
    }
    System.out.println("Congratulations!");
    input.close();
  }
}
