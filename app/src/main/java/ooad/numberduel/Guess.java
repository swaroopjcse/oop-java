package ooad.numberduel;

/**
 * Immutable value object representing a single guess attempt.
 */
public class Guess {
    private final int value;
    private final int attemptNum;

    public Guess(int value, int attemptNum) {
        this.value = value;
        this.attemptNum = attemptNum;
    }

    public int getValue() {
        return value;
    }

    public int getAttemptNum() {
        return attemptNum;
    }
}