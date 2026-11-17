package lab11.lsp;

public class GeneralUnreservedCoach extends PassengerCoach {
  private int unreservedHeadcount = 0;

  public GeneralUnreservedCoach(String coachId, int capacity) {
    super(coachId, capacity);
  }

  @Override
  public void assignBerth(int berthNumber, String passengerName) {
    throw new UnsupportedOperationException("Unreserved coaches do not support numbered berth assignments!");
  }

  public void boardUnreservedPassenger() {
    if (unreservedHeadcount < capacity) {
      unreservedHeadcount++;
    }
  }

  @Override
  public int getOccupiedCount() {
    return unreservedHeadcount;
  }
}