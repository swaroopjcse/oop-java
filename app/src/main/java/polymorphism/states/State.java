package polymorphism.states;

public class State implements Comparable<State> {
  private String name;
  private int population;
  private int area; // sq km

  public State(String name, int population, int area) {
    this.name = name;
    this.population = population;
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public int getPopulation() {
    return population;
  }

  public int getArea() {
    return area;
  }

  @Override
  public int compareTo(State other) {
    int ans = 0;
    if (this.population < other.population)
      ans = -1;
    else if (this.population > other.population)
      ans = 1;

    return ans;
  }
}
