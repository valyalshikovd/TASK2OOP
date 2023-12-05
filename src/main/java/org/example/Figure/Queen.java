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
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[8];
        for(int i = 0; i < Cell.SIZE; i++){
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
        Coordinates[][] res = new Coordinates[8][];
        System.out.println("------");
        for(int i = 0; i < Cell.SIZE; i++){
            System.out.println(cell.getNeighbours(i));
            res[i] = longMovementGetCoords(i);
        }
        System.out.println("------");
        return res;
    }
}
