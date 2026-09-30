package ooad.numberduel;

/**
 * Represents the evaluation result of a guess against a target number.
 */
public enum Feedback {
    TOO_HIGH("Too High! Try a smaller number."),
    TOO_LOW("Too Low! Try a larger number."),
    DIRECT_HIT("Direct Hit! Congratulations, you guessed the number!");

    private final String displayMessage;

    Feedback(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }
}