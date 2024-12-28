package pieces;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Piece[][] board) {

        if (startRow != endRow && startCol != endCol) {
            System.out.println("Movement is neither vertical or horizontal.");
            return false;
        }

        // Directions: rowDir, colDir
        int rowDir = Integer.compare(endRow, startRow);
        int colDir = Integer.compare(endCol, startCol);

        // Current position during iteration
        int currentRow = startRow + rowDir;
        int currentCol = startCol + colDir;

        while (currentRow != endRow || currentCol != endCol) {

            // If anything is in the way, the movement is illegal
            if (board[currentRow][currentCol] != null) {
                System.out.println("Ruch zablokowany przez: " + board[currentRow][currentCol]);
                return false;
            }

            currentRow += rowDir;
            currentCol += colDir;
        }

        Piece targetPiece = board[endRow][endCol];

        // If the square is empty or there is a piece of a different color there, the move is legal
        return (targetPiece == null) || (targetPiece.isWhite() != this.isWhite());
    }

    @Override
    public String toString() {
        return isWhite() ? "\u2656" : "\u265C ";
    }
}
