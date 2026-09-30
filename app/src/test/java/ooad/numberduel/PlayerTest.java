package ooad.numberduel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Anita");
        player.setSecretTarget(42);
    }

    @Test
    @DisplayName("Player starts with 0 attempts and valid assigned target")
    void testInitialPlayerState() {
        assertEquals("Anita", player.getName());
        assertEquals(42, player.getSecretTarget());
        assertEquals(0, player.getAttemptCount());
        assertNotNull(player.getProfile());
        assertNotNull(player.getHistory());
    }

    @Test
    @DisplayName("Making a guess increments attempt counter and creates Guess object")
    void testMakeGuess() {
        Guess guess1 = player.makeGuess(50);
        assertEquals(1, player.getAttemptCount());
        assertEquals(50, guess1.getValue());
        assertEquals(1, guess1.getAttemptNum());

        Guess guess2 = player.makeGuess(30);
        assertEquals(2, player.getAttemptCount());
        assertEquals(30, guess2.getValue());
        assertEquals(2, guess2.getAttemptNum());
    }
}