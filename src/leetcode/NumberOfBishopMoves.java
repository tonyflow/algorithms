package leetcode;

public class NumberOfBishopMoves {

    /**
     * There are three possible cases here.
     * 1. Either the bishop is on the same square as the target position. In that case there
     * are no moves to be made
     * 2. The bishop is on a black square and the target position is a white square. In that case
     * we return -1 since we cannot reach the target square
     * 3. The bishop is on the same diagonal as the target. In that case the bishop can reach the target
     * in one move
     * 4. The bishop is NOT on the same diagonal as the target. In that case he needs 2 moves to reach the
     * target
     * The diagonals are characterized by this property. If a cell is at (x,y) then the coordinates of all
     * the elements in all its two diagonals differ by one.
     * <p>
     * Let's check these conditions then
     */
    int moves(int xPos,
              int yPos,
              int bishopX,
              int bishopY) {

        if (color(xPos, yPos) != color(bishopX, bishopY))
            return -1;
        else if (sameDiagonal(xPos, yPos, bishopX, bishopY))
            return 1;
        else return 2;
    }

    private boolean sameDiagonal(int xPos, int yPos, int bishopX, int bishopY) {
        return false;
    }

    private int color(int xPos, int yPos) {
        return 1;
    }
}
