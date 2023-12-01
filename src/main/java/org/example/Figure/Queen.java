package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.MovingInterface;

public class Queen extends Figure{
    public Queen(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[][] getMovingVariants() {
        MovingInterface[][] res = new MovingInterface[8][];
        res[0] = longMovementUp();
        res[1] = longMovementDown();
        res[2] = longMovementRight();
        res[3] = longMovementLeft();
        res[4] = longMovementLeftDown();
        res[5] = longMovementLeftUp();
        res[6] = longMovementRightUp();
        res[7] = longMovementRightDown();
        return res;
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[8][];
        res[0] = longMovementUpGetCoords();
        res[1] = longMovementDownGetCoords();
        res[2] = longMovementRightGetCoords();
        res[3] = longMovementLeftGetCoords();
        res[4] = longMovementLeftDownGetCoords();
        res[5] = longMovementLeftUpGetCoords();
        res[6] = longMovementRightUpGetCoords();
        res[7] = longMovementRightDownGetCoords();

        return res;
    }
}
