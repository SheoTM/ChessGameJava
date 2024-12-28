package game;
import pieces.*;

public class Board {
    private final Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializePieces();
    }

    private void initializePieces() {

        // Black figures
        board[0][0] = new pieces.Rook(false);
        board[0][1] = new pieces.Knight(false);
        board[0][2] = new pieces.Bishop(false);
        board[0][3] = new pieces.Queen(false);
        board[0][4] = new pieces.King(false);
        board[0][5] = new pieces.Bishop(false);
        board[0][6] = new pieces.Knight(false);
        board[0][7] = new pieces.Rook(false);

        //Black pawns
        for (int x = 0; x < 8; x++) {
            board[1][x] = new pieces.Pawn(false);
        }
        //White pawns
        for (int x = 0; x < 8; x++) {
            board[6][x] = new pieces.Pawn(true);
        }
        //White figures
        board[7][0] = new pieces.Rook(true);
        board[7][1] = new pieces.Knight(true);
        board[7][2] = new pieces.Bishop(true);
        board[7][3] = new pieces.Queen(true);
        board[7][4] = new pieces.King(true);
        board[7][5] = new pieces.Bishop(true);
        board[7][6] = new pieces.Knight(true);
        board[7][7] = new pieces.Rook(true);
    }


    public void printBoard() {
        System.out.println("   A B C D E F G H");

        for (int y = 0; y < 8; y++) {
            System.out.print((8 - y) + " ");
            for (int x = 0; x < 8; x++) {
                System.out.print("|");
                if (board[y][x] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(board[y][x]);
                }
            }
            System.out.println("| " + (8 - y));
        }

        System.out.println("   A B C D E F G H");
    }

    public void move(Move move) {
        Piece piece = board[move.getStartY()][move.getStartX()];
        if (piece == null) {
            throw new IllegalArgumentException("No piece to move.");
        }

        System.out.println("Piece isWhite: " + piece.isWhite());
        System.out.println("Move isWhiteTurn: " + move.isWhiteTurn());
        if (piece.isWhite() != move.isWhiteTurn()) {
            throw new IllegalArgumentException("Wrong player turn.");
        }

        if (piece.isValidMove(move.getStartY(), move.getStartX(), move.getEndY(), move.getEndX(), board)) {
            Piece targetPiece = board[move.getEndY()][move.getEndX()];
            if (targetPiece != null && targetPiece.isWhite() == move.isWhiteTurn()) {
                throw new IllegalArgumentException("Cannot capture your own piece.");
            }

            board[move.getEndY()][move.getEndX()] = piece;
            board[move.getStartY()][move.getStartX()] = null;
        } else {
            throw new IllegalArgumentException("Invalid move for this piece.");
        }
    }
}