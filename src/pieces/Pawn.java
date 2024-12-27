package pieces;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int direction = isWhite() ? -1 : 1;

        // Forward one spot
        if (startX + direction == endX && startY == endY && board[endX][endY] == null) {
            return true;
        }

        // Forward two spots
        if ((isWhite() && startX == 6 || !isWhite() && startX == 1) &&
                startX + 2 * direction == endX && startY == endY && board[endX][endY] == null &&
                board[startX + direction][startY] == null) {
            return true;
        }

        // Attack
        if (startX + direction == endX && Math.abs(startY - endY) == 1 &&
                board[endX][endY] != null && board[endX][endY].isWhite() != isWhite()) {
            return true;
        }

        return false; // Illegal move
    }

    @Override
    public String toString() {
        return isWhite() ? "P" : "p";
    }
}
