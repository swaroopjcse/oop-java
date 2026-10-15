package inheritance.animals;

public class Cat extends Feline implements Pet {
  @Override
  public void sleep() {
    System.out.println("Like a fur ball");
  }

  @Override
  public void play() {
    System.out.println("Purr at my whim!");
  }
}
