package ooad.numberduel;

/**
 * Encapsulates the final results of a concluded duel.
 */
public class GameSummary {
    private final String winnerName;
    private final String loserName;
    private final int attemptsUsed;
    private final int pointsAwarded;

    public GameSummary(String winnerName, String loserName, int attemptsUsed, int pointsAwarded) {
        this.winnerName = winnerName;
        this.loserName = loserName;
        this.attemptsUsed = attemptsUsed;
        this.pointsAwarded = pointsAwarded;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String getLoserName() {
        return loserName;
    }

    public int getAttemptsUsed() {
        return attemptsUsed;
    }

    public int getPointsAwarded() {
        return pointsAwarded;
    }

    public void displaySummary() {
        System.out.println("\n=================================");
        System.out.println("          GAME SUMMARY           ");
        System.out.println("=================================");
        System.out.println("Winner: " + winnerName);
        System.out.println("Attempts Taken: " + attemptsUsed);
        System.out.println("Points Awarded: " + pointsAwarded + " pts (100 - " + attemptsUsed + ")");
        System.out.println("Loser: " + loserName + " (0 pts)");
        System.out.println("=================================\n");
    }
}