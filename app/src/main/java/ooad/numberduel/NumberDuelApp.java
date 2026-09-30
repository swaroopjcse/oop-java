package ooad.numberduel;

import java.util.Scanner;

/**
 * Text-based console presentation layer and application entry point.
 */
public class NumberDuelApp {

    private final Scanner scanner;
    private final NumberDuelGame game;

    public NumberDuelApp() {
        this.scanner = new Scanner(System.in);
        this.game = new NumberDuelGame();
    }

    public static void main(String[] args) {
        NumberDuelApp app = new NumberDuelApp();
        app.run();
    }

    public void run() {
        System.out.println("=========================================");
        System.out.println("       WELCOME TO THE NUMBER DUEL        ");
        System.out.println("=========================================");

        Player player1 = createPlayer("Enter Name for Player 1: ");
        Player player2 = createPlayer("Enter Name for Player 2: ");

        boolean keepPlaying = true;
        while (keepPlaying) {
            playMatch(player1, player2);
            keepPlaying = promptPlayAgain();
        }

        displayCareerStats(player1, player2);
        System.out.println("Thanks for playing The Number Duel!");
    }

    private void playMatch(Player p1, Player p2) {
        game.startNewGame(p1, p2);

        System.out.println("\n--- A new match has started! ---");
        System.out.println("Secret targets between 0 and 100 have been assigned.");

        while (!game.isGameOver()) {
            Player current = game.getActivePlayer();
            System.out.printf("\n[%s's Turn] Enter your guess (0-100): ", current.getName());

            int guessedValue = readValidInteger();

            try {
                Feedback feedback = game.processTurn(guessedValue);
                System.out.println("-> Feedback: " + feedback.getDisplayMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println("-> Error: " + ex.getMessage());
            }
        }

        GameSummary summary = game.getGameSummary();
        if (summary != null) {
            summary.displaySummary();
        }
    }

    private Player createPlayer(String prompt) {
        System.out.print(prompt);
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be blank. Try again: ");
            name = scanner.nextLine().trim();
        }
        return new Player(name);
    }

    private int readValidInteger() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid integer. Please enter a whole number: ");
            }
        }
    }

    private boolean promptPlayAgain() {
        System.out.print("Play another match with the same players? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.startsWith("y");
    }

    private void displayCareerStats(Player p1, Player p2) {
        System.out.println("\n=========================================");
        System.out.println("          FINAL CAREER STANDINGS         ");
        System.out.println("=========================================");
        printPlayerStats(p1);
        printPlayerStats(p2);
        System.out.println("=========================================\n");
    }

    private void printPlayerStats(Player player) {
        System.out.printf("%s -> Games: %d | Wins: %d | Total Points: %d pts\n",
                player.getName(),
                player.getProfile().getTotalGames(),
                player.getProfile().getTotalWins(),
                player.getProfile().getTotalPoints());
    }
}