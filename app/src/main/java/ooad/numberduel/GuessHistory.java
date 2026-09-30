package ooad.numberduel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maintains a log of guesses and feedback within a match.
 */
public class GuessHistory {

    public record HistoryEntry(Guess guess, Feedback feedback) {}

    private final List<HistoryEntry> entries;

    public GuessHistory() {
        this.entries = new ArrayList<>();
    }

    public void add(Guess guess, Feedback feedback) {
        entries.add(new HistoryEntry(guess, feedback));
    }

    public List<HistoryEntry> getHistory() {
        return Collections.unmodifiableList(entries);
    }

    public void clear() {
        entries.clear();
    }
}