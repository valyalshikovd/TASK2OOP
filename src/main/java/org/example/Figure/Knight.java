package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.MovingInterface;

import static org.example.Game.Cell.SIZE;

public class Knight extends Figure {
    public Knight(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }
    @Override
    public MovingInterface[] getMovingVariants() {
        MovingInterface[] res = new MovingInterface[SIZE];
        res[0] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() + 1);
        res[1] = arbitraryMove(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() - 1);
        res[2] = arbitraryMove(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() + 2);
        res[3] = arbitraryMove(cell.getCoordinates().getX() - 1, cell.getCoordinates().getY() + 2);
        res[4] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() + 1);
        res[5] = arbitraryMove(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() - 1);
        res[6] = arbitraryMove(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() - 2);
        res[7] = arbitraryMove(cell.getCoordinates().getX() - 1, cell.getCoordinates().getY() - 2);
        return res;
    }
    @Override
    public String getName() {
        return "K";
    }
}