package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.ArbitraryMoving;
import org.example.moving.Kill;
import org.example.moving.MovingInterface;

public class Knight extends Figure {
    public Knight(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res = new Coordinates[8][];
        res[0] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() + 1);
        res[1] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 2, cell.getCoordinates().getY() - 1);
        res[2] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() + 2);
        res[3] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 1, cell.getCoordinates().getY() + 2);
        res[4] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() + 1);
        res[5] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 2, cell.getCoordinates().getY() - 1);
        res[6] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() - 2);
        res[7] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 1, cell.getCoordinates().getY() - 2);
        return res;
    }

    @Override
    public MovingInterface[][] getMovingVariants() {
        MovingInterface[][] res = new MovingInterface[8][];
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

}
