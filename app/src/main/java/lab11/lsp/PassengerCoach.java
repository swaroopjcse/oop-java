package lab11.lsp;

import java.util.HashMap;
import java.util.Map;

public class PassengerCoach {
  protected final String coachId;
  protected final int capacity;
  protected final Map<Integer, String> berthAssignments = new HashMap<>();

  public PassengerCoach(String coachId, int capacity) {
    this.coachId = coachId;
    this.capacity = capacity;
  }

  public void assignBerth(int berthNumber, String passengerName) {
    if (berthNumber < 1 || berthNumber > capacity) {
      throw new IllegalArgumentException("Invalid berth number: " + berthNumber);
    }
    berthAssignments.put(berthNumber, passengerName);
  }

  public int getOccupiedCount() {
    return berthAssignments.size();
  }
}
