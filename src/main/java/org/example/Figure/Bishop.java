package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.MovingInterface;

public class Bishop extends Figure{
    public Bishop(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[4][];

        res[0] = longMovementLeftDownGetCoords();
        res[1] = longMovementLeftUpGetCoords();
        res[2] = longMovementRightUpGetCoords();
        res[3] = longMovementRightDownGetCoords();

        return res;
    }

    @Override
    public MovingInterface[][] getMovingVariants() {
        MovingInterface[][] res = new MovingInterface[8][];

        res[0] = longMovementLeftDown();
        res[1] = longMovementLeftUp();
        res[2] = longMovementRightUp();
        res[3] = longMovementRightDown();
        return res;
    }
}
