package inheritance;

public class Diamond {
  public interface A {
    public default void foo() {
      System.out.println("A::foo");
    }
  }

  public interface B extends A {

    public default void foo() {
      System.out.println("B::foo");
    }
  }

  public interface C extends A {

    public default void foo() {
      System.out.println("C::foo");
    }
  }

  public class D implements B, C {

    @Override
    public void foo() {
      B.super.foo();
    }

  }
}
