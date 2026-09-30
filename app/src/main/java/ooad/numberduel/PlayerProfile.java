package ooad.numberduel;

/**
 * Manages persistent career statistics for a player.
 */
public class PlayerProfile {
    private int totalPoints;
    private int totalWins;
    private int totalGames;

    public PlayerProfile() {
        this.totalPoints = 0;
        this.totalWins = 0;
        this.totalGames = 0;
    }

    public void addScore(int points) {
        if (points > 0) {
            this.totalPoints += points;
        }
    }

    public void recordWin() {
        this.totalWins++;
    }

    public void incrementGamesPlayed() {
        this.totalGames++;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalGames() {
        return totalGames;
    }
}