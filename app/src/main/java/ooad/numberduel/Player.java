package ooad.numberduel;

/**
 * Encapsulates player state, target number, and match attempts.
 */
public class Player {
    private final String name;
    private int secretTarget;
    private int attemptCount;
    private final PlayerProfile profile;
    private final GuessHistory history;

    public Player(String name) {
        this.name = name;
        this.attemptCount = 0;
        this.profile = new PlayerProfile();
        this.history = new GuessHistory();
    }

    public Guess makeGuess(int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Guess must be between 0 and 100 inclusive. Given: " + value);
        }
        this.attemptCount++;
        return new Guess(value, this.attemptCount);
    }

    public void resetForNewGame() {
        this.attemptCount = 0;
        this.history.clear();
    }

    public String getName() {
        return name;
    }

    public int getSecretTarget() {
        return secretTarget;
    }

    public void setSecretTarget(int secretTarget) {
        this.secretTarget = secretTarget;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public PlayerProfile getProfile() {
        return profile;
    }

    public GuessHistory getHistory() {
        return history;
    }
}