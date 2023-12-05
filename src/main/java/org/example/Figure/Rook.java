package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.*;

public class Rook extends Figure{
    public Rook(Cell cell, boolean isWhite, Board board) {
        super(cell,  isWhite, board);
    }

    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[4];

        for(int i = 0; i < Cell.SIZE; i += 2){
            res[i/2] = longMovement(i);
        }
        return res;
    }

    @Override
    public String getName() {
        return "R";
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[4][];
        for(int i = 0; i < Cell.SIZE; i += 2){
            res[i/2] = longMovementGetCoords(i);
        }
        return res;
    }
}
