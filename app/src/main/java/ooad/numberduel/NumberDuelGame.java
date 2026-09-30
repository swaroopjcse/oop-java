package ooad.numberduel;

import java.util.Random;

/**
 * Controller class managing the match rules, turn state, and score resolution.
 */
public class NumberDuelGame {
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private Player opponentPlayer;
    private boolean isGameOver;
    private GameSummary summary;
    private final Random random;

    public NumberDuelGame() {
        this.random = new Random();
        this.isGameOver = false;
    }

    public void startNewGame(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.isGameOver = false;
        this.summary = null;

        // Reset match counters
        player1.resetForNewGame();
        player2.resetForNewGame();

        // Assign random targets [0, 100] if not explicitly set
        if (player1.getSecretTarget() == 0) {
            player1.setSecretTarget(random.nextInt(101));
        }
        if (player2.getSecretTarget() == 0) {
            player2.setSecretTarget(random.nextInt(101));
        }

        // Player 1 starts by default
        this.activePlayer = player1;
        this.opponentPlayer = player2;
    }

    public Feedback processTurn(int guessedValue) {
        if (isGameOver) {
            throw new IllegalStateException("Game is already over. Start a new game to play.");
        }

        Guess currentGuess = activePlayer.makeGuess(guessedValue);
        Feedback feedback = evaluate(currentGuess, opponentPlayer.getSecretTarget());

        activePlayer.getHistory().add(currentGuess, feedback);

        if (feedback == Feedback.DIRECT_HIT) {
            isGameOver = true;
            this.summary = concludeGame();
        } else {
            switchTurn();
        }

        return feedback;
    }

    private Feedback evaluate(Guess guess, int target) {
        if (guess.getValue() > target) {
            return Feedback.TOO_HIGH;
        } else if (guess.getValue() < target) {
            return Feedback.TOO_LOW;
        } else {
            return Feedback.DIRECT_HIT;
        }
    }

    private void switchTurn() {
        Player temp = activePlayer;
        activePlayer = opponentPlayer;
        opponentPlayer = temp;
    }

    private GameSummary concludeGame() {
        int k = activePlayer.getAttemptCount();
        int winnerScore = Math.max(0, 100 - k);

        // Update profiles
        activePlayer.getProfile().addScore(winnerScore);
        activePlayer.getProfile().recordWin();
        activePlayer.getProfile().incrementGamesPlayed();

        opponentPlayer.getProfile().incrementGamesPlayed();

        return new GameSummary(activePlayer.getName(), opponentPlayer.getName(), k, winnerScore);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
    }

    public GameSummary getGameSummary() {
        return summary;
    }
}