package pieces;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        // move like Bishop/Rook
        if (dx == dy || startX == endX || startY == endY) {
            int stepX = Integer.signum(endX - startX);
            int stepY = Integer.signum(endY - startY);

            int x = startX + stepX;
            int y = startY + stepY;

            while (x != endX || y != endY) {
                if (board[x][y] != null) {
                    return false; // Path blocked
                }
                x += stepX;
                y += stepY;
            }
            return true; // Legal move
        }
        return false; // Illegal move
    }

    @Override
    public String toString() {
        return isWhite() ? "\u2655" : "\u265B";
    }
}
