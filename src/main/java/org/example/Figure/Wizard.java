package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.*;

public class Wizard extends Figure{
    public Wizard(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res =  new Coordinates[12][];

        for(int i = 1; i < Cell.SIZE; i += 2){
            res[i/2] = new Coordinates[]{cell.getNeighbours(i).getCoordinates()};
        }
        res[4] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 3, cell.getCoordinates().getY() + 1);
        res[5] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 3, cell.getCoordinates().getY() - 1);
        res[6] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 3, cell.getCoordinates().getY() + 1);
        res[7] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 3, cell.getCoordinates().getY() - 1);

        res[8] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() + 3);
        res[9] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 1 , cell.getCoordinates().getY() + 3);
        res[10] = arbitraryMoveGetCoords(cell.getCoordinates().getX() + 1 , cell.getCoordinates().getY() - 3);
        res[11] = arbitraryMoveGetCoords(cell.getCoordinates().getX() - 1 , cell.getCoordinates().getY() - 3);
        return res;
    }

    @Override
    public MovingInterface[] getMovingVariants() {

        MovingInterface[] res =  new MovingInterface[12];

        for(int i = 1; i < Cell.SIZE; i += 2){
            if(cell.getNeighbours(i) != null && cell.getNeighbours(i).getFigure() != null && cell.getNeighbours(i).getFigure().getIsWhite() != isWhite){
                res[i/2] = new KillDecorator(new DefaultMoving(this, i), cell.getNeighbours(i), cell.getNeighbours(i).getFigure());
            }
            if(cell.getNeighbours(i) != null && cell.getNeighbours(i).getFigure() == null){
                res[i/2] = new DefaultMoving(this, i);
            }
        }
        res[4] = arbitraryMove(cell.getCoordinates().getX() + 3, cell.getCoordinates().getY() + 1);
        res[5] = arbitraryMove(cell.getCoordinates().getX() + 3, cell.getCoordinates().getY() - 1);
        res[6] = arbitraryMove(cell.getCoordinates().getX() - 3, cell.getCoordinates().getY() + 1);
        res[7] = arbitraryMove(cell.getCoordinates().getX() - 3, cell.getCoordinates().getY() - 1);

        res[8] = arbitraryMove(cell.getCoordinates().getX() + 1, cell.getCoordinates().getY() + 3);
        res[9] = arbitraryMove(cell.getCoordinates().getX() - 1 , cell.getCoordinates().getY() + 3);
        res[10] = arbitraryMove(cell.getCoordinates().getX() + 1 , cell.getCoordinates().getY() - 3);
        res[11] = arbitraryMove(cell.getCoordinates().getX() - 1 , cell.getCoordinates().getY() - 3);
        return res;
    }

    @Override
    public String getName() {
        return "W";
    }
}
