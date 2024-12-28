package pieces;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        // King moves
        if ((dx <= 1 && dy <= 1) && (board[endX][endY] == null || board[endX][endY].isWhite() != isWhite())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "\u265A" : "\u2654";
    }
}
