package lab11.lsp;

import java.util.List;

public class TrainOccupancyReporter {
  public static int countTotalPassengers(List<PassengerCoach> rake) {
    int total = 0;
    for (PassengerCoach coach : rake) {
      total += coach.getOccupiedCount();
    }
    return total;
  }

  public static void main(String[] args) {
    PassengerCoach sleeper = new PassengerCoach("S1", 72);
    sleeper.assignBerth(14, "Ananya Rao");

    GeneralUnreservedCoach general = new GeneralUnreservedCoach("GS1", 100);
    general.boardUnreservedPassenger();

    System.out.println("Total onboard: " + countTotalPassengers(List.of(sleeper, general)));
  }
}