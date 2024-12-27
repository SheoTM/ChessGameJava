package game;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private boolean whiteTurn;

    public ChessGame() {
        board = new Board();
        whiteTurn = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");

        while (true) {
            board.printBoard();
            System.out.println((whiteTurn ? "White's" : "Black's") + " turn. Enter your move (e.g., e2e4):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Game exited. Goodbye!");
                break;
            }

            try {
                Move move = new Move(input, whiteTurn);
                board.move(move);
                whiteTurn = !whiteTurn; // Switch turn
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
