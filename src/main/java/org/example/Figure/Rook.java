package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Color;
import org.example.Game.Coordinates;
import org.example.moving.*;


public class Rook extends Figure{
    public Rook(Cell cell, boolean isWhite, Board board) {
        super(cell,  isWhite, board);
    }

    public MovingInterface[][] getMovingVariants() {
        MovingInterface[][] res = new MovingInterface[4][];
        res[0] = longMovementUp();
        res[1] = longMovementDown();
        res[2] = longMovementRight();
        res[3] = longMovementLeft();
        return res;
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[4][];
        res[0] = longMovementUpGetCoords();
        res[1] = longMovementDownGetCoords();
        res[2] = longMovementRightGetCoords();
        res[3] = longMovementLeftGetCoords();

        return res;
    }
}
