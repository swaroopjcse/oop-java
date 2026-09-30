package ooad.numberduel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberDuelGameTest {

    private NumberDuelGame game;
    private Player anita;
    private Player vijay;

    @BeforeEach
    void setUp() {
        anita = new Player("Anita");
        vijay = new Player("Vijay");

        anita.setSecretTarget(25);
        vijay.setSecretTarget(70);

        game = new NumberDuelGame();
        game.startNewGame(anita, vijay);
    }

    @Test
    @DisplayName("Game correctly identifies guess that is TOO_HIGH")
    void testGuessTooHigh() {
        // Anita guesses Vijay's target (70) with 80
        Feedback feedback = game.processTurn(80);

        assertEquals(Feedback.TOO_HIGH, feedback);
        assertEquals(1, anita.getAttemptCount());
        assertFalse(game.isGameOver());
    }

    @Test
    @DisplayName("Game correctly identifies guess that is TOO_LOW")
    void testGuessTooLow() {
        // Anita guesses Vijay's target (70) with 50
        Feedback feedback = game.processTurn(50);

        assertEquals(Feedback.TOO_LOW, feedback);
        assertEquals(1, anita.getAttemptCount());
        assertFalse(game.isGameOver());
    }

    @Test
    @DisplayName("Turns alternate correctly after each non-winning guess")
    void testTurnAlternation() {
        assertEquals(anita, game.getActivePlayer());

        game.processTurn(50); // Anita's turn -> switches to Vijay
        assertEquals(vijay, game.getActivePlayer());

        game.processTurn(30); // Vijay guesses Anita's target (25) -> switches to Anita
        assertEquals(anita, game.getActivePlayer());
        assertEquals(1, vijay.getAttemptCount());
    }

    @Test
    @DisplayName("Direct hit ends game, awards 100 - k points to winner, and 0 to loser")
    void testDirectHitAndScoringFormula() {
        // Anita turn 1: Miss (k=1)
        game.processTurn(80); 
        // Vijay turn 1: Miss (k=1)
        game.processTurn(10); 
        // Anita turn 2: Miss (k=2)
        game.processTurn(60); 
        // Vijay turn 2: Miss (k=2)
        game.processTurn(40); 
        // Anita turn 3: Direct Hit (k=3) -> Target is 70
        Feedback feedback = game.processTurn(70);

        assertEquals(Feedback.DIRECT_HIT, feedback);
        assertTrue(game.isGameOver());

        GameSummary summary = game.getGameSummary();
        assertNotNull(summary);
        assertEquals("Anita", summary.getWinnerName());
        assertEquals(3, summary.getAttemptsUsed());
        
        // Winner gets 100 - k = 100 - 3 = 97 points
        assertEquals(97, summary.getPointsAwarded());
        assertEquals(97, anita.getProfile().getTotalPoints());
        assertEquals(1, anita.getProfile().getTotalWins());

        // Loser gets 0 points
        assertEquals(0, vijay.getProfile().getTotalPoints());
        assertEquals(0, vijay.getProfile().getTotalWins());
    }
}