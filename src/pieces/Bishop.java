package pieces;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        //Check move
        if (dx == dy) {
            int stepX = Integer.signum(endX - startX);
            int stepY = Integer.signum(endY - startY);

            int x = startX + stepX;
            int y = startY + stepY;

            while (x != endX && y != endY) {
                if (board[x][y] != null) {
                    return false; // Path blocked
                }
                x += stepX;
                y += stepY;
            }
            return true; // Move correct
        }
        return false; // Illegal move
    }

    @Override
    public String toString() {
        return isWhite() ? "\u2657" : "\u265D";
    }
}
