package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.MovingInterface;

import static org.example.Game.Cell.SIZE;

public class Queen extends Figure{
    public Queen(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[SIZE];
        for(int i = 0; i < SIZE; i++){
            res[i] = longMovement(i);
        }
        return res;
    }
    @Override
    public String getName() {
        return "Q";
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[SIZE][];
        for(int i = 0; i < SIZE; i++){
            res[i] = longMovementGetCoords(i);
        }
        return res;
    }
}