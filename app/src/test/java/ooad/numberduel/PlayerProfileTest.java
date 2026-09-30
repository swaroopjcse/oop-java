package ooad.numberduel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerProfileTest {

    private PlayerProfile profile;

    @BeforeEach
    void setUp() {
        profile = new PlayerProfile();
    }

    @Test
    @DisplayName("Initial profile state should have 0 games, 0 wins, and 0 points")
    void testInitialState() {
        assertEquals(0, profile.getTotalGames());
        assertEquals(0, profile.getTotalWins());
        assertEquals(0, profile.getTotalPoints());
    }

    @Test
    @DisplayName("Adding match results updates points and increments games played")
    void testRecordMatchOutcome() {
        profile.addScore(85);
        profile.recordWin();
        profile.incrementGamesPlayed();

        assertEquals(1, profile.getTotalGames());
        assertEquals(1, profile.getTotalWins());
        assertEquals(85, profile.getTotalPoints());
    }

    @Test
    @DisplayName("Multiple match scores accumulate correctly")
    void testCumulativePoints() {
        profile.addScore(90);
        profile.addScore(75);
        profile.addScore(0);

        assertEquals(165, profile.getTotalPoints());
    }
}