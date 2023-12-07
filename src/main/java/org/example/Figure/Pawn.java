package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.*;

public class Pawn extends Figure {
    public Pawn(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[3];
        if (cell == null) {
            return null;
        }
        if (!isWhite) {
            res[0] = createDefaultMoving(Cell.UP);
            res[1] = createKillDecorator(Cell.UP);
            res[2] = createKillDecorator(Cell.UP);
            return res;
        }
        res[0] = createDefaultMoving(Cell.DOWN);
        res[1] = createKillDecorator(Cell.LEFT_DOWN);
        res[2] = createKillDecorator(Cell.RIGHT_DOWN);

        return res;
    }
    @Override
    public String getName() {
        return "P";
    }
}