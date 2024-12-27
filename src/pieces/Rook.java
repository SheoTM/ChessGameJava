package pieces;
//TODO: Prawidłowy ruch wieżą, pewnie innymi figurami też.
public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {

        if (startX == endX || startY == endY) {

            int dx = Integer.signum(endX - startX);
            int dy = Integer.signum(endY - startY);

            int x = startX + dx;
            int y = startY + dy;

            while (x != endX || y != endY) {
                if (board[y][x] != null) {
                    return false;
                }
                x += dx;
                y += dy;
            }

            return board[endY][endX] == null || board[endY][endX].isWhite() != this.isWhite();
        }

        System.out.println("Ruch nie jest pionowy ani poziomy");
        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "R" : "r";
    }
}
