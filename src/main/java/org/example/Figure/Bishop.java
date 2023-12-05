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
        for(int i = 1; i < Cell.SIZE; i += 2){
            res[i/2] = longMovementGetCoords(i);
        }
        return res;
    }

    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[8];
        for(int i = 1; i < Cell.SIZE; i += 2){
            res[i/2] = longMovement(i);
        }
        return res;
    }

    @Override
    public String getName() {
        return "B";
    }
}