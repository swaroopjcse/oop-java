package inheritance.animals;

public class Dog extends Animal implements Pet {
  @Override
  public void eat() {
    System.out.println("Chew on a bone");
  }

  @Override
  public void sleep() {
    System.out.println("Alert asleep");
  }

  @Override
  public void play() {
    System.out.println("Fetch at your command!");
  }
}
