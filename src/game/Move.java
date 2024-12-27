package game;

public class Move {
    private int startX, startY;
    private int endX, endY;
    private boolean isWhiteTurn;

    public Move(String move, boolean isWhiteTurn) {
        this.isWhiteTurn = isWhiteTurn;
        if (move.length() != 4) {
            throw new IllegalArgumentException("Move must be 4 characters long");
        }

        this.startY = 8 - Character.getNumericValue(move.charAt(1));
        this.startX = move.charAt(0) - 'a';
        this.endY = 8 - Character.getNumericValue(move.charAt(3));
        this.endX = move.charAt(2) - 'a';
        this.isWhiteTurn = isWhiteTurn;

        if (!isValidCoordinates()) {
            throw new IllegalArgumentException("Move out of bounds.");
        }
    }

    private boolean isValidCoordinates() {
        return startX >= 0 && startX < 8 && startY >= 0 && startY < 8 &&
                endX >= 0 && endX < 8 && endY >= 0 && endY < 8;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }
}
