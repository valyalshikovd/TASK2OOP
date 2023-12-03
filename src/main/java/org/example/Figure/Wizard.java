package org.example.Figure;

import org.example.Game.Board;
import org.example.Game.Cell;
import org.example.Game.Coordinates;
import org.example.moving.MovingInterface;

public class Wizard extends Figure{
    public Wizard(Cell cell, boolean isWhite, Board board) {
        super(cell, isWhite, board);
    }

    @Override
    public Coordinates[][] getMovingVariantsOnCoords() {
        Coordinates[][] res =  new Coordinates[12][];

        if(cell.getLeftUPCell()!= null && cell.getLeftUPCell().getFigure() != null && cell.getLeftUPCell().getFigure().getIsWhite() != isWhite ){
            res[0] = new Coordinates[]{cell.getLeftUPCell().getCoordinates()};

        }
        if(cell.getLeftUPCell()!= null&& cell.getLeftUPCell().getFigure() == null){
            res[0] = new Coordinates[]{cell.getLeftUPCell().getCoordinates()};
        }

        if(cell.getLeftDownCell()!= null && cell.getLeftDownCell().getFigure() != null && cell.getLeftDownCell().getFigure().getIsWhite() != isWhite ){
            res[1] =  new Coordinates[]{cell.getLeftDownCell().getCoordinates()};

        }
        if(cell.getLeftDownCell()!= null&& cell.getLeftDownCell().getFigure() == null){
            res[1] = new Coordinates[]{cell.getLeftDownCell().getCoordinates()};
        }

        if(cell.getRightDownCell()!= null && cell.getRightDownCell().getFigure() != null && cell.getRightDownCell().getFigure().getIsWhite() != isWhite ){
            res[2] =  new Coordinates[]{cell.getRightDownCell().getCoordinates()};

        }
        if(cell.getRightDownCell()!= null&& cell.getRightDownCell().getFigure() == null){
            res[2] =  new Coordinates[]{cell.getRightDownCell().getCoordinates()};
        }



        if(cell.getRightUPCell()!= null && cell.getRightUPCell().getFigure() != null && cell.getRightUPCell().getFigure().getIsWhite() != isWhite ){
            res[3] =  new Coordinates[]{cell.getRightUPCell().getCoordinates()};

        }
        if(cell.getRightUPCell()!= null&& cell.getRightUPCell().getFigure() == null){
            res[3] =  new Coordinates[]{cell.getRightUPCell().getCoordinates()};
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
    public MovingInterface[][] getMovingVariants() {
        return new MovingInterface[0][];
    }
}
