package pieces;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        // Moves Knight
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            // Check if own piece is on the same spot
            return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite();
        }
        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "N" : "n";
    }
}
