package inheritance.animals;

public abstract class Animal {
  public abstract void eat();
  public abstract void sleep();
  public void breathe() {
    System.out.println("Inhale-Exhale");
  }
}
