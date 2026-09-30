package polymorphism.states;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatesTester {

  public static void main(String[] args) {
    List<State> states = new ArrayList<>();

    states.add(new State("Goa", 158300, 3702));
    states.add(new State("Maharashtra", 127528000, 307713));
    states.add(new State("Karnataka", 68115000, 191791));
    Collections.sort(states); // sorts using State.compareTo

    printStates(states);

    Comparator<State> comp = (s1, s2) -> -((Integer) s1.getArea()).compareTo(s2.getArea());
    Collections.sort(states, comp); // sorts using the given comparator

    printStates(states);
  }

  private static void printStates(List<State> states) {
    for (int i = 0; i < states.size(); i++)
      System.out.print(states.get(i).getName() + "\t");
    System.out.println();
  }

}
